package de.smarthome.smartux.Module;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class ModuleManager {
    private HashMap<String, Object> moduleList = new HashMap<>();


    public void add(String name, Object module)
    {
        moduleList.put(name, module);
    }

    public Object get(String name)
    {
       return moduleList.get(name);
    }

}
