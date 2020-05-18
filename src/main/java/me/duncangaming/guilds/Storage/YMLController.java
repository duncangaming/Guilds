package me.duncangaming.guilds.Storage;

import org.bukkit.configuration.file.FileConfiguration;

public class YMLController {

    public YMLController(FileConfiguration config) {
        this.config = config;
    }

    FileConfiguration config;

    public FileConfiguration getConfig() {

        return config;
    }

    public Object get(String path) {
        return config.get(path);
    }

    public void setConfig(String path, Object value) {
        config.set(path, value);
    }
}
