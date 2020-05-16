package me.duncangaming.guilds;

import me.duncangaming.guilds.RandomTP.RandomTP;
import org.bukkit.plugin.java.JavaPlugin;

public final class Guilds extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("rtp").setExecutor(new RandomTP());
        this.getCommand("randomtp").setExecutor(new RandomTP());
        this.getCommand("wild").setExecutor(new RandomTP());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
