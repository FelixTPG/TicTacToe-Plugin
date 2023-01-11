package de.felixtpg.tictactoe;

import org.bukkit.Tag;
import org.bukkit.entity.ArmorStand;

public class GameArmorstand {

    ArmorStand stand;
    int id;
    int state;
    public GameArmorstand(ArmorStand stand, int id, int state) {
        this.stand = stand;
        this.id = id;
        this.state = state;
    }



}
