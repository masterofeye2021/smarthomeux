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
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class SteinelPraesenzModule extends ModuleTemplate implements ApplicationListener<ItemStateUpdatedEvent> {


    public SteinelPraesenzModule(OpenhabRestService openhabRestService,OpenhabItemRegister openhabItemRegister)
    {
        super(openhabRestService,openhabItemRegister);
    }


    private String präsenzTag = "";
    private String truePräsenzTag = "";
    private String temperaturTag = "";
    private String luftfeuchtigkeitTag = "";
    private String relativeLuftdruckTag = "";
    private String absoluterLuftdruckTag = "";
    private String co2Tag = "";
    private String vocTag = "";


    @Override
    public void init(Model model) {
        /*
         * Füge alle benötigten Items hinzu
         */
        int start = this.getAmountOfRegisteredItems();

        this.addItem(präsenzTag);
        this.addItem(truePräsenzTag);
        this.addItem(temperaturTag);
        this.addItem(luftfeuchtigkeitTag);
        this.addItem(relativeLuftdruckTag);
        this.addItem(absoluterLuftdruckTag);
        this.addItem(co2Tag);
        this.addItem(vocTag);

        int end = this.getAmountOfRegisteredItems();
        int diff = end-start;

        log.debug(diff + " new Items registered.");

        /*
         * Items mit Init Values versorgen
         */

        OpenhabItem präsenzItem = this.openhabRestService.getItemDetails(präsenzTag).block();
        OpenhabItem truePräsenzItem = this.openhabRestService.getItemDetails(truePräsenzTag).block();
        OpenhabItem temperaturItem = this.openhabRestService.getItemDetails(temperaturTag).block();
        OpenhabItem luftfeuchtigkeitItem = this.openhabRestService.getItemDetails(luftfeuchtigkeitTag).block();
        OpenhabItem relativeLuftdruckItem = this.openhabRestService.getItemDetails(relativeLuftdruckTag).block();
        OpenhabItem absoluterLuftdruckItem = this.openhabRestService.getItemDetails(absoluterLuftdruckTag).block();
        OpenhabItem co2Item = this.openhabRestService.getItemDetails(co2Tag).block();
        OpenhabItem vocItem = this.openhabRestService.getItemDetails(co2Tag).block();

        /**
         * Alle Attribute dem Model hinzufügen
         */

        model.addAttribute(präsenzTag, präsenzItem);
        model.addAttribute(truePräsenzTag, truePräsenzItem);
        model.addAttribute(temperaturTag, temperaturItem);
        model.addAttribute(luftfeuchtigkeitTag, luftfeuchtigkeitItem);
        model.addAttribute(relativeLuftdruckTag, relativeLuftdruckItem);
        model.addAttribute(absoluterLuftdruckTag, absoluterLuftdruckItem);
        model.addAttribute(co2Tag, co2Item);
        model.addAttribute(vocTag, vocItem);

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