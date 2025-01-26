package de.smarthome.smartux.module;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import de.smarthome.smartux.eventSystem.eventTypes.ItemStateChangedEvent;
import de.smarthome.smartux.eventSystem.eventTypes.ItemStateUpdatedEvent;
import de.smarthome.smartux.helper.OpenhabItemService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IDMWmpModule extends ModuleTemplate {

    /**
     * @brief Constructor for IDMWmpModule.
     * @param deviceID The device ID.
     * @param amountOfChannels The amount of channels.
     * @param service The OpenhabItemService instance.
     * @param template The SimpMessagingTemplate instance.
     */
    public IDMWmpModule(int deviceID, int amountOfChannels, OpenhabItemService service, SimpMessagingTemplate template) {
        super(deviceID, amountOfChannels, service, template);
    }

    @Override
    public void deinit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deinit'");
    }

    @EventListener
    public void handleCustomEvent(ItemStateUpdatedEvent event) {
        if (openhabItemService.isItemInCache(event.getItem())) {
            log.trace("ItemStateUpdatedEvent wurde von [" + this.name + "] mit dem Wert [" + event.getValue() + "] empfangen");
            sender.convertAndSend("/ItemStateUpdatedEvent/" + event.getItem(), event.getValue());
        }
    }

    @EventListener
    public void handleCustomEvent(ItemStateChangedEvent event) {
        if (openhabItemService.isItemInCache(event.getItem())) {
            log.trace("ItemStateChangedEvent wurde von [" + this.name + "] mit dem Wert [" + event.getValue() + "] empfangen");
            sender.convertAndSend("/ItemStateChangedEvent/" + event.getItem(), event.getValue());
        }
    }

}


