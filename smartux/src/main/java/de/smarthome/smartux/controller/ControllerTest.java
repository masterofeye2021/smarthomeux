package de.smarthome.smartux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.Module.GarbageModule;
import de.smarthome.smartux.Module.ModuleManager;
import de.smarthome.smartux.Module.SteinelPraesenzModule;

@Controller
public class ControllerTest {

    @Autowired
    OpenhabItemRegister openhabItemRegister;
    
    @Autowired
    OpenhabRestService openhabRestService;

    @Autowired 
    ModuleManager moduleManager;

    private final ApplicationContext applicationContext;

    @Autowired
    public ControllerTest(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    
    @GetMapping("/garbage")
    public String getHome(Model model) {
        GarbageModule gb = new GarbageModule(openhabRestService, openhabItemRegister);
        gb.init(model);

        
        SteinelPraesenzModule sp =  (SteinelPraesenzModule) applicationContext.getBean("WOZ_SENSOR_Praesenzmelder_Couch");
        sp.init(model);
        SteinelPraesenzModule sp2 =  (SteinelPraesenzModule) applicationContext.getBean( "KUE_SENSOR_Praesenzmelder_Kueche");
        sp2.init(model);
       
        return "garbage.html";
    }
}
