package com.cwmmo.gensCore.core;

import org.apache.commons.lang3.NotImplementedException;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import org.jetbrains.annotations.ApiStatus.*;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({
        "unused",
        "FieldCanBeLocal",
        "FieldMayBeFinal"}
) public class Generator {
    private volatile int tier;

    private ItemStack item;
    private Block block;
    private Location location;

    @Internal
    @Experimental
    public Generator(int tier) { throw new NotImplementedException(); }

    @Obsolete
    public Generator(@NotNull Generator generator) {
        this.tier = generator.tier;
        this.item = generator.item;
        this.location = generator.location;
        this.block = generator.block;
    }
    public Generator(int tier,
                     @NotNull ItemStack item,
                     @NotNull Block block,
                     @NotNull Location location)
    {
        this.tier = tier;
        this.item = item;
        this.location = location;
        this.block = block;
    }
    public void generate(int boosterBoost, boolean nextTier) {
        if (nextTier) {
            Location _location = this.location.add(0D, 1D, 0D);
            ItemStack itemStack = new ItemStack(this.item);

            itemStack.setAmount(boosterBoost);

            _location.getWorld().dropItem(_location, itemStack);
        } else {

        }
    }
    public void generate() {}
}
