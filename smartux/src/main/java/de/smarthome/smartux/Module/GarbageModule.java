package de.smarthome.smartux.module;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.ui.Model;

import de.smarthome.smartux.eventSystem.eventTypes.ItemStateChangedEvent;
import de.smarthome.smartux.eventSystem.eventTypes.ItemStateUpdatedEvent;
import de.smarthome.smartux.helper.OpenhabItemService;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GarbageModule extends ModuleTemplate {

    /**
     * @brief Constructor for GarbageModule.
     * @param deviceID         The device ID.
     * @param amountOfChannels The amount of channels.
     * @param service          The OpenhabItemService instance.
     * @param template         The SimpMessagingTemplate instance.
     */
    public GarbageModule(int deviceID, int amountOfChannels, OpenhabItemService service,
            SimpMessagingTemplate template) {
        super(deviceID, amountOfChannels, service, template);
    }

    @Override
    public void addItemsToModel(Model model) {
        for (int channelID = 1; channelID <= this.amountOfChannels; channelID++) {
            OpenhabItem ohItem = openhabItemService.item(this.deviceID, channelID);
            ohItem.setState(_initItemValues(ohItem).toString());

            model.addAttribute(ohItem.getName(), ohItem);
        }
    }

    @Override
    public void deinit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deinit'");
    }

    private Long _initItemValues(OpenhabItem item) {
        try {
            // Folgendes Format bekommen wir von Openhab geliefert
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

            // Parsen in LocalDateTime
            ZonedDateTime zonedDateTime = ZonedDateTime
                    .parse(item.getState(), formatter);
            LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
            Duration duration = Duration.between(LocalDateTime.now(), localDateTime);

            // Werte extrahieren
            return duration.toDays();
        } catch (DateTimeParseException e) {
            log.error(item + " coudn't be parsed correctely");
            return (long) 365;
        }
    }

    @EventListener
    public void handleCustomEvent(ItemStateUpdatedEvent event) {
        if (openhabItemService.isItemInCache(event.getItem())) {
            log.trace("ItemStateUpdatedEvent wurde von [GargabeModule] mit dem Wert [" + event.getValue() + "] empfangen");
            sender.convertAndSend("/ItemStateUpdatedEvent/" + event.getItem(), event.getValue());
        }
    }

    @EventListener
    public void handleCustomEvent(ItemStateChangedEvent event) {
        if (openhabItemService.isItemInCache(event.getItem())) {
            log.trace("ItemStateChangedEvent wurde von [GargabeModule] mit dem Wert [" + event.getValue() + "] empfangen");
            sender.convertAndSend("/ItemStateChangedEvent/" + event.getItem(), event.getValue());
        }
    }
}