package de.smarthome.smartux.module;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import de.smarthome.smartux.eventSystem.eventTypes.ItemStateChangedEvent;
import de.smarthome.smartux.eventSystem.eventTypes.ItemStateUpdatedEvent;
import de.smarthome.smartux.helper.OpenhabItemService;
import lombok.extern.slf4j.Slf4j;

/**
 * @brief Module for handling power-related events.
 */
@Slf4j
public class PowerModule extends ModuleTemplate {

    /**
     * @brief Constructor for PowerModule.
     * @param deviceID The device ID.
     * @param amountOfChannels The amount of channels.
     * @param service The OpenhabItemService instance.
     * @param template The SimpMessagingTemplate instance.
     */
    public PowerModule(int deviceID, int amountOfChannels, OpenhabItemService service, SimpMessagingTemplate template) {
        super(deviceID, amountOfChannels, service, template);
    }

    /**
     * @brief Deinitializes the module.
     * @throws UnsupportedOperationException if the method is not implemented.
     */
    @Override
    public void deinit() {
        throw new UnsupportedOperationException("Unimplemented method 'deinit'");
    }

    /**
     * @brief Handles ItemStateUpdatedEvent.
     * @param event The ItemStateUpdatedEvent.
     */
    @EventListener
    public void handleCustomEvent(ItemStateUpdatedEvent event) {
        if (openhabItemService.isItemInCache(event.getItem())) {
            log.trace("ItemStateUpdatedEvent wurde von [" + this.name + "] mit dem Wert [" + event.getValue() + "] empfangen");
            sender.convertAndSend("/ItemStateUpdatedEvent/" + event.getItem(), event);
        }
    }

    /**
     * @brief Handles ItemStateChangedEvent.
     * @param event The ItemStateChangedEvent.
     */
    @EventListener
    public void handleCustomEvent(ItemStateChangedEvent event) {
        if (openhabItemService.isItemInCache(event.getItem())) {
            log.trace("ItemStateChangedEvent wurde von [" + this.name + "] mit dem Wert [" + event.getValue() + "] empfangen");
            sender.convertAndSend("/ItemStateChangedEvent/" + event.getItem(), event);
        }
    }
}