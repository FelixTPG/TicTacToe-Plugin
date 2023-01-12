package de.felixtpg.tictactoe.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.UUID;

public class PluginUtils {

    JavaPlugin plugin;
    public PluginUtils(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public static final ArmorStand setMainArmorStandValues(ArmorStand armorStand) {
        armorStand.setGravity(false);
        armorStand.setArms(false);
        armorStand.setInvulnerable(true);
        armorStand.setVisible(false);
        armorStand.setCanPickupItems(false);
        armorStand.setCollidable(false);
        armorStand.setCustomNameVisible(false);
        armorStand.setBasePlate(false);
        armorStand.setSilent(true);
        return armorStand;
    }

    public static Location getLocationFromString(final String s) {
        if (s == null || s.trim().equals("")) {
            return null;
        }
        final String[] parts = s.split(":");
        if (parts.length == 4) {
            final World w = Bukkit.getServer().getWorld(parts[0]);
            final int x = Integer.parseInt(parts[1]);
            final int y = Integer.parseInt(parts[2]);
            final int z = Integer.parseInt(parts[3]);
            return new Location(w, x, y, z);
        }
        return null;
    }

    public static String getStringToLocation(final Location l) {
        if (l == null) {
            return "";
        }
        return Objects.requireNonNull(l.getWorld()).getName() + ":" + l.getBlockX() + ":" + l.getBlockY() + ":" + l.getBlockZ();
    }

    public static void setGameField(Location loc) {

    }

    public static ItemStack getSkull(String url) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);

        if (url == null || url.isEmpty())
            return skull;

        ItemMeta skullMeta = skull.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;

        try {
            profileField = skullMeta.getClass().getDeclaredField("profile");
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

        profileField.setAccessible(true);

        try {
            profileField.set(skullMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        skull.setItemMeta(skullMeta);
        return skull;
    }

}
