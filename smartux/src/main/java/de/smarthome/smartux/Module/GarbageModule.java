package de.smarthome.smartux.Module;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.event.EventListener;
import org.springframework.ui.Model;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.eventsystem.ItemStateChangedEvent;
import de.smarthome.smartux.eventsystem.ItemStateUpdatedEvent;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GarbageModule extends ModuleTemplate{


    public GarbageModule(OpenhabRestService openhabRestService,OpenhabItemRegister openhabItemRegister)
    {
        super(openhabRestService,openhabItemRegister);
    }

    private long bioTonneRemainingDays = 0;
    private long gelbeTonneRemainingDays = 0;    
    private long restmuellTonneRemainingDays = 0;
    private long altpapierTonneRemainingDays = 0;

    private String bioTonneTag = "TKR_R_CALENDAR_Tonne_Biomuell";
    private String restmuellTonneTag = "TKR_R_CALENDAR_Tonne_Restmuell";
    private String gelbeTonneTag = "TKR_R_CALENDAR_Tonne_Plastikmuell";
    private String altpapierTonneTag = "TKR_R_CALENDAR_Tonne_Papiermuell";

    @Override
    public void init(Model model) {
        /*
         * Füge alle benötigten Items hinzu
         */

        this.addItem(bioTonneTag);
        this.addItem(gelbeTonneTag);
        this.addItem(restmuellTonneTag);
        this.addItem(altpapierTonneTag);



        /*
         * Items mit Init Values versorgen
         */

        bioTonneRemainingDays = this._initItemValues(bioTonneTag);
        gelbeTonneRemainingDays = this._initItemValues(gelbeTonneTag);
        restmuellTonneRemainingDays = this._initItemValues(restmuellTonneTag);
        altpapierTonneRemainingDays = this._initItemValues(altpapierTonneTag);

        OpenhabItem bioTonneItem = this.openhabRestService.getItemDetails(bioTonneTag).block();
        OpenhabItem gelbeTonneItem = this.openhabRestService.getItemDetails(gelbeTonneTag).block();
        OpenhabItem restmuellTonneItem = this.openhabRestService.getItemDetails(restmuellTonneTag).block();
        OpenhabItem altpapierTonneItem = this.openhabRestService.getItemDetails(altpapierTonneTag).block();

        bioTonneItem.setState(String.valueOf(bioTonneRemainingDays));
        gelbeTonneItem.setState(String.valueOf(gelbeTonneRemainingDays));
        restmuellTonneItem.setState(String.valueOf(restmuellTonneRemainingDays));
        altpapierTonneItem.setState(String.valueOf(altpapierTonneRemainingDays));

        /**
         * Alle Attribute dem Model hinzufügen
         */

        model.addAttribute(bioTonneTag, bioTonneItem);
        model.addAttribute(gelbeTonneTag, gelbeTonneItem);
        model.addAttribute(restmuellTonneTag, restmuellTonneItem);
        model.addAttribute(altpapierTonneTag, altpapierTonneItem);

        /*
         * Sind alle Items hinzugefügt kann die Registry aufgerufen werden
         */

        this.register();
    }


    @Override
    public void update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
        
    }


    @Override
    public void deinit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deinit'");
    }

    private Long _initItemValues(String item)
    {
        //Folgendes Format bekommen wir von Openhab geliefert
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        
        // Parsen in LocalDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(openhabRestService.getItemDetails(item).block().getState(), formatter);
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        Duration duration = Duration.between(LocalDateTime.now(), localDateTime);
        
        // Werte extrahieren
        return duration.toDays();
    }

    @EventListener
    public void handleCustomEvent(ItemStateUpdatedEvent event) {
        log.info("ItemStateUpdatedEvent wurde von [GargabeModule] mit dem Wert ["+event.getValue()+"] empfangen");
    }

    @EventListener
    public void handleCustomEvent(ItemStateChangedEvent event) {
        log.info("ItemStateChangedEvent wurde von [GargabeModule] mit dem Wert ["+event.getValue()+"] empfangen");
    }
}