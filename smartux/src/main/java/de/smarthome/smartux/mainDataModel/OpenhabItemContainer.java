package de.smarthome.smartux.mainDataModel;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class OpenhabItemContainer {
    String name;

    @Setter(AccessLevel.NONE)
    List <OpenhabItem> items=  new ArrayList<>();

    public void addItems(OpenhabItem item)
    {
        if(item != null)
        {
            items.add(item);
        }
    }

    @Override
    public int hashCode() {
        return (int) name.hashCode();
    }
}
