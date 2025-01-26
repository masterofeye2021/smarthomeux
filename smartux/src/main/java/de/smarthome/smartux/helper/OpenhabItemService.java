package de.smarthome.smartux.helper;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
import de.smarthome.smartux.module.ModuleTemplate;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
/**
 * @brief This class is used to provide services for Item Handling.
 */
public class OpenhabItemService {

    private final OpenhabRestService openhabRestService;
    private final Map<Integer, OpenhabItem> itemCache = new ConcurrentHashMap<>();

    public OpenhabItemService(OpenhabRestService openhabRestService) {
        this.openhabRestService = openhabRestService;
    }

    /**
     * @brief Gets item details from OpenHAB and caches them.
     * @param deviceID  The device ID.
     * @param channelID The channel ID.
     * @return The OpenhabItem instance.
     */
    public OpenhabItem fetchItemDetailsFromOpenhab(Integer deviceID, Integer channelID, String itemName) {
        int key = generateKey(deviceID, channelID);
        return itemCache.computeIfAbsent(key, k -> fetchItemDetails(itemName));
    }

    /**
     * Checks if an item is in the cache based on deviceID and channelID.
     *
     * @param deviceID  The device ID.
     * @param channelID The channel ID.
     * @return true if the item is in the cache, false otherwise.
     */
    public boolean isItemInCache(Integer deviceID, Integer channelID) {
        int key = generateKey(deviceID, channelID);
        return itemCache.containsKey(key);
    }

    /**
     * Checks if an item is in the cache based on itemName.
     *
     * @param itemName The name of the item.
     * @return true if the item is in the cache, false otherwise.
     */
    public boolean isItemInCache(String itemName) {
        return itemCache.values().stream().anyMatch(item -> item.getName().equals(itemName));
    }

    /**
     * @brief Generates a hash key from deviceID and channelID.
     * @param deviceID  The device ID.
     * @param channelID The channel ID.
     * @return The generated hash key.
     */
    private int generateKey(Integer deviceID, Integer channelID) {
        return Objects.hash(deviceID, channelID);
    }

    /**
     * @brief Fetches item details from OpenHAB.
     * @param deviceID  The device ID.
     * @param channelID The channel ID.
     * @return The OpenhabItem instance.
     */
    private OpenhabItem fetchItemDetails(String itemName) {
        // Implement the logic to fetch item details using deviceID and channelID
        OpenhabItem ohItem = openhabRestService.getItemDetails(itemName).block();
        if (ohItem == null) {
            throw new RuntimeException("Item not found");
        }
        return ohItem;
    }

    public boolean updateOpenhabItem(Integer deviceID, Integer channelID) {
        try {
            int key = generateKey(deviceID, channelID);
            OpenhabItem ohItem = itemCache.get(key);
            itemCache.put(key, fetchItemDetails(ohItem.getName()));
            return true;
        } catch (Exception e) {
            log.error("Error while updating item", e);
            return false;
        }
    }

    public boolean updateOpenhabItem(ModuleTemplate module) {
        try {
            for (int channelID = 1; channelID <= module.getAmountOfChannels(); channelID++) {
                int key = generateKey(module.getDeviceID(), channelID);
                OpenhabItem ohItem = itemCache.get(key);
                if (ohItem == null) {
                  throw new RuntimeException("Item not found");
                }
                itemCache.put(key, fetchItemDetails(ohItem.getName()));
            }
            return true;
        } catch (Exception e) {
            log.error("Error while updating item", e);
            return false;
        }
    }

    /**
     * @brief Clears the item cache.
     */
    public void clearCache() {
        itemCache.clear();
    }

    /**
     * @brief Interface for Thymeleaf to get the OpenhabItem instance based on deviceID and channelID.
     * @param modelMap  The model map.
     * @param deviceID  The device ID.
     * @param channelID The channel ID.
     * @return The OpenhabItem instance.
     */
    public OpenhabItem item(Integer deviceID, Integer channelID) {
        int key = generateKey(deviceID, channelID);
        return itemCache.get(key);
    }
}
