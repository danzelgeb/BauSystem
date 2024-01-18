package de.theunycraft.bausystem.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import de.theunycraft.bausystem.gui.SkullRepoGUI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("skullrepo|repo|skulls")
@CommandPermission("build.skullrepo")
@Description("Getr the GUI for Skulls")
public class SkullRepoCommand extends BaseCommand {

    @Default
    @Description("open the gui")
    public void onOpen(CommandSender sender) {
        Player player = (Player) sender;
        SkullRepoGUI.openGUI(player);
    }

}
