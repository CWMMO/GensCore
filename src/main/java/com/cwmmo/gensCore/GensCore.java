package com.cwmmo.gensCore;

import org.bukkit.plugin.java.JavaPlugin;

public final class GensCore extends JavaPlugin {

    @Override
    public void onEnable() {
        INSTANCE = this;
        if (!getDataFolder().exists())
            getDataFolder().mkdirs();
        if(!dataF.exists())
            dataF.mkdirs();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
