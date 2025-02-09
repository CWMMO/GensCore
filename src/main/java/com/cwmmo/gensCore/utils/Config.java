package com.cwmmo.gensCore.utils;

import com.cwmmo.gensCore.GensCore;
import com.cwmmo.gensCore.core.Generator;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

@SuppressWarnings("unused")
public class Config {
    private static final GensCore INSTANCE = GensCore.INSTANCE;

    @SuppressWarnings("DataFlowIssue")
    public static ItemStack getItemFromConfig(String path, String... loreFormat) {
        FileConfiguration config = INSTANCE.getConfig();

        String materialName = config.getString(path + ".material", "STONE");
        String displayName = config.getString(path + ".name");
        List<String> lore = config.getStringList(path + ".lore");

        int amount = config.getInt(path + ".amount", 1);

        Material material = Material.matchMaterial(materialName);
        if (material == null) {
            return new ItemStack(Material.STONE);
        }

        ItemStack item = new ItemStack(material, amount);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            if (displayName != null)
                meta.displayName(asComponent(displayName));
            if (!lore.isEmpty()) {
                for (String line : lore)
                    meta.lore().add(asComponent(line));
            }
            item.setItemMeta(meta);
        }

        return item;
    }

    public static Component asComponent(String string) {
        return MiniMessage.miniMessage().deserialize(string);
    }

    public static class GenLoader {
        public static void loadGens() {

        }

        public static Generator getGenerator(String path) {

            ItemStack generatedItem = Config.getItemFromConfig(path+".item");

        }
    }
}
