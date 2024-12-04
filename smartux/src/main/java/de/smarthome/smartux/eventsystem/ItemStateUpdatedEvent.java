package de.smarthome.smartux.eventsystem;

import org.springframework.context.ApplicationEvent;

public class ItemStateUpdatedEvent extends ApplicationEvent {
    private String value;
    private String item;

    public ItemStateUpdatedEvent(Object source, String item, String value) {
        super(source);
        this.item = item;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getItem() {
        return item;
    }
}   

