package de.smarthome.smartux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.smarthome.smartux.GarbageModule;
import de.smarthome.smartux.ModuleManager;
import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.SmartuxApplication;
import de.smarthome.smartux.SteinelPraesenzModule;

@Controller
public class ControllerTest {

    @Autowired
    OpenhabItemRegister openhabItemRegister;
    
    @Autowired
    OpenhabRestService openhabRestService;

    @Autowired 
    ModuleManager moduleManager;
    
    @GetMapping("/garbage")
    public String getHome(Model model) {
        GarbageModule gb = new GarbageModule(openhabRestService, openhabItemRegister);
        gb.init(model);


        SteinelPraesenzModule sp =  (SteinelPraesenzModule) moduleManager.get( "WOZ_SENSOR_Praesenzmelder_Couch");

    
        
        return "garbage.html";
    }
}
