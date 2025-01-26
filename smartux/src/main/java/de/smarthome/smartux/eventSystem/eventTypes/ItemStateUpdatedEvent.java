package de.smarthome.smartux.eventSystem.eventTypes;

import org.springframework.context.ApplicationEvent;

/**
 * Event for when an item's state is updated.
 */
public class ItemStateUpdatedEvent extends ApplicationEvent {
    private String value;
    private String item;

    /**
     * Constructs a new ItemStateUpdatedEvent.
     * 
     * @param source The source of the event.
     * @param item The item whose state is updated.
     * @param value The new value of the item.
     */
    public ItemStateUpdatedEvent(Object source, String item, String value) {
        super(source);
        this.item = item;
        this.value = value;
    }

    /**
     * Gets the new value of the item.
     * 
     * @return The new value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Gets the item whose state is updated.
     * 
     * @return The item.
     */
    public String getItem() {
        return item;
    }
}
