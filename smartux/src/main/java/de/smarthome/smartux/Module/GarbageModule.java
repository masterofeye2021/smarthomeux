package de.smarthome.smartux.module;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.stream.Collectors;

import org.javatuples.Pair;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.ui.Model;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.eventsystem.ItemStateChangedEvent;
import de.smarthome.smartux.eventsystem.ItemStateUpdatedEvent;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
import de.smarthome.smartux.mainDataModel.OpenhabItemContainer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GarbageModule extends ModuleTemplate {

    public GarbageModule(OpenhabRestService openhabRestService, OpenhabItemRegister openhabItemRegister,
            SimpMessagingTemplate template) {
        super(openhabRestService, openhabItemRegister, template);
    }

    @Override
    public OpenhabItemContainer init(Model model, String modelAttributeName, boolean registerItemsInModel) {

        OpenhabItemContainer container = new OpenhabItemContainer();
        container.setName(modelAttributeName);
        /*
         * Items mit Init Values versorgen
         */
        for (Pair<String,Integer> tag : this.openhabItemList) {
            /*
             * Items mit Init Values versorgen
             */
            Long remainingDays = this._initItemValues(tag.getValue0());

            OpenhabItem item = this.openhabRestService.getItemDetails(tag.getValue0()).block();
            item.setState(String.valueOf(remainingDays));

            container.addItems(item);

        }

        /**
         * Alle Attribute dem Model hinzufügen
         */
        if(registerItemsInModel)
            model.addAttribute(container.getName(), container.getItems());
        
        
        //container.getItems().stream().filter(e-> e.getName().equals(id)).findFirst())

        ((Map<Integer,String>) model.getAttribute("toSubscribe")).putAll(this.openhabItemList.stream().collect(Collectors.toMap(Pair::getValue1, Pair::getValue0)));

        /*
         * Sind alle Items hinzugefügt kann die Registry aufgerufen werden
         */

        this.register();
        return container;
    }

    @Override
    public void deinit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deinit'");
    }

    private Long _initItemValues(String item) {
        try {
            // Folgendes Format bekommen wir von Openhab geliefert
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

            // Parsen in LocalDateTime
            ZonedDateTime zonedDateTime = ZonedDateTime
                    .parse(openhabRestService.getItemDetails(item).block().getState(), formatter);
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
        if (openhabItemList.contains(event.getItem())) {
            log.trace("ItemStateUpdatedEvent wurde von [GargabeModule] mit dem Wert [" + event.getValue()
                    + "] empfangen");
            sender.convertAndSend("/ItemStateUpdatedEvent/" + event.getItem() , event.getValue());
        }
    }

    @EventListener
    public void handleCustomEvent(ItemStateChangedEvent event) {
        if (openhabItemList.contains(event.getItem())) {
            log.trace("ItemStateChangedEvent wurde von [GargabeModule] mit dem Wert [" + event.getValue()
                    + "] empfangen");
            sender.convertAndSend("/ItemStateChangedEvent/" + event.getItem() , event.getValue());
        }
    }
}