package de.smarthome.smartux.Module;

import org.springframework.context.event.EventListener;
import org.springframework.ui.Model;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.eventsystem.ItemStateChangedEvent;
import de.smarthome.smartux.eventsystem.ItemStateUpdatedEvent;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class SteinelPraesenzModule extends ModuleTemplate {
    

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

        String.format(luftfeuchtigkeitItem.getStateDescription().getPattern(), Float.parseFloat(luftfeuchtigkeitItem.getState()));
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

    @EventListener
    public void handleCustomEvent(ItemStateUpdatedEvent event) {
        log.info("ItemStateUpdatedEvent wurde von ["+this.name+"] mit dem Wert ["+event.getValue()+"] empfangen");
    }

    @EventListener
    public void handleCustomEvent(ItemStateChangedEvent event) {
        log.info("ItemStateChangedEvent wurde von ["+this.name+"] mit dem Wert ["+event.getValue()+"] empfangen");
    }

}