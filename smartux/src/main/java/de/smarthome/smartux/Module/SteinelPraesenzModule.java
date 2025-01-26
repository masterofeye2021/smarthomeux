package de.smarthome.smartux.module;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.eventSystem.eventTypes.ItemStateChangedEvent;
import de.smarthome.smartux.eventSystem.eventTypes.ItemStateUpdatedEvent;
import de.smarthome.smartux.helper.OpenhabItemService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @brief Module for handling Steinel presence sensor events.
 */
@Slf4j
@Data
public class SteinelPraesenzModule extends ModuleTemplate {

    /**
     * @brief Constructor for SteinelPraesenzModule.
     * @param deviceID The device ID.
     * @param amountOfChannels The amount of channels.
     * @param service The OpenhabItemService instance.
     * @param template The SimpMessagingTemplate instance.
     */
    public SteinelPraesenzModule(int deviceID, int amountOfChannels, OpenhabItemService service, SimpMessagingTemplate template) {
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
            sender.convertAndSend("/ItemStateUpdatedEvent/" + event.getItem(), event.getValue());
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
            sender.convertAndSend("/ItemStateChangedEvent/" + event.getItem(), event.getValue());
        }
    }

}