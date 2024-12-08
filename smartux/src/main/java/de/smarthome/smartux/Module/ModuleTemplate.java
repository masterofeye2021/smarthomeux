package de.smarthome.smartux.Module;

import java.util.HashSet;
import java.util.Set;

import org.springframework.ui.Model;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ModuleTemplate {

    protected OpenhabRestService openhabRestService;

    protected OpenhabItemRegister openhabItemRegister;

    protected String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public ModuleTemplate(OpenhabRestService openhabRestService,OpenhabItemRegister openhabItemRegister)
    {
        this.openhabItemRegister = openhabItemRegister;
        this.openhabRestService = openhabRestService;
    }

    private Set<String> openhabItemList = new HashSet<String>();

    protected int getAmountOfRegisteredItems(){  return this.openhabItemList.size();}

    protected void addItem(String item)
    {
        if(!this.openhabItemList.contains(item))
            openhabItemList.add(item);
    }

    protected void removeItem(String item)
    {
        if(this.openhabItemList.contains(item))
            openhabItemList.remove(item);
    }

    public abstract void init(Model model);
    public abstract void update();
    public abstract void deinit();

    protected void register()
    {
        for (String item : openhabItemList) {
            openhabItemRegister.register(item);
        }
    }

}
