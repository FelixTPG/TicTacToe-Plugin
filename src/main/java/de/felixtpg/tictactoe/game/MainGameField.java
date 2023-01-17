package de.felixtpg.tictactoe.game;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.ArrayList;
import java.util.Random;

public class MainGameField implements Listener {

    ArrayList<GameStand> stands = new ArrayList<>();

    public ArrayList<GameStand> getStands() {
        return stands;
    }

    public void setStands(ArrayList<GameStand> stands) {
        this.stands = stands;
    }

    public Location getGameFieldLocation() {
        return gameFieldLocation;
    }

    public void setGameFieldLocation(Location gameFieldLocation) {
        this.gameFieldLocation = gameFieldLocation;
    }

    Location gameFieldLocation;
    public MainGameField(Location gameFieldLocation) {
        this.gameFieldLocation = gameFieldLocation;
        setupGameField(gameFieldLocation, stands);
    }

    public void setupGameField(Location gameFieldLocation, ArrayList<GameStand> stands) {
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

    public void despawn(ArrayList<GameStand> stands) {
        stands.forEach(GameStand::despawn);
    }

    @EventHandler
    public void onStandInteract(PlayerInteractAtEntityEvent event) {
        stands.forEach((c) -> {
            if (c.getStand().equals(event.getRightClicked())) {
                event.getPlayer().sendMessage("DEBUG - GUI OPEN");
                Random r = new Random();
                c.setState(r.nextInt(3), c.getStand());
                event.setCancelled(true);
            }
        });
    }

}
