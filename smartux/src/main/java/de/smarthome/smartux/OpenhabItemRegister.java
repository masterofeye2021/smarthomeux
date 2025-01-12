package de.smarthome.smartux;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

import de.smarthome.smartux.mainDataModel.OpenhabItem;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OpenhabItemRegister {

    Set<OpenhabItem> registerOfItems = new HashSet<OpenhabItem>();

    /**
     * @brief Fügt ein weiteres OpenhabItem dem Register hinzu.
     * @param itemName Name des Items welches registriert werden soll.
     * @return Gibt TRUE zurück sofern der Eintrag erfolgreich abgespeichert werden konnte.
     */
    public boolean register(OpenhabItem item)
    {
        if(!this.isItemRegistered(item))
        {
            log.trace("Folgendes Item wurde registriert" + item.getName());
            return registerOfItems.add(item);
        }
        
        return false;
    }

    public OpenhabItem  getItem(String itemName)
    {
        return registerOfItems.stream().filter(i-> i.getName().equals(itemName)).findFirst().get();
    }


    public boolean unregister(String itemName)
    {
        return registerOfItems.remove(itemName);
    }

    public boolean unregisterAll()
    {
        return registerOfItems.removeAll(registerOfItems);
    }

    public boolean isItemRegistered(OpenhabItem item)
    {
        if (item == null)
            return false;

        for (OpenhabItem i : registerOfItems) {
            if (i.equals(item))
                return true;
        }
        return false;
    }

    public boolean isItemRegistered(String itemName)
    {
        if (itemName.isEmpty())
            return false;

        return registerOfItems.stream().filter(i-> i.getName().equals(itemName)).findFirst().isPresent();  
    }
}
