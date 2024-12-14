package de.smarthome.smartux.Module;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.ui.Model;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.eventsystem.ItemStateChangedEvent;
import de.smarthome.smartux.eventsystem.ItemStateUpdatedEvent;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GarbageModule extends ModuleTemplate{


    public GarbageModule(OpenhabRestService openhabRestService,OpenhabItemRegister openhabItemRegister,SimpMessagingTemplate template)
    {
        super(openhabRestService,openhabItemRegister,template);
    }

    private long bioTonneRemainingDays = 0;
    private long gelbeTonneRemainingDays = 0;    
    private long restmuellTonneRemainingDays = 0;
    private long altpapierTonneRemainingDays = 0;



    @Override
    public void init(Model model) {

        /*
         * Items mit Init Values versorgen
         */
        for (String tag : this.openhabItemList) {
            /*
            * Items mit Init Values versorgen
            */
            Long remainingDays = this._initItemValues(tag);

            OpenhabItem item = this.openhabRestService.getItemDetails(tag).block();
            item.setState(String.valueOf(remainingDays));

            /**
             * Alle Attribute dem Model hinzufügen
             */

            model.addAttribute(tag, item);
        }
        
        /*
         * Sind alle Items hinzugefügt kann die Registry aufgerufen werden
         */

        this.register();
    }

    @Override
    public void deinit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deinit'");
    }

    private Long _initItemValues(String item)
    {
        try{
        //Folgendes Format bekommen wir von Openhab geliefert
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        
        // Parsen in LocalDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(openhabRestService.getItemDetails(item).block().getState(), formatter);
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        Duration duration = Duration.between(LocalDateTime.now(), localDateTime);
        
        // Werte extrahieren
        return duration.toDays();
        }
        catch (DateTimeParseException e) 
        {
            log.error(item + " coudn't be parsed correctely");
            return (long) 365;
        }
    }

    @EventListener
    public void handleCustomEvent(ItemStateUpdatedEvent event) {
        if (openhabItemList.contains(event.getItem()))
        {
            log.trace("ItemStateUpdatedEvent wurde von [GargabeModule] mit dem Wert ["+event.getValue()+"] empfangen");
        }
    }

    @EventListener
    public void handleCustomEvent(ItemStateChangedEvent event) {
        if (openhabItemList.contains(event.getItem()))
        {
            log.trace("ItemStateChangedEvent wurde von [GargabeModule] mit dem Wert ["+event.getValue()+"] empfangen");
        }
    }
}