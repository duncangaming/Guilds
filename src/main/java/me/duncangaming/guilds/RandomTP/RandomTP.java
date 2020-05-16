package me.duncangaming.guilds.RandomTP;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class RandomTP implements CommandExecutor {

    public static Location randomLoc(Player p) {
        Location spawn = p.getWorld().getSpawnLocation();
        Random randX = new Random();
        Random randZ = new Random();
        int x;
        int z;
        x = randX.nextInt((500000 - (-500000)) + 1) - 500000;
        z = randZ.nextInt((500000 - (-500000)) + 1) - 500000;
        double y = p.getWorld().getHighestBlockAt(x, z).getLocation().getY();
        if (x < spawn.getX() - 100 || x > spawn.getZ() + 100) {
            if (z < spawn.getZ() - 100 || z > spawn.getZ() + 100) {
                Location loc = new Location(p.getWorld(), x, y + 2, z);
                return loc;
            }
        }
        return null;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("randomtp")) {
            if (sender instanceof Player) {
                if (sender.hasPermission("guilds.rtp") || sender.isOp() == true) {

                    Player player = (Player) sender;
                    if (randomLoc(player) != null) {
                        player.teleport(randomLoc(player));
                        player.sendMessage(ChatColor.GREEN + "You have been teleported to a random location!");
                    } else if (randomLoc(player) == null) {
                        player.sendMessage(ChatColor.RED + "Invalid Location, try again and it should work!");
                    }

                } else {
                    sender.sendMessage(ChatColor.RED + "You don't have permission to run this command");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You cannot run this command");
                return true;
            }

        }
        return false;

    }


}
