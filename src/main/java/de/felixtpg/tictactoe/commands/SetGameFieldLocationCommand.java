package de.felixtpg.tictactoe.commands;

import de.felixtpg.tictactoe.utils.PluginUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SetGameFieldLocationCommand implements CommandExecutor {

    JavaPlugin plugin;
    public SetGameFieldLocationCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cDazu musst du ein Spieler sein.");
            return false;
        }
        Player player = (Player) sender;
        if (!(player.hasPermission("tictactoe.command.setgamefieldlocation"))) {
            player.sendMessage("§cDazu hast du keine Rechte.");
            return false;
        }
        if (args.length != 0) {
            player.sendMessage("§cBenutzung:");
            player.sendMessage("§c/" + label);
            return false;
        }

        try {
            plugin.getConfig().set("data.location.gamefield", PluginUtils.getStringToLocation(player.getLocation()));
            plugin.saveConfig();
            player.sendMessage("§aDeine Position wurde erfolgreich.");
        } catch (Exception exception) {
            player.sendMessage("§cEs ist ein Fehler beim speichern aufgetreten.");
            exception.printStackTrace();
        }

        return false;
    }

}
