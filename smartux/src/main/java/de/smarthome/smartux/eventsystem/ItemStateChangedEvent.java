package de.smarthome.smartux.eventsystem;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationEvent;

public class ItemStateChangedEvent extends ApplicationEvent {
    private String value;
    private String item;
    private LocalDateTime timestamp;

    public ItemStateChangedEvent(Object source, String item, String value) {
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

