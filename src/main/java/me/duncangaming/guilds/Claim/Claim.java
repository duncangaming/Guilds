package me.duncangaming.guilds.Claim;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Claim implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("claim")) {
            if (sender instanceof Player) {

                if (sender.hasPermission("guilds.player")) {

                    Player p = (Player) sender;
                  Chunk claim = p.getLocation().getChunk();


                } else {
                    sender.sendMessage(ChatColor.RED + "You don't have permission to run this command");
                }

            } else {
                sender.sendMessage(ChatColor.RED + "Only players can run this command");
            }
        }
        return false;
    }
}
