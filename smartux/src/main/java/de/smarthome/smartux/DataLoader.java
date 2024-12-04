package de.smarthome.smartux;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

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

    @PostConstruct
    private void loader() {
        File xmlFile = new File("C:\\Projekte\\xml2OH\\SmartHomeConfiguration.xml");
        JAXBContext jaxbContext;
       
        try {
            jaxbContext = JAXBContext.newInstance(Openhab.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Openhab openhab = (Openhab) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println(openhab);

            for (Device device : openhab.getDevices().getDevice()) {

                switch (device.getDeviceSpecification()) {
                    case DeviceSpecification.ICAL_BINDING:
                        break;
                    case DeviceSpecification.ROLLADEN_MDTKNX:
                        break;
                    case DeviceSpecification.STEINEL_TRUE_PRÄSENZ:
                        SteinelPraesenzModule sp = new SteinelPraesenzModule(openhabRestService, openhabItemRegister);
                        sp.setPräsenzTag(device.getChannel().stream().filter(s -> s.getChannelId() == 1).findFirst().get().getLink());
                        sp.setTruePräsenzTag(device.getChannel().stream().filter(s -> s.getChannelId() == 2).findFirst().get().getLink());
                        sp.setTemperaturTag(device.getChannel().stream().filter(s -> s.getChannelId() == 3).findFirst().get().getLink());
                        sp.setLuftfeuchtigkeitTag(device.getChannel().stream().filter(s -> s.getChannelId() == 4).findFirst().get().getLink());
                        sp.setRelativeLuftdruckTag(device.getChannel().stream().filter(s -> s.getChannelId() == 5).findFirst().get().getLink());
                        sp.setAbsoluterLuftdruckTag(device.getChannel().stream().filter(s -> s.getChannelId() == 6).findFirst().get().getLink());
                        sp.setCo2Tag(device.getChannel().stream().filter(s -> s.getChannelId() == 7).findFirst().get().getLink());
                        sp.setVocTag(device.getChannel().stream().filter(s -> s.getChannelId() == 8).findFirst().get().getLink());

                        String name = (device.getDeviceArea() + "_" + device.getDeviceFunction() + "_" + device.getDeviceName()).replace(" ", "_").trim();
                        ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(name);
                        name = new String(byteBuffer.array(), StandardCharsets.UTF_8);
                        moduleManager.add(name.trim(), sp);
                        log.info("Steinel Präsenz Module with name [" + name+  "] was registered");
                        
                        break;
                    default:
                        break;
                }

                for (Channel channel : device.getChannel()) {
                    OpenhabItem i = openhabRestService.getItemDetails(channel.getLink()).block();
                    i.toString();

                }

            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
