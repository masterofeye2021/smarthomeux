package de.smarthome.smartux.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.Module.DateTimeModule;
import de.smarthome.smartux.Module.GarbageModule;
import de.smarthome.smartux.Module.ModuleManager;
import de.smarthome.smartux.Module.SteinelPraesenzModule;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

@Controller
public class ControllerTest {

    @Autowired
    OpenhabItemRegister openhabItemRegister;
    
    @Autowired
    OpenhabRestService openhabRestService;

    @Autowired 
    ModuleManager moduleManager;

    
    @Autowired
    LayoutDialect layoutDialect;

    private final ApplicationContext applicationContext;

    @Autowired
    public ControllerTest(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    
    @GetMapping("/garbage")
    public String getHome(Model model) {

        List<String> toSubcribe = new ArrayList<>();
        model.addAttribute("toSubscribe", toSubcribe);
        GarbageModule gb = (GarbageModule) applicationContext.getBean("TKR_CALENDAR_Termine_Muellabfuhr");
        gb.init(model);

        SteinelPraesenzModule sp =  (SteinelPraesenzModule) applicationContext.getBean("WOZ_SENSOR_Praesenzmelder_Couch");
        sp.init(model);
        SteinelPraesenzModule sp2 =  (SteinelPraesenzModule) applicationContext.getBean("KUE_SENSOR_Praesenzmelder_Kueche");
        sp2.init(model);
       

        
        return "garbage.html";
    }

    @GetMapping("/layout")
    public String getLayout(Model model) {
        List<String> toSubcribe = new ArrayList<>();
        model.addAttribute("toSubscribe", toSubcribe);
        GarbageModule gb = (GarbageModule) applicationContext.getBean("TKR_CALENDAR_Termine_Muellabfuhr");
        gb.init(model);

        DateTimeModule tm = (DateTimeModule) applicationContext.getBean("TKR_NTP_Zeitserver");
        tm.init(model);
        
        return "content1.html";
    }
}
