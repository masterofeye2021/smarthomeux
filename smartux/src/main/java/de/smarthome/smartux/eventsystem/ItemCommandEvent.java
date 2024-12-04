package de.smarthome.smartux.eventsystem;

import org.springframework.context.ApplicationEvent;

import de.smarthome.smartux.mainDataModel.OpenhabItem;

public class ItemCommandEvent extends ApplicationEvent {
    private OpenhabItem data;

    public ItemCommandEvent(Object source, OpenhabItem data) {
        super(source);
        this.data = data;
    }

    public OpenhabItem getData() {
        return data;
    }
}    