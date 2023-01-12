package de.felixtpg.tictactoe.game;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;

public class MainGameField {

    ArrayList<ArmorStand> stands;
    Location gameFieldLocation;
    public MainGameField(Location gameFieldLocation) {
        this.gameFieldLocation = gameFieldLocation;
    }

    public void setupGameField(Location gameFieldLocation, ArrayList<ArmorStand> stands) {
        gameFieldLocation.setY(gameFieldLocation.getBlockY()-1);

        for (int i = 0; i < 3; i++) {
            ArmorStand as = (ArmorStand) gameFieldLocation.getWorld().spawn(gameFieldLocation, ArmorStand.class);
            for (int y = 0; i < 3; i++) {

            }
        }
    }

}
