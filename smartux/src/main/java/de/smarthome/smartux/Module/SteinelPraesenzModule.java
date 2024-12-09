package de.smarthome.smartux.Module;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.ui.Model;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.eventsystem.ItemStateChangedEvent;
import de.smarthome.smartux.eventsystem.ItemStateUpdatedEvent;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class SteinelPraesenzModule extends ModuleTemplate {


    public SteinelPraesenzModule(OpenhabRestService openhabRestService,OpenhabItemRegister openhabItemRegister,SimpMessagingTemplate template)
    {
        super(openhabRestService,openhabItemRegister, template);
    }


    @Override
    public void deinit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deinit'");
    }

    @EventListener
    public void handleCustomEvent(ItemStateUpdatedEvent event) {
        if (openhabItemList.contains(event.getItem()))
        {
            log.trace("ItemStateUpdatedEvent wurde von ["+this.name+"] mit dem Wert ["+event.getValue()+"] empfangen");
            sender.convertAndSend("/ItemStateUpdatedEvent/" + event.getItem() , event.getValue());
        }
    }

    @EventListener
    public void handleCustomEvent(ItemStateChangedEvent event) {
        if (openhabItemList.contains(event.getItem()))
        {
            log.trace("ItemStateChangedEvent wurde von ["+this.name+"] mit dem Wert ["+event.getValue()+"] empfangen");
            sender.convertAndSend("/ItemStateChangedEvent/" + event.getItem() , event.getValue());
        }
    }

}