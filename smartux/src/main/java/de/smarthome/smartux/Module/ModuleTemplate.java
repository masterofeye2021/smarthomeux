package de.smarthome.smartux.Module;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.ui.Model;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ModuleTemplate {

    protected OpenhabRestService openhabRestService;

    protected OpenhabItemRegister openhabItemRegister;

    protected SimpMessagingTemplate sender;

    protected String name;

    protected ArrayList<String> toSubcribeFromThisModule = new ArrayList<>();

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ModuleTemplate(OpenhabRestService openhabRestService,OpenhabItemRegister openhabItemRegister,SimpMessagingTemplate template)
    {
        this.openhabItemRegister = openhabItemRegister;
        this.openhabRestService = openhabRestService;
        this.sender = template;
    }

    protected Set<String> openhabItemList = new HashSet<String>();

    protected int getAmountOfRegisteredItems(){  return this.openhabItemList.size();}

    public void addItem(String item)
    {
        if(!this.openhabItemList.contains(item))
            openhabItemList.add(item);
    }

    protected void removeItem(String item)
    {
        if(this.openhabItemList.contains(item))
            openhabItemList.remove(item);
    }

    
    public void init(Model model) {

        for (String tag : this.openhabItemList) {
            /*
            * Items mit Init Values versorgen
            */
            OpenhabItem item = this.openhabRestService.getItemDetails(tag).block();

            /**
             * Alle Attribute dem Model hinzufügen
             */

            model.addAttribute(tag, item);
        }
        
        ((ArrayList<String>) model.getAttribute("toSubscribe")).addAll(new ArrayList<>(this.openhabItemList));
        /*
         * Sind alle Items hinzugefügt kann die Registry aufgerufen werden
         */

        this.register();

        int end = this.getAmountOfRegisteredItems();
        log.debug(end + " new Items registered.");
    }

    public abstract void deinit();

    protected void register()
    {
        for (String item : openhabItemList) {
            openhabItemRegister.register(item);
        }
    }

}
