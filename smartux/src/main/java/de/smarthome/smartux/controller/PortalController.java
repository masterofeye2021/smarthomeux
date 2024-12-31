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
import de.smarthome.smartux.Module.DateTimeModule;
import de.smarthome.smartux.Module.DoorBellModule;
import de.smarthome.smartux.Module.GarbageModule;
import de.smarthome.smartux.Module.SteinelPraesenzModule;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
import de.smarthome.smartux.mainDataModel.OpenhabItemContainer;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Controller
public class PortalController {

    @Autowired
    OpenhabItemRegister openhabItemRegister;
    
    @Autowired
    OpenhabRestService openhabRestService;

    
    @Autowired
    LayoutDialect layoutDialect;

    private final ApplicationContext applicationContext;

    public PortalController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping("/index")
    public String getIndex(Model model) {
        Map<Integer,String> toSubcribe = new HashMap<>();
        model.addAttribute("toSubscribe", toSubcribe);
        GarbageModule gb = (GarbageModule) applicationContext.getBean(GarbageModule.class);
        
        gb.init(model, "14");

        DateTimeModule tm = (DateTimeModule) applicationContext.getBean(DateTimeModule.class);
        tm.init(model, "18");

        DoorBellModule doorbell = (DoorBellModule) applicationContext.getBean(DoorBellModule.class);
        doorbell.init(model, "201");

        ArrayList<OpenhabItemContainer> containerForPraesenzModuls = new ArrayList<>();
        Map<String,SteinelPraesenzModule> listOfPraesenzModule = applicationContext.getBeansOfType(SteinelPraesenzModule.class);
        listOfPraesenzModule.forEach((name, bean) -> {
            containerForPraesenzModuls.add(bean.init(model,name,false));
        });
        model.addAttribute("SteinelPraesenzModuleData", containerForPraesenzModuls);
        model.addAttribute("ModelMap", model.asMap());
        
        return "index.html";
    }

    public static OpenhabItem getItem(Map<String, Object> modelMap,Integer deviceID, Integer channelID)
    {
        Map<Integer,String> toSubcribe = (Map<Integer, String>) modelMap.get("toSubscribe");
        String tag = toSubcribe.get(deviceID.hashCode() * channelID.hashCode());


        ArrayList<OpenhabItem> list = (ArrayList<OpenhabItem>) modelMap.get(Integer.toString(deviceID));
        return list.stream().filter(e -> e.getName().equals(tag)).findFirst().orElseThrow();     
    }



}
