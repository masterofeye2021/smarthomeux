package de.smarthome.smartux;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import de.smarthome.smartux.helper.OpenhabItemService;
import de.smarthome.smartux.module.DateTimeModule;
import de.smarthome.smartux.module.DoorAccessModule;
import de.smarthome.smartux.module.DoorBellModule;
import de.smarthome.smartux.module.DynamicBeanRegistrar;
import de.smarthome.smartux.module.EkeyModule;
import de.smarthome.smartux.module.GarbageModule;
import de.smarthome.smartux.module.LightFullModule;
import de.smarthome.smartux.module.ModuleTemplate;
import de.smarthome.smartux.module.PowerModule;
import de.smarthome.smartux.module.ShutterModule;
import de.smarthome.smartux.module.SteinelPraesenzModule;
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

    private final OpenhabItemService openhabItemService;

    private final DynamicBeanRegistrar beanRegistrar;

    private final SimpMessagingTemplate template;

    public DataLoader(OpenhabItemService openhabItemService, DynamicBeanRegistrar beanRegistrar, SimpMessagingTemplate template ) {
        this.openhabItemService = openhabItemService;
        this.beanRegistrar = beanRegistrar;
        this.template = template;
    }

    @PostConstruct
    private void loader() {
        boolean isWindows = System.getProperty("os.name").startsWith("Windows");
        File xmlFile = null;
        if (isWindows) {
            xmlFile = new File("C:\\Projekte\\xml2OH\\SmartHomeConfiguration.xml");
            
        } else {
            xmlFile = new File("/opt/smartux/SmartHomeConfiguration.xml");
        }

         

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
        if (device.isEnable() == false) {
            log.info("Device with name [{}] is disabled", device.getDeviceName());
            return;
        }
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
            case DeviceSpecification.NTP_BINDING -> new DateTimeModule(device.getDeviceId(), device.getChannel().size(), openhabItemService, template);
            case DeviceSpecification.ICAL_BINDING -> new GarbageModule(device.getDeviceId(), device.getChannel().size(), openhabItemService, template);
            case DeviceSpecification.ROLLADEN_MDTKNX -> new ShutterModule(device.getDeviceId(), device.getChannel().size(), openhabItemService, template);
            case DeviceSpecification.STEINEL_TRUE_PRÄSENZ -> new SteinelPraesenzModule(device.getDeviceId(), device.getChannel().size(), openhabItemService, template);
            case DeviceSpecification.LIGHT_KN_XFULL -> new LightFullModule(device.getDeviceId(), device.getChannel().size(), openhabItemService, template);
            case DeviceSpecification.POWER_KNX -> new PowerModule(device.getDeviceId(), device.getChannel().size(), openhabItemService, template);
            case DeviceSpecification.DOOR_EKEY -> new EkeyModule(device.getDeviceId(), device.getChannel().size(), openhabItemService, template);
            case DeviceSpecification.DOOR_BELL_HTTP -> new DoorBellModule(device.getDeviceId(), device.getChannel().size(), openhabItemService, template); //@TODO HTTP Ist hier nicht die richtige variante
            case DeviceSpecification.DOOR_ACCESS_KNX -> new DoorAccessModule(device.getDeviceId(), device.getChannel().size(), openhabItemService, template);
            default -> null;
        };
    }

    private void registerChannels(Device device, ModuleTemplate module) {
        List<Device.Channel> channels = device.getChannel();
        for (int i = 1; i <= channels.size(); i++) {
            final int currentIndex = i;
            Optional<Device.Channel> channelOpt = channels.stream()
                    .filter(channel -> channel.getChannelId() == currentIndex && channel.isEnable() == true)
                    .findFirst();
            channelOpt.ifPresent(channel -> module.addItem(channel.getLink(), device.getDeviceId(), channel.getChannelId()));
        }
    }
}
