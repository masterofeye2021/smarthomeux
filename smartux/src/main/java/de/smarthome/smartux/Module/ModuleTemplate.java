package de.smarthome.smartux.module;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.ui.Model;

import de.smarthome.smartux.helper.OpenhabItemService;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public abstract class ModuleTemplate {


    protected OpenhabItemService openhabItemService;

    protected SimpMessagingTemplate sender;

    protected String name = "";
    protected String area = "";
    protected int deviceID = 0;
    protected int amountOfChannels = 0;

    public ModuleTemplate(int deviceID, int amountOfChannels, OpenhabItemService openhabItemService,
            SimpMessagingTemplate template) {
        this.openhabItemService = openhabItemService;
        this.sender = template;
        this.amountOfChannels = amountOfChannels;
        this.deviceID = deviceID;
    }

    public void addItem(String item, Integer deviceID, Integer channelID) {
        if(!this.openhabItemService.isItemInCache(deviceID, channelID))
            this.openhabItemService.fetchItemDetailsFromOpenhab(deviceID, channelID, item);
    }

    protected void removeItem(String item) {
        this.openhabItemService.clearCache();
    }

    public void addItemsToModel(Model model) {
        int registeredItems= 0;

        for( int channelID = 1; channelID <= this.amountOfChannels; channelID++) {
            OpenhabItem ohItem = this.openhabItemService.item(this.deviceID, channelID);
            model.addAttribute("test", ohItem);

            registeredItems++;
        }
        log.debug(registeredItems + " new Items registered.");
    }

    public abstract void deinit();



}
