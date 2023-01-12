package de.felixtpg.tictactoe;

import de.felixtpg.tictactoe.utils.PluginUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    PluginUtils pluginUtils;

    @Override
    public void onEnable() {
        this.pluginUtils = new PluginUtils(this);
    }

    @Override
    public void onDisable() {

    }
}
