package de.theunycraft.bausystem.gui;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.checkerframework.checker.units.qual.C;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SkullRepoGUI  implements Listener {
    private static Inventory inventory;
    private static Inventory alphabetPage1;
    private static Inventory alphabetPage2;
    private static Inventory alphabetPage3;

    public static void openGUI(Player player) {
        inventory = Bukkit.createInventory(null, 54, Component.text("SkullRepo"));
        ItemStack placeholder = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
        ItemMeta itemMeta = placeholder.getItemMeta();
        itemMeta.displayName(Component.text("§c"));
        placeholder.setItemMeta(itemMeta);
        for (int i = 0; i < 20; i++) inventory.setItem(i, placeholder);
        for (int i = 25; i < 29; i++) inventory.setItem(i, placeholder);
        for (int i = 34; i < 54; i++) inventory.setItem(i, placeholder);
        ItemStack alphabet = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta alphabetItemMeta = alphabet.getItemMeta();
        alphabetItemMeta.displayName(Component.text("Alphabet"));
        alphabet.setItemMeta(alphabetItemMeta);
        inventory.setItem(20, alphabet);
        player.openInventory(inventory);
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
        if (event.getView().title().equals(Component.text("SkullRepo"))) {
            if (event.getCurrentItem().displayName().equals(Component.text("Alphabet"))) {
                player.closeInventory();
                openAlphabetPage1(player);
            }
            event.setCancelled(true);
        } else if (event.getView().title().contains(Component.text("SkullRepo - "))) {
            player.getInventory().addItem(event.getCurrentItem());
            event.setCancelled(true);
        }
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
        toFill.add(34);
        for (int i = 0; i < 53; i++) {
            if (i < 10 || i > 46) inventory.setItem(i, placeholder);
            if (toFill.contains(i)) inventory.setItem(i, placeholder);
        }
        ItemStack nextButton = new ItemStack(Material.PLAYER_HEAD);
        ItemStack backButton = new ItemStack(Material.PLAYER_HEAD);
        if (inventory.equals(inventory)) return;
        if (inventory.equals(alphabetPage1)) inventory.setItem(54, nextButton);
        if (inventory.equals(alphabetPage2)) {
            inventory.setItem(45, backButton);
            inventory.setItem(54, nextButton);
        }
        if (inventory.equals(alphabetPage3)) inventory.setItem(54, nextButton);
//        inventory.setItem(45, backButton);
//        inventory.setItem(54, nextButton);
    }
}
