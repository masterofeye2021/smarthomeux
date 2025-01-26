package de.smarthome.smartux.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.helper.OpenhabItemService;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
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
        
        gb.addItemsToModel(model);

        model.addAttribute("service", openhabItemService);

        /*DateTimeModule tm = (DateTimeModule) applicationContext.getBean(DateTimeModule.class);
        tm.init(model, "18");

        DoorBellModule doorbell = (DoorBellModule) applicationContext.getBean(DoorBellModule.class);
        doorbell.init(model, "201");

        EkeyModule ekey = (EkeyModule) applicationContext.getBean(EkeyModule.class);
        ekey.init(model, "200");

        DoorAccessModule doorAccess = (DoorAccessModule) applicationContext.getBean(DoorAccessModule.class);
        doorAccess.init(model, "35");

        PowerModule washmachine = (PowerModule) applicationContext.getBean("45",PowerModule.class);
        washmachine.init(model, "45");

        //PowerModule dryer = (PowerModule) applicationContext.getBean("90",PowerModule.class);
        //dryer.init(model, "90");

        PowerModule fridge = (PowerModule) applicationContext.getBean("91",PowerModule.class);
        fridge.init(model, "91");
        

        ArrayList<OpenhabItemContainer> containerForPraesenzModuls = new ArrayList<>();
        Map<String,SteinelPraesenzModule> listOfPraesenzModule = applicationContext.getBeansOfType(SteinelPraesenzModule.class);
        listOfPraesenzModule.forEach((name, bean) -> {
            containerForPraesenzModuls.add(bean.init(model,name,false));
        });
        model.addAttribute("SteinelPraesenzModuleData", containerForPraesenzModuls);
        model.addAttribute("ModelMap", model.asMap());
        */
        return "index.html";
    }





}
