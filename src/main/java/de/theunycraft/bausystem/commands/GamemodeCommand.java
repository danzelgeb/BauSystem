package de.theunycraft.bausystem.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import de.theunycraft.bausystem.BauSystem;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("gm|gamemode")
@CommandPermission("build.gamemode")
@Description("Advanced Gamemode command")
public class GamemodeCommand extends BaseCommand {

    @Default
    @Subcommand("help")
    @Description("get a help for the command")
    public void help(CommandSender sender) {
        sender.sendMessage(BauSystem.PREFIX + "Usage: /gm <0|1|2|3> [player]");
    }

    @Subcommand("0|survival|s")
    @CommandCompletion("@players")
    @Description("Set gamemode to Survival")
    public void gamemodeSurvival(CommandSender sender, @Optional String player) {
        Player target = null;
        if (player == null) {
            target = (Player) sender;
        } else  {
            target = Bukkit.getPlayer(player);
            sender.sendMessage(BauSystem.PREFIX + "You have set the gamemode of " + target.getName() + "to §cSurvival");
        }
        if (target == null) return;
        target.setGameMode(GameMode.SURVIVAL);
        target.sendMessage(BauSystem.PREFIX + "Your gammmode was set to §cSurvival");
    }

    @Subcommand("1|creative|c")
    @CommandCompletion("@players")
    @Description("Set gamemode to Creative")
    public void gamemodeCreative(CommandSender sender, @Optional String player) {
        Player target = null;
        if (player == null) {
            target = (Player) sender;
        } else  {
            target = Bukkit.getPlayer(player);
            sender.sendMessage(BauSystem.PREFIX + "You have set the gamemode of " + target.getName() + "to §cCreative");
        }
        if (target == null) return;
        target.setGameMode(GameMode.CREATIVE);
        target.sendMessage(BauSystem.PREFIX + "Your gammmode was set to §cCreative");
    }

    @Subcommand("2|adventure|a")
    @CommandCompletion("@players")
    @Description("Set gamemode to Creative")
    public void gamemodeAdventure(CommandSender sender, @Optional String player) {
        Player target = null;
        if (player == null) {
            target = (Player) sender;
        } else  {
            target = Bukkit.getPlayer(player);
            sender.sendMessage(BauSystem.PREFIX + "You have set the gamemode of " + target.getName() + "to §cAdventure");
        }
        if (target == null) return;
        target.setGameMode(GameMode.ADVENTURE);
        target.sendMessage(BauSystem.PREFIX + "Your gammmode was set to §cAdventure");
    }

    @Subcommand("3|spectator|sp")
    @CommandCompletion("@players")
    @Description("Set gamemode to Creative")
    public void gamemodeSpectator(CommandSender sender, @Optional String player) {
        Player target = null;
        if (player == null) {
            target = (Player) sender;
        } else  {
            target = Bukkit.getPlayer(player);
            sender.sendMessage(BauSystem.PREFIX + "You have set the gamemode of " + target.getName() + "to §cAdventure");
        }
        if (target == null) return;
        target.setGameMode(GameMode.ADVENTURE);
        target.sendMessage(BauSystem.PREFIX + "Your gammmode was set to §cAdventure");
    }

}
