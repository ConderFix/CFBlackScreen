package ru.quizie.cfblackscreen;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    public static void load(FileConfiguration configuration) {
        ticks = configuration.getInt("ticks");
    }

    public static int ticks;
}
