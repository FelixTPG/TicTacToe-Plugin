package de.felixtpg.tictactoe.game;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

public class Game {

    Player[] players;
    ArmorStand[] armorStands;
    public Game(Player[] players) {
        this.players = players;
    }

}
