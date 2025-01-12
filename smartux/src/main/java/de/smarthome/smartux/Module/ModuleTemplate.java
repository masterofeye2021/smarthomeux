package de.smarthome.smartux.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.javatuples.Pair;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.ui.Model;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
import de.smarthome.smartux.mainDataModel.OpenhabItemContainer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ModuleTemplate {

    protected OpenhabRestService openhabRestService;

    protected OpenhabItemRegister openhabItemRegister;

    protected SimpMessagingTemplate sender;

    protected String name;
    protected String area;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return this.area;
    }

    public ModuleTemplate(OpenhabRestService openhabRestService, OpenhabItemRegister openhabItemRegister,
            SimpMessagingTemplate template) {
        this.openhabItemRegister = openhabItemRegister;
        this.openhabRestService = openhabRestService;
        this.sender = template;
    }

    protected ArrayList<Pair<String, Integer>> openhabItemList = new ArrayList<Pair<String, Integer>>();

    protected boolean isItemInList(String item) {
        return this.openhabItemList.stream().anyMatch(e -> e.getValue0().equals(item));
    }

    protected int getAmountOfRegisteredItems() {
        return this.openhabItemList.size();
    }

    public void addItem(String item, Integer deviceID, Integer channelID) {
        if (this.openhabItemList.stream().noneMatch(e -> e.getValue0().equals(item)))
        {
            Integer prime = 31;
            Integer result = 1;

            result = prime * result + ((deviceID == null) ? 0 : deviceID.hashCode());
            result += prime * result + ((channelID == null) ? 0 : channelID.hashCode());
            openhabItemList.add(Pair.with(item, result));
        }
    }

    protected void removeItem(String item) {
        if (!this.openhabItemList.stream().noneMatch(e -> e.getValue0().equals(item)))
            openhabItemList.removeIf(e -> e.getValue0().equals(item));
    }

    public OpenhabItemContainer init(Model model, String modelAttributeName, boolean registerItemsInModel) {

        OpenhabItemContainer container = new OpenhabItemContainer();
        container.setName(modelAttributeName);

        for (Pair<String, Integer> tag : this.openhabItemList) {
            /*
             * Items mit Init Values versorgen
             */
            OpenhabItem item = this.openhabRestService.getItemDetails(tag.getValue0()).block();

            container.addItems(item);
            container.setArea(this.area);

            /*
             * Sind alle Items hinzugefügt kann die Registry aufgerufen werden
             */

            this.register(item);

            ((HashMap<Integer, String>) model.getAttribute("toSubscribe")).put(tag.getValue1(), tag.getValue0());

        }

        /**
         * Alle Attribute dem Model hinzufügen
         */

        if (registerItemsInModel)
            model.addAttribute(container.getName(), container.getItems());

        int end = this.getAmountOfRegisteredItems();
        log.debug(end + " new Items registered.");

        return container;

    }

    public OpenhabItemContainer init(Model model, String modelAttributeName) {
        return init(model, modelAttributeName, true);
    }

    public abstract void deinit();

    protected void register(OpenhabItem item) {
        if (item == null)
            return;
        this.openhabItemRegister.register(item);
    }

}
