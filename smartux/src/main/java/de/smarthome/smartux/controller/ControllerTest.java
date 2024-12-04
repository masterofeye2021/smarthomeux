package de.smarthome.smartux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.smarthome.smartux.GarbageModule;
import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.SteinelPräsenzModule;

@Controller
public class ControllerTest {

    @Autowired
    OpenhabItemRegister openhabItemRegister;
    
    @Autowired
    OpenhabRestService openhabRestService;

    @Qualifier("WOZCouchPräsenzMelder") private SteinelPräsenzModule person;
    
    @GetMapping("/garbage")
    public String getHome(Model model) {
        GarbageModule gb = new GarbageModule(openhabRestService, openhabItemRegister);
        gb.init(model);

        person.toString();
        
        return "garbage.html";
    }
}
