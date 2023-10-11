package com.domi382.obviousrecipes.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

public class SmeltingRecipes{
    public static void add() {
        final float xp = 1.0F;
        //Rotten Flesh -> Leather
        GameRegistry.addSmelting(Items.ROTTEN_FLESH,        new ItemStack(Items.LEATHER, 1), xp);
        /*
        //Deactivated until I find a solution for replaceing Vanilla Smelting Recipes
        //Iron Stuff -> Iron Ingot (instead of Iron Nugget)
        GameRegistry.addSmelting(Items.IRON_HELMET,         new ItemStack(Items.IRON_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.IRON_CHESTPLATE,     new ItemStack(Items.IRON_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.IRON_LEGGINGS,       new ItemStack(Items.IRON_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.IRON_BOOTS,          new ItemStack(Items.IRON_INGOT, 1), xp);

        GameRegistry.addSmelting(Items.IRON_PICKAXE,        new ItemStack(Items.IRON_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.IRON_SHOVEL,         new ItemStack(Items.IRON_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.IRON_AXE,            new ItemStack(Items.IRON_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.IRON_SWORD,          new ItemStack(Items.IRON_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.IRON_HOE,            new ItemStack(Items.IRON_INGOT, 1), xp);

        //Gold Stuff -> Gold Ingot (instead of Gold Nugget)
        GameRegistry.addSmelting(Items.GOLDEN_HELMET,       new ItemStack(Items.GOLD_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.GOLDEN_CHESTPLATE,   new ItemStack(Items.GOLD_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.GOLDEN_LEGGINGS,     new ItemStack(Items.GOLD_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.GOLDEN_BOOTS,        new ItemStack(Items.GOLD_INGOT, 1), xp);

        GameRegistry.addSmelting(Items.GOLDEN_PICKAXE,      new ItemStack(Items.GOLD_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.GOLDEN_SHOVEL,       new ItemStack(Items.GOLD_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.GOLDEN_AXE,          new ItemStack(Items.GOLD_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.GOLDEN_SWORD,        new ItemStack(Items.GOLD_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.GOLDEN_HOE,          new ItemStack(Items.GOLD_INGOT, 1), xp);
        */
        //Horse Armor Smelting
        GameRegistry.addSmelting(Items.IRON_HORSE_ARMOR,    new ItemStack(Items.IRON_INGOT, 1), xp);
        GameRegistry.addSmelting(Items.GOLDEN_HORSE_ARMOR,  new ItemStack(Items.GOLD_INGOT, 1), xp);

        //Cauldron Smelting
        GameRegistry.addSmelting(Items.CAULDRON,            new ItemStack(Items.IRON_INGOT, 7), xp);

        //Iron Door Smelting
        GameRegistry.addSmelting(Items.IRON_DOOR,           new ItemStack(Items.IRON_INGOT, 6), xp);

        //Iron Trapdoor Smelting
        GameRegistry.addSmelting(Blocks.IRON_TRAPDOOR,      new ItemStack(Items.IRON_INGOT, 6), xp);

        //Iron Bar Smelting
        GameRegistry.addSmelting(Blocks.IRON_BARS,          new ItemStack(Items.IRON_NUGGET, 5), xp);

        //Bucket Smelting
        GameRegistry.addSmelting(Items.BUCKET,              new ItemStack(Items.IRON_INGOT, 3), xp);

        //Pressure Plate Smelting
        GameRegistry.addSmelting(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, new ItemStack(Items.GOLD_INGOT, 2), xp);
        GameRegistry.addSmelting(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, new ItemStack(Items.IRON_INGOT, 2), xp);
    }
}
