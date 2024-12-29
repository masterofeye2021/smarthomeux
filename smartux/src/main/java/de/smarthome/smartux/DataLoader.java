package de.smarthome.smartux;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import de.smarthome.smartux.Module.DateTimeModule;
import de.smarthome.smartux.Module.DynamicBeanRegistrar;
import de.smarthome.smartux.Module.EkeyModule;
import de.smarthome.smartux.Module.GarbageModule;
import de.smarthome.smartux.Module.LightFullModule;
import de.smarthome.smartux.Module.ModuleTemplate;
import de.smarthome.smartux.Module.PowerModule;
import de.smarthome.smartux.Module.ShutterModule;
import de.smarthome.smartux.Module.SteinelPraesenzModule;
import de.smarthome.smartux.xmlSchemaData.DeviceSpecification;
import de.smarthome.smartux.xmlSchemaData.Devices.Device;
import de.smarthome.smartux.xmlSchemaData.Openhab;
import jakarta.annotation.PostConstruct;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataLoader {

    @Autowired
    private OpenhabRestService openhabRestService;

    @Autowired
    private OpenhabItemRegister openhabItemRegister;

    @Autowired
    private DynamicBeanRegistrar beanRegistrar;

    @Autowired
    private SimpMessagingTemplate template;

    @PostConstruct
    private void loader() {
        File xmlFile = new File("C:\\Projekte\\xml2OH\\SmartHomeConfiguration.xml");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Openhab.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Openhab openhab = (Openhab) jaxbUnmarshaller.unmarshal(xmlFile);

            openhab.getDevices().getDevice().forEach(this::processDevice);

        } catch (JAXBException e) {
            log.error("Error while loading XML file", e);
        }
    }

    private void processDevice(Device device) {
        String name = formatDeviceName(device);
        ModuleTemplate module = createModule(device, name);
        if (module != null) {
            registerChannels(device, module);
            module.setName(name);
            module.setArea(device.getDeviceArea());
            beanRegistrar.registerBean(Integer.toString(device.getDeviceId()), module);
            log.info("{} with name [{}] was registered", module.getClass().getSimpleName(), name);
        }
    }

    private String formatDeviceName(Device device) {
        return (device.getDeviceArea() + "_" + device.getDeviceFunction() + "_" + device.getDeviceName())
                .replace(" ", "_").trim();
    }

    private ModuleTemplate createModule(Device device, String name) {
        return switch (device.getDeviceSpecification()) {
            case DeviceSpecification.NTP_BINDING -> new DateTimeModule(openhabRestService, openhabItemRegister, template);
            case DeviceSpecification.ICAL_BINDING -> new GarbageModule(openhabRestService, openhabItemRegister, template);
            case DeviceSpecification.ROLLADEN_MDTKNX -> new ShutterModule(openhabRestService, openhabItemRegister, template);
            case DeviceSpecification.STEINEL_TRUE_PRÄSENZ -> new SteinelPraesenzModule(openhabRestService, openhabItemRegister, template);
            case DeviceSpecification.LIGHT_KN_XFULL -> new LightFullModule(openhabRestService, openhabItemRegister, template);
            case DeviceSpecification.POWER_KNX -> new PowerModule(openhabRestService, openhabItemRegister, template);
            case DeviceSpecification.EKEY_DOOR -> new EkeyModule(openhabRestService, openhabItemRegister, template);
            default -> null;
        };
    }

    private void registerChannels(Device device, ModuleTemplate module) {
        List<Device.Channel> channels = device.getChannel();
        for (int i = 0; i <= 9; i++) {
            final int currentIndex = i;
            Optional<Device.Channel> channelOpt = channels.stream()
                    .filter(channel -> channel.getChannelId() == currentIndex)
                    .findFirst();
            channelOpt.ifPresent(channel -> module.addItem(channel.getLink(), device.getDeviceId(), channel.getChannelId()));
        }
    }
}
