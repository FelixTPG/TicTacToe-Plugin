package de.felixtpg.tictactoe.commands;

import de.felixtpg.tictactoe.PluginUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetSkullCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(args.length == 1)) return false;
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        player.getInventory().addItem(PluginUtils.getSkull(args[0]));

        return false;
    }
}
