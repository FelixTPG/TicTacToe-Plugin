package de.felixtpg.tictactoe;

import de.felixtpg.tictactoe.commands.SetGameFieldLocationCommand;
import de.felixtpg.tictactoe.game.MainGameField;
import de.felixtpg.tictactoe.utils.PluginUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.m;

public final class Main extends JavaPlugin {

    PluginUtils pluginUtils;
    MainGameField mainGameField;

    @Override
    public void onEnable() {
        this.pluginUtils = new PluginUtils(this);
        if (getConfig().getString("data.location.gamefield") != null) {
            this.mainGameField = new MainGameField(PluginUtils.getLocationFromString(getConfig().getString("data.location.gamefield")));
        }

        getCommand("setgamefieldlocation").setExecutor(new SetGameFieldLocationCommand(this));

        Bukkit.getPluginManager().registerEvents(mainGameField, this);
    }

    @Override
    public void onDisable() {
        this.mainGameField.despawn(mainGameField.getStands());
    }
}
