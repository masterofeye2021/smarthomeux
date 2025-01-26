package de.smarthome.smartux.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.smarthome.smartux.helper.OpenhabItemService;
import de.smarthome.smartux.mainDataModel.OpenhabItemContainer;
import de.smarthome.smartux.module.DateTimeModule;
import de.smarthome.smartux.module.DoorAccessModule;
import de.smarthome.smartux.module.DoorBellModule;
import de.smarthome.smartux.module.EkeyModule;
import de.smarthome.smartux.module.GarbageModule;
import de.smarthome.smartux.module.PowerModule;
import de.smarthome.smartux.module.SteinelPraesenzModule;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Controller
public class PortalController {

    private final OpenhabItemService openhabItemService;

    
    @Autowired
    LayoutDialect layoutDialect;

    private final ApplicationContext applicationContext;

    public PortalController(OpenhabItemService openhabItemService, ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.openhabItemService = openhabItemService;
    }

    @GetMapping("/index")
    public String getIndex(Model model) {

        GarbageModule gb = (GarbageModule) applicationContext.getBean(GarbageModule.class);
        openhabItemService.updateOpenhabItem(gb);
        gb.addItemsToModel(model);

        DateTimeModule tm = (DateTimeModule) applicationContext.getBean(DateTimeModule.class);
        openhabItemService.updateOpenhabItem(tm);

        DoorBellModule doorbell = (DoorBellModule) applicationContext.getBean(DoorBellModule.class);
        openhabItemService.updateOpenhabItem(doorbell);

        EkeyModule ekey = (EkeyModule) applicationContext.getBean(EkeyModule.class);
        openhabItemService.updateOpenhabItem(ekey);

        DoorAccessModule doorAccess = (DoorAccessModule) applicationContext.getBean(DoorAccessModule.class);
        openhabItemService.updateOpenhabItem(doorAccess);

        PowerModule washmachine = (PowerModule) applicationContext.getBean("45",PowerModule.class);
        openhabItemService.updateOpenhabItem(washmachine);

        PowerModule dryer = (PowerModule) applicationContext.getBean("90",PowerModule.class);
        openhabItemService.updateOpenhabItem(dryer);

        PowerModule fridge = (PowerModule) applicationContext.getBean("91",PowerModule.class);
        openhabItemService.updateOpenhabItem(fridge);

        Map<String,SteinelPraesenzModule> listOfPraesenzModule = applicationContext.getBeansOfType(SteinelPraesenzModule.class);
        listOfPraesenzModule.forEach((name, bean) -> {
            openhabItemService.updateOpenhabItem(bean);
        });

        model.addAttribute("service", openhabItemService);

        return "index.html";
    }





}
