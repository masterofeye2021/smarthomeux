package de.smarthome.smartux.mainDataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.SteinelPräsenzModule;

@Configuration
public class DataModelConfig {

    @Autowired
    OpenhabItemRegister openhabItemRegister;
    
    @Autowired
    OpenhabRestService openhabRestService;

    @Bean("WOZCouchPräsenzMelder")
    public SteinelPräsenzModule getWOZCouchPräsenzMelder(){

        SteinelPräsenzModule sp = new SteinelPräsenzModule(openhabRestService, openhabItemRegister);
        sp.setPräsenzTag("WOZ_R_SENSOR_Couch_Praezenz");
        sp.setTruePräsenzTag("WOZ_R_SENSOR_Couch_Praezenz");
        sp.setTemperaturTag("WOZ_R_SENSOR_Couch_Temperatur");
        sp.setLuftfeuchtigkeitTag("WOZ_R_SENSOR_Couch_Luftfeuchtigkeit");
        sp.setRelativeLuftdruckTag("WOZ_R_SENSOR_Couch_Relativer_Luftdruck");
        sp.setAbsoluterLuftdruckTag("WOZ_R_SENSOR_Couch_Absoluter_Luftdruck");
        sp.setCo2Tag("WOZ_R_SENSOR_Couch_CO2");
        sp.setVocTag("WOZ_R_SENSOR_Couch_VOC");


        return sp;
    }

    
}
