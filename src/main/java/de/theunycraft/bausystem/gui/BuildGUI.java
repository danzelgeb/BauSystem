package de.theunycraft.bausystem.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;

public class BuildGUI implements Listener {

    public static void openGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 54, "Build GUI");
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getView().title().equals("Build GUI")) {
            if (event.getCurrentItem().displayName().equals("")) {

            }
            event.setCancelled(true);
        }
    }

}
