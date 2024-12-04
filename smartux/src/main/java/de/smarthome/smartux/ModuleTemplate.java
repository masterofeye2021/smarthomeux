package de.smarthome.smartux;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ModuleTemplate {

    protected OpenhabRestService openhabRestService;

    protected OpenhabItemRegister openhabItemRegister;

    public ModuleTemplate(OpenhabRestService openhabRestService,OpenhabItemRegister openhabItemRegister)
    {
        this.openhabItemRegister = openhabItemRegister;
        this.openhabRestService = openhabRestService;
    }

    private Set<String> openhabItemList = new HashSet<String>();

    protected int getAmountOfRegisteredItems(){  return this.openhabItemList.size();}

    protected void addItem(String item)
    {
        openhabItemList.add(item);
    }

    protected void removeItem(String item)
    {
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
