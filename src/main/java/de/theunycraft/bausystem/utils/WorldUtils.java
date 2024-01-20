package de.theunycraft.bausystem.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;

public class WorldUtils {

    public static void createWorld(String name, WorldType type, String seed) {
        switch (type) {
            case NORMAL:
                if (seed != null)
                Bukkit.createWorld(new WorldCreator(name));
                else Bukkit.createWorld(new WorldCreator(name).seed(Long.parseLong(seed)));
                break;
            case LARGE_BIOMES:
                if (seed != null)
                Bukkit.createWorld(new WorldCreator(name).type(org.bukkit.WorldType.NORMAL));
                else Bukkit.createWorld(new WorldCreator(name).type(org.bukkit.WorldType.NORMAL).seed(Long.parseLong(seed)));
                break;
            case AMPLIFIED:
                if (seed != null)
                Bukkit.createWorld(new WorldCreator(name).type(org.bukkit.WorldType.AMPLIFIED));
                else Bukkit.createWorld(new WorldCreator(name).type(org.bukkit.WorldType.AMPLIFIED).seed(Long.parseLong(seed)));
                break;
            case FLAT:
                if (seed != null)
                Bukkit.createWorld(new WorldCreator(name).type(org.bukkit.WorldType.FLAT));
                else Bukkit.createWorld(new WorldCreator(name).type(org.bukkit.WorldType.FLAT).seed(Long.parseLong(seed)));
                break;
            case VOID:
                if (seed != null)
                Bukkit.createWorld(new WorldCreator(name).type(org.bukkit.WorldType.FLAT).environment(World.Environment.CUSTOM).generateStructures(false).generatorSettings("3;minecraft:air;127;decoration").seed(0));
                else Bukkit.createWorld(new WorldCreator(name).type(org.bukkit.WorldType.FLAT).environment(World.Environment.CUSTOM).generateStructures(false).generatorSettings("3;minecraft:air;127;decoration").seed(Long.parseLong(seed)));
                break;
        }
    }

    public enum WorldType {
        NORMAL,
        LARGE_BIOMES,
        AMPLIFIED,
        FLAT,
        VOID,
    }

}
