package de.theunycraft.bausystem.commands.worlds;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import de.theunycraft.bausystem.BauSystem;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

@CommandAlias("world")
@CommandPermission("build.world.tp")
@Description("teleport to a world")
public class TpWorldCommand extends BaseCommand {

    @Default
    @Subcommand("tp")
    @Description("help to teleport to a world")
    public void help(CommandSender sender) {
        sender.sendMessage(BauSystem.PREFIX + "§7Usage: /world tp <worldname> [player]");
    }

    @Subcommand("tp")
    @Description("teleport to a world")
    public void tpWorld(CommandSender sender, String worldname, @Optional String player) {
        sender.sendMessage(BauSystem.PREFIX + "§7Teleporting to world...");
        if (!(player == null)) {
            Bukkit.getPlayer(player).teleport(Bukkit.getWorld(worldname).getSpawnLocation());
        }
        Bukkit.getPlayer(sender.getName()).teleport(Bukkit.getWorld(worldname).getSpawnLocation());
    }

}
