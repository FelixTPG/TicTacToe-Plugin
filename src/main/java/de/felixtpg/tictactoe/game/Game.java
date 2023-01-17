package de.felixtpg.tictactoe.game;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Game {

    Player first;
    Player second;
    Location gameFieldLocation;
    ArrayList<GameStand> stands = new ArrayList<>();
    public Game(Player first, Player second, Location gameFieldLocation) {
        this.start(first, second, gameFieldLocation);
    }

    public void start(Player first, Player second, Location gameFieldLocation) {
        this.first = first;
        this.second = second;
        this.gameFieldLocation = gameFieldLocation;

        // stands
        gameFieldLocation.add(-1.50, 0, -1.50);
        for (int x = 0; x < 3; x++) {
            stands.add(new GameStand(gameFieldLocation, 0));
            gameFieldLocation.add(1, 0, 0);
        }
        gameFieldLocation.add(-3, 0, 1);
        for (int x = 0; x < 3; x++) {
            stands.add(new GameStand(gameFieldLocation, 0));
            gameFieldLocation.add(1, 0, 0);
        }
        gameFieldLocation.add(-3, 0, 1);
        for (int x = 0; x < 3; x++) {
            stands.add(new GameStand(gameFieldLocation, 0));
            gameFieldLocation.add(1, 0, 0);
        }
    }

}
