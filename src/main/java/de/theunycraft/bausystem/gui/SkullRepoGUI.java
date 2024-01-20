package de.theunycraft.bausystem.gui;

import de.theunycraft.bausystem.BauSystem;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.ArrayList;

public class SkullRepoGUI implements Listener {
    private static Inventory inventory;
    private static Inventory alphabetPage1;
    private static Inventory alphabetPage2;
    private static Inventory alphabetPage3;
    private static ItemStack alphabet;
    private static ItemStack nextButton;
    private static ItemStack backButton;

    public static void openGUI(Player player) {
        inventory = Bukkit.createInventory(null, 54, Component.text("SkullRepo"));
        ItemStack placeholder = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta itemMeta = placeholder.getItemMeta();
        itemMeta.displayName(Component.text("§c"));
        placeholder.setItemMeta(itemMeta);
        for (int i = 0; i < 20; i++) inventory.setItem(i, placeholder);
        for (int i = 25; i < 29; i++) inventory.setItem(i, placeholder);
        for (int i = 34; i < 54; i++) inventory.setItem(i, placeholder);
        alphabet = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta alphabetItemMeta = alphabet.getItemMeta();
        alphabetItemMeta.displayName(Component.text("Alphabet"));
        alphabet.setItemMeta(alphabetItemMeta);
        inventory.setItem(20, alphabet);
        player.openInventory(inventory);
        player.setMetadata("OpenedMenu", new FixedMetadataValue(BauSystem.getInstance(), inventory));
    }

    public static void openAlphabetPage1(Player player) {
        alphabetPage1 = Bukkit.createInventory(null, 54, "SkullRepo - Alphabet");
        fillBorder(alphabetPage1);

        player.openInventory(alphabetPage1);
    }

    public static void openAlphabetPage2(Player player) {
        alphabetPage2 = Bukkit.createInventory(null, 54, "SkullRepo - Alphabet");
        fillBorder(alphabetPage2);

        player.openInventory(alphabetPage2);
    }

    public static void openAlphabetPage3(Player player) {
        alphabetPage3 = Bukkit.createInventory(null, 54, "SkullRepo - Alphabet");
        fillBorder(alphabetPage3);

        player.openInventory(alphabetPage3);

    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack itemStack = event.getCurrentItem();
        if (event.getView().title().equals(Component.text("SkullRepo"))) {
            if (event.getSlot() == 20) {
                event.setCancelled(true);
                player.closeInventory();
                openAlphabetPage1(player);
            }
            if (itemStack.getType() == Material.BLUE_STAINED_GLASS_PANE) event.setCancelled(true);
        } else if (event.getView().title().contains(Component.text("SkullRepo - "))) {
            if (event.getSlot() == 53 || event.getSlot() == 45) {
                if (event.getInventory() == alphabetPage1) {
                    if (event.getSlot() == 53) {
                        event.setCancelled(true);
                        player.closeInventory();
                        openAlphabetPage2(player);
                    }
                } else if (event.getInventory() == alphabetPage2) {
                    if (event.getSlot() == 45) {
                        event.setCancelled(true);
                        player.closeInventory();
                        openAlphabetPage1(player);
                    } else if (event.getSlot() == 53) {
                        event.setCancelled(true);
                        player.closeInventory();
                        openAlphabetPage3(player);
                    }
                } else if (event.getInventory() == alphabetPage3) {
                    if (event.getSlot() == 45) {
                        event.setCancelled(true);
                        player.closeInventory();
                        openAlphabetPage2(player);
                    }
                }
            } else {
                if (itemStack != null)
                player.getInventory().addItem(itemStack);
                event.setCancelled(true);
            }
            event.setCancelled(true);
        }
        event.setCancelled(true);
        if (itemStack.getType() == Material.BLUE_STAINED_GLASS_PANE) event.setCancelled(true);
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (player.hasMetadata("OpenedMenu")) player.removeMetadata("OpenedMenu", BauSystem.getInstance());
    }

    public static void fillBorder(Inventory inventory) {
        ItemStack placeholder = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
        placeholder.getItemMeta().displayName(Component.text("§c"));
        ArrayList<Integer> toFill = new ArrayList<>();
        toFill.add(18);
        toFill.add(27);
        toFill.add(36);
        toFill.add(17);
        toFill.add(26);
        toFill.add(35);
        toFill.add(44);
        for (int i = 0; i < 53; i++) {
            if (i < 10 || i > 45) inventory.setItem(i, placeholder);
            if (toFill.contains(i)) inventory.setItem(i, placeholder);
        }
        nextButton = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta nextButtonItemMeta = nextButton.getItemMeta();
        nextButtonItemMeta.displayName(Component.text("Next"));
        nextButton.setItemMeta(nextButtonItemMeta);
        backButton = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta backButtonItemMeta = backButton.getItemMeta();
        backButtonItemMeta.displayName(Component.text("Back"));
        backButton.setItemMeta(backButtonItemMeta);
        if (inventory.equals(alphabetPage1)) {
            inventory.setItem(45, placeholder);
            inventory.setItem(53, nextButton);
        }
        if (inventory.equals(alphabetPage2)) {
            inventory.setItem(45, backButton);
            inventory.setItem(53, nextButton);
        }
        if (inventory.equals(alphabetPage3)) {
            inventory.setItem(45, backButton);
            inventory.setItem(53, placeholder);
        }
//        inventory.setItem(45, backButton);
//        inventory.setItem(54, nextButton);
    }
}
