package de.theunycraft.bausystem.commands.worlds;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import de.theunycraft.bausystem.BauSystem;
import de.theunycraft.bausystem.utils.WorldUtils;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

@CommandAlias("world")
@CommandPermission("build.world.create")
@Description("Create a world")
public class CreateWorldCommand extends BaseCommand {

    @Default
    @Subcommand("world")
    @Description("help to create a world")
    public void help(CommandSender sender) {
        sender.sendMessage(BauSystem.PREFIX + "§7Usage: /create world <worldname> <worldtype> [worldseed]");
        sender.sendMessage(BauSystem.PREFIX + "§7Worldtype: §cFLAT, NORMAL, LARGE_BIOMES, AMPLIFIED, VOID");
    }

    @Subcommand("world")
    @CommandCompletion("@worlds FLAT|NORMAL|LARGE_BIOMES|AMPLIFIED|VOID")
    public void createWorld(CommandSender sender, String worldname, String worldtype, @Optional String worldseed) {
        sender.sendMessage(BauSystem.PREFIX + "§7Creating world...");
        sender.sendMessage(BauSystem.PREFIX + "§7Worldname: §c" + worldname);
        sender.sendMessage(BauSystem.PREFIX + "§7Worldtype: §c" + worldtype);
        sender.sendMessage(BauSystem.PREFIX + "§7Worldseed: §c" + worldseed);
        WorldUtils.createWorld(worldname, WorldUtils.WorldType.valueOf(worldtype), worldseed);

    }

}
