package de.theunycraft.bausystem;

import co.aikar.commands.PaperCommandManager;
import de.theunycraft.bausystem.commands.BuildCommand;
import de.theunycraft.bausystem.commands.worlds.CreateWorldCommand;
import de.theunycraft.bausystem.commands.GamemodeCommand;
import de.theunycraft.bausystem.commands.SkullRepoCommand;
import de.theunycraft.bausystem.gui.BuildGUI;
import de.theunycraft.bausystem.gui.SkullRepoGUI;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class BauSystem extends JavaPlugin {
    @Getter private static BauSystem instance;
    public static final String PREFIX = "§6•§e● Build §8▎ §7";
    private PaperCommandManager commandManager;
    @Override
    public void onEnable() {
        instance = this;
        commandManager = new PaperCommandManager(this);
        commandManager.registerCommand(new BuildCommand());
        commandManager.registerCommand(new GamemodeCommand());
        commandManager.registerCommand(new SkullRepoCommand());
        commandManager.registerCommand(new CreateWorldCommand());

        Bukkit.getPluginManager().registerEvents(new BuildGUI(), this);
        Bukkit.getPluginManager().registerEvents(new SkullRepoGUI(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
