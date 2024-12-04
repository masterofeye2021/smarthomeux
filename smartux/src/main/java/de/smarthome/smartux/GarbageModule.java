package de.smarthome.smartux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.ui.Model;

import de.smarthome.smartux.eventsystem.ItemStateUpdatedEvent;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GarbageModule extends ModuleTemplate implements ApplicationListener<ItemStateUpdatedEvent> {


    public GarbageModule(OpenhabRestService openhabRestService,OpenhabItemRegister openhabItemRegister)
    {
        super(openhabRestService,openhabItemRegister);
    }

    private long bioTonneRemainingDays = 0;
    private long gelbeTonneRemainingDays = 0;
    private short plastikMuell = 0;
    private short papierMuell = 0;

    private String bioTonneTag = "TKR_R_CALENDAR_Tonne_Biomuell";
    private String gelbeTonneTag = "TKR_R_CALENDAR_Tonne_Restmuell";

    @Override
    public void init(Model model) {
        /*
         * Füge alle benötigten Items hinzu
         */

        this.addItem(bioTonneTag);
        this.addItem(gelbeTonneTag);


        /*
         * Items mit Init Values versorgen
         */

        bioTonneRemainingDays = this._initItemValues(bioTonneTag);
        gelbeTonneRemainingDays = this._initItemValues(gelbeTonneTag);

        OpenhabItem bioTonneItem = this.openhabRestService.getItemDetails(bioTonneTag).block();
        OpenhabItem gelbeTonneItem = this.openhabRestService.getItemDetails(gelbeTonneTag).block();

        bioTonneItem.setState(String.valueOf(bioTonneRemainingDays));
        gelbeTonneItem.setState(String.valueOf(gelbeTonneRemainingDays));

        /**
         * Alle Attribute dem Model hinzufügen
         */

        model.addAttribute(bioTonneTag, bioTonneItem);
        model.addAttribute(gelbeTonneTag, gelbeTonneItem);

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

    @Async
    @Override
    public void onApplicationEvent(ItemStateUpdatedEvent event) {
        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onApplicationEvent'");
    }
}