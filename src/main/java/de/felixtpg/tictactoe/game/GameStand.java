package de.felixtpg.tictactoe.game;

import de.felixtpg.tictactoe.utils.PluginUtils;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

import java.util.Objects;

public class GameStand {

    Location spawnLoc;
    int state;
    ArmorStand stand;
    public GameStand(Location spawnLoc, int state) {
        this.spawnLoc = spawnLoc;
        this.state = state;

        this.create(spawnLoc, state);
    }

    public Location getSpawnLoc() {
        return spawnLoc;
    }

    public ArmorStand getStand() {
        return stand;
    }

    public int getState() {
        return state;
    }

    public void create(Location spawnLoc, int state) {
        ArmorStand stand = (ArmorStand) PluginUtils.setStandValues(spawnLoc.getWorld().spawn(spawnLoc, ArmorStand.class));
        stand.setHelmet(PluginUtils.getHeadItem(state));
        this.stand = stand;
    }

    public void setState(int state, ArmorStand stand) {
        this.state = state;
        stand.setHelmet(PluginUtils.getHeadItem(state));
        this.stand = stand;
    }

    public void despawn() {
        stand.remove();
        this.stand = null;
    }

}
