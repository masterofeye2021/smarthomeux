package de.smarthome.smartux;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OpenhabItemRegister {

    Set<String> registerOfItems = new HashSet<String>();

    /**
     * @brief Fügt ein weiteres OpenhabItem dem Register hinzu.
     * @param itemName Name des Items welches registriert werden soll.
     * @return Gibt TRUE zurück sofern der Eintrag erfolgreich abgespeichert werden konnte.
     */
    public boolean register(String itemName)
    {
        if(!this.isItemRegistered(itemName))
        {
            log.trace("Folgendes Item wurde registriert" + itemName);
            return registerOfItems.add(itemName);
        }
        
        return false;
    }


    public boolean unregister(String itemName)
    {
        return registerOfItems.remove(itemName);
    }

    public boolean unregisterAll()
    {
        return registerOfItems.removeAll(registerOfItems);
    }

    public boolean isItemRegistered(String itemName)
    {
        if (itemName.isBlank())
            return false;

        for (String string : registerOfItems) {
            if (itemName.contains(string))
                return true;
        }
        return false;
    }
}
