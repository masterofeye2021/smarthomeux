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
public class ShutterModule extends ModuleTemplate{


    public ShutterModule(OpenhabRestService openhabRestService,OpenhabItemRegister openhabItemRegister)
    {
        super(openhabRestService,openhabItemRegister);
    }

    private String toggleTag; 
    private String stopTag;
    private String currentDirectionTag;
    private String absPositionTag;
    private String currentPositionTag;
    private String statusTopTag;
    private String statusBottomTag;
    private String lockMovementTag;
    private String diagnosisTag;

    @Override
    public void init(Model model) {
        /*
         * Füge alle benötigten Items hinzu
         */

        this.addItem(toggleTag);
        this.addItem(stopTag);
        this.addItem(currentDirectionTag);
        this.addItem(absPositionTag);
        this.addItem(currentPositionTag);
        this.addItem(statusTopTag);
        this.addItem(statusBottomTag);
        this.addItem(lockMovementTag);
        this.addItem(diagnosisTag);

        /*
         * Items mit Init Values versorgen
         */

        OpenhabItem toggleItem = this.openhabRestService.getItemDetails(toggleTag).block();
        OpenhabItem stopItem = this.openhabRestService.getItemDetails(stopTag).block();
        OpenhabItem currentDirectionItem = this.openhabRestService.getItemDetails(currentDirectionTag).block();
        OpenhabItem absPositionItem = this.openhabRestService.getItemDetails(absPositionTag).block();
        OpenhabItem currentPositionItem = this.openhabRestService.getItemDetails(currentPositionTag).block();
        OpenhabItem statusTopItem = this.openhabRestService.getItemDetails(statusTopTag).block();
        OpenhabItem statusBottomItem = this.openhabRestService.getItemDetails(statusBottomTag).block();
        OpenhabItem lockMovementItem = this.openhabRestService.getItemDetails(lockMovementTag).block();
        OpenhabItem diagnosisItem = this.openhabRestService.getItemDetails(diagnosisTag).block();

        /**
         * Alle Attribute dem Model hinzufügen
         */

        model.addAttribute(toggleTag, toggleItem);
        model.addAttribute(stopTag, stopItem);
        model.addAttribute(currentDirectionTag, currentDirectionItem);
        model.addAttribute(absPositionTag, absPositionItem);
        model.addAttribute(currentPositionTag, currentPositionItem);
        model.addAttribute(statusTopTag, statusTopItem);
        model.addAttribute(statusBottomTag, statusBottomItem);
        model.addAttribute(lockMovementTag, lockMovementItem);
        model.addAttribute(diagnosisTag, diagnosisItem);
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