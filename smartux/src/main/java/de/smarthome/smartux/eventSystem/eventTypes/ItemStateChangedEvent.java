package de.smarthome.smartux.eventSystem.eventTypes;

import org.springframework.context.ApplicationEvent;

/**
 * Event for when an item's state changes.
 */
public class ItemStateChangedEvent extends ApplicationEvent {
    private String value;
    private String item;

    /**
     * Constructs a new ItemStateChangedEvent.
     * 
     * @param source The source of the event.
     * @param item The item whose state has changed.
     * @param value The new value of the item.
     */
    public ItemStateChangedEvent(Object source, String item, String value) {
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
     * Gets the item whose state has changed.
     * 
     * @return The item.
     */
    public String getItem() {
        return item;
    }
}
