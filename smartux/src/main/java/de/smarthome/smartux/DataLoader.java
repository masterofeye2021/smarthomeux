package de.smarthome.smartux;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.smarthome.smartux.mainDataModel.OpenhabItem;
import de.smarthome.smartux.xmlSchemaData.Openhab;
import de.smarthome.smartux.xmlSchemaData.Device.Channel;
import de.smarthome.smartux.xmlSchemaData.Devices.Device;
import jakarta.annotation.PostConstruct;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

@Component
public class DataLoader {

    @Autowired
    OpenhabRestService openhabRestService;

    @PostConstruct
    private void loader()
    {
    	File xmlFile = new File("C:\\Projekte\\xml2OH\\SmartHomeConfiguration.xml");
        JAXBContext jaxbContext;

        try 
        {   
            jaxbContext = JAXBContext.newInstance(Openhab.class);        
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Openhab openhab = (Openhab) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println(openhab);

            for (Device device : openhab.getDevices().getDevice()) {
                for(Channel channel : device.getChannel())
                {
                    OpenhabItem i = openhabRestService.getItemDetails(channel.getLink()).block();
                    i.toString();
                    
                }
                
            }
 
  
        } catch (JAXBException e) 
        {
            e.printStackTrace();
        }
    }
}
