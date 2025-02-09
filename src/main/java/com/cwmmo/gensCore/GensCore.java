package com.cwmmo.gensCore;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class GensCore extends JavaPlugin {

    public static GensCore INSTANCE;
    File dataF = new File(getDataFolder(), "data");
    public File getdataF(){ return dataF; }

    @SuppressWarnings("ResultOfMethodCallIgnored")
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
