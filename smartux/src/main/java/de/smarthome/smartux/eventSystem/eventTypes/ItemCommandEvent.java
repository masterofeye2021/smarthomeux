package de.smarthome.smartux.eventSystem.eventTypes;

import org.springframework.context.ApplicationEvent;
import de.smarthome.smartux.mainDataModel.OpenhabItem;

/**
 * @brief Event class for handling item command events in the SmartHome system.
 */
public class ItemCommandEvent extends ApplicationEvent {
    private OpenhabItem data;

    /**
     * @brief Constructs a new ItemCommandEvent.
     * @param source The object on which the event initially occurred.
     * @param data The OpenhabItem data associated with this event.
     */
    public ItemCommandEvent(Object source, OpenhabItem data) {
        super(source);
        this.data = data;
    }

    /**
     * @brief Gets the OpenhabItem data associated with this event.
     * @return The OpenhabItem data.
     */
    public OpenhabItem getData() {
        return data;
    }
}