package de.smarthome.smartux.Module;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.eventsystem.ItemStateChangedEvent;
import de.smarthome.smartux.eventsystem.ItemStateUpdatedEvent;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class ShutterModule extends ModuleTemplate{


    public ShutterModule(OpenhabRestService openhabRestService,OpenhabItemRegister openhabItemRegister,SimpMessagingTemplate template)
    {
        super(openhabRestService,openhabItemRegister,template);
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
        }
    }

    @EventListener
    public void handleCustomEvent(ItemStateChangedEvent event) {
        if (openhabItemList.contains(event.getItem()))
        {
            log.trace("ItemStateChangedEvent wurde von ["+this.name+"] mit dem Wert ["+event.getValue()+"] empfangen");
        }
    }
}