package de.smarthome.smartux;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import de.smarthome.smartux.Module.DynamicBeanRegistrar;
import de.smarthome.smartux.Module.GarbageModule;
import de.smarthome.smartux.Module.ModuleManager;
import de.smarthome.smartux.Module.ShutterModule;
import de.smarthome.smartux.Module.SteinelPraesenzModule;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
import de.smarthome.smartux.xmlSchemaData.DeviceSpecification;
import de.smarthome.smartux.xmlSchemaData.Openhab;
import de.smarthome.smartux.xmlSchemaData.Device.Channel;
import de.smarthome.smartux.xmlSchemaData.Devices.Device;
import jakarta.annotation.PostConstruct;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataLoader {

    @Autowired
    OpenhabRestService openhabRestService;

    @Autowired
    OpenhabItemRegister openhabItemRegister;

    @Autowired
    ModuleManager moduleManager;

    @Autowired
    DynamicBeanRegistrar beanRegistrar;

    @Autowired
    private SimpMessagingTemplate template;

    @PostConstruct
    private void loader() {
        File xmlFile = new File("C:\\Projekte\\xml2OH\\SmartHomeConfiguration.xml");
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(Openhab.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Openhab openhab = (Openhab) jaxbUnmarshaller.unmarshal(xmlFile);

            for (Device device : openhab.getDevices().getDevice()) {

                String name = (device.getDeviceArea() + "_" + device.getDeviceFunction() + "_" + device.getDeviceName())
                        .replace(" ", "_").trim();
                ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(name);
                name = new String(byteBuffer.array(), StandardCharsets.UTF_8).trim();

                switch (device.getDeviceSpecification()) {
                    case DeviceSpecification.ICAL_BINDING:
                        GarbageModule gb = new GarbageModule(openhabRestService, openhabItemRegister, template);

                        gb.addItem("TKR_R_CALENDAR_Tonne_Biomuell");
                        gb.addItem("TKR_R_CALENDAR_Tonne_Restmuell");
                        gb.addItem("TKR_R_CALENDAR_Tonne_Plastikmuell");
                        gb.addItem("TKR_R_CALENDAR_Tonne_Papiermuell");

                        gb.setName(name);
                        beanRegistrar.registerBean(name, gb);
                        log.info("GarbageModule with name [" + name + "] was registered");
                        break;

                    case DeviceSpecification.ROLLADEN_MDTKNX:
                        ShutterModule sm = new ShutterModule(openhabRestService, openhabItemRegister, template);
                        for (int i = 0; i <= 9; i++) {
                            final int currentIndex = i;
                            device.getChannel()
                                    .stream()
                                    .filter(s -> s.getChannelId() == currentIndex)
                                    .findFirst()
                                    .ifPresent(channel -> sm.addItem(channel.getLink())); 
                        }

                        sm.setName(name);
                        beanRegistrar.registerBean(name, sm);
                        log.info("ShutterModule with name [" + name + "] was registered");

                        break;
                    case DeviceSpecification.STEINEL_TRUE_PRÄSENZ:
                        SteinelPraesenzModule sp = new SteinelPraesenzModule(openhabRestService, openhabItemRegister,
                                template);
                                for (int i = 0; i <= 9; i++) {
                                    final int currentIndex = i;
                                    device.getChannel()
                                            .stream()
                                            .filter(s -> s.getChannelId() == currentIndex)
                                            .findFirst()
                                            .ifPresent(channel -> sp.addItem(channel.getLink())); 
                                }

                        sp.setName(name);
                        beanRegistrar.registerBean(name, sp);
                        log.info("SteinelPraesenzModule with name [" + name + "] was registered");

                        break;
                    default:
                        break;
                }
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
