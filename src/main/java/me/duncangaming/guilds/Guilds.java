package me.duncangaming.guilds;

//import com.pablo67340.SQLiteLib.Main.SQLiteLib;
import me.duncangaming.guilds.Crates.Create;
import me.duncangaming.guilds.RandomTP.RandomTP;
import me.duncangaming.guilds.Storage.YMLController;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Guilds extends JavaPlugin {

   // public SQLiteLib sqlLib;
    public YMLController config;
    File CrateRewards = new File(getDataFolder(), "craterewards.yml");
    FileConfiguration rewardsconfig;
    @Override
    public void onEnable() {
        // Plugin startup logic
        rewardsconfig = YamlConfiguration.loadConfiguration(CrateRewards);
        if (!CrateRewards.exists()) {
            try {
                rewardsconfig.save(CrateRewards);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = new YMLController(rewardsconfig);
        //sqlLib = SQLiteLib.hookSQLiteLib(this);
        //sqlLib.initializeDatabase(this, "claims", "CREATE TABLE IF NOT EXISTS claimed_chunks ( Owner Player, Claim Chunk );");
        //sqlLib.getDatabase("claims").executeStatement("INSERT INTO claimed_chunks (Owner, Chunk) VALUES (" + Bukkit.getPlayer("DuncanGaming") + "");
        getServer().getPluginManager().registerEvents(new Create(config), this);
        this.getCommand("randomtp").setExecutor(new RandomTP());
        this.getCommand("crates").setExecutor(new Create(config));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        rewardsconfig = config.getConfig();
        try {
            rewardsconfig.save(CrateRewards);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
