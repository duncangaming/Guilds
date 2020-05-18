package me.duncangaming.guilds.Crates;

import me.duncangaming.guilds.Storage.YMLController;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class Create implements CommandExecutor, Listener {

    public Create(YMLController config) {
        this.config = config;
    }
    YMLController config;

    HashMap<UUID, String> addRewards = new HashMap<UUID, String>();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("crates")) {
            if (sender instanceof Player) {
                if (args.length != 0) {
                    if (args[0].equalsIgnoreCase("create")) {
                        if (sender.hasPermission("crates.admin")) {
                        	if (args[1].length() != 0) {
                        		 openInv((Player) sender);
                                 addRewards.put(((Player) sender).getPlayer().getUniqueId(), args[1]);
                        		} else {
                        			
                        			sender.sendMessage(ChatColor.RED + "Please name your crate");
                        			
                        		}
                           
                            } else {
                            sender.sendMessage(ChatColor.RED + "You don't have permission to run this command");

                            }
                        }
                    } else {
                    sender.sendMessage("");

                    }

                } else {
                sender.sendMessage(ChatColor.RED + "You must be a player to run this command");
            }
            return true;
            }

        return false;
    }

    public Inventory openInv(Player p) {
        Inventory inv = Bukkit.createInventory(null, 36, "Crate Rewards");
        p.openInventory(inv);
        return inv;
    }

    public void closeCrate(InventoryCloseEvent e) {

        if (e.getView().getTitle().equalsIgnoreCase("crate rewards")) {
            config.setConfig(addRewards.get(e.getPlayer().getUniqueId()), e.getInventory().getContents());
            addRewards.remove(e.getPlayer().getUniqueId());
        }

    }

}
