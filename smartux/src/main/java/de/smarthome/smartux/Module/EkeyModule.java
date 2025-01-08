package de.smarthome.smartux.module;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.eventsystem.ItemStateChangedEvent;
import de.smarthome.smartux.eventsystem.ItemStateUpdatedEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * @brief
 * @binding Für dieses Module wird das EKEY Binding verwendet https://www.openhab.org/addons/bindings/ekey/
 */
@Slf4j
public class EkeyModule extends ModuleTemplate {

    public EkeyModule(OpenhabRestService openhabRestService, OpenhabItemRegister openhabItemRegister,
            SimpMessagingTemplate template) {
        super(openhabRestService, openhabItemRegister, template);
    }

    @Override
    public void deinit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deinit'");
    }

    @EventListener
    public void handleCustomEvent(ItemStateUpdatedEvent event) {
        if (isItemInList(event.getItem())) {
            log.trace("ItemStateUpdatedEvent wurde von [" + this.name + "] mit dem Wert [" + event.getValue()
                    + "] empfangen");
            sender.convertAndSend("/ItemStateUpdatedEvent/" + event.getItem(), event.getValue());
        }
    }

    @EventListener
    public void handleCustomEvent(ItemStateChangedEvent event) {
        if (isItemInList(event.getItem())) {
            log.trace("ItemStateChangedEvent wurde von [" + this.name + "] mit dem Wert [" + event.getValue()
                    + "] empfangen");

            sender.convertAndSend("/ItemStateChangedEvent/" + event.getItem(), event.getValue());
        }
    }

}