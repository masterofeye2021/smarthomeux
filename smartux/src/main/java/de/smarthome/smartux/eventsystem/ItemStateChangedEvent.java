package de.smarthome.smartux.eventsystem;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationEvent;

public class ItemStateChangedEvent extends ApplicationEvent {
    private String value;
    private String item;
    private LocalDateTime timestamp;

    public ItemStateChangedEvent(Object source, String item, String value, LocalDateTime timestamp) {
        super(source);
        this.item = item;
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getValue() {
        return value;
    }

    public String getItem() {
        return item;
    }

    public LocalDateTime getEvtTimestamp() {
        return timestamp;
    }
}   

