package de.felixtpg.tictactoe;

import de.felixtpg.tictactoe.commands.GetSkullCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("getskull").setExecutor(new GetSkullCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
