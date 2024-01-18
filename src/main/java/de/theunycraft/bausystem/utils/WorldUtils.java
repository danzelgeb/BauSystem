package de.theunycraft.bausystem.utils;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.block.Biome;

public class WorldUtils {

    public static void createWorld(String name, WorldType type, Biome biome) {
        Bukkit.createWorld(new WorldCreator(name));
    }

    public enum WorldType {
        NORMAL,
        LARGE_BIOMES,
        SINGLE_BIOME,
        FLAT,
        VOID,
    }

}
