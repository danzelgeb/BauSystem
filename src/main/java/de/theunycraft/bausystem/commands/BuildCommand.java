package de.theunycraft.bausystem.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import org.bukkit.command.CommandSender;
import org.checkerframework.checker.units.qual.C;

@CommandAlias("build|bauen|bau")
@CommandPermission("build.gui")
@Description("Open the Build GUI")
public class BuildCommand extends BaseCommand {

    @Default
    @Description("Open the gui")
    public void openGui(CommandSender sender) {

    }

}
