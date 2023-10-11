package com.fossman.obviousrecipes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import com.fossman.obviousrecipes.recipes.SmeltingRecipes;
import com.fossman.obviousrecipes.utils.CraftingHandler;

@Mod(modid = obviousrecipes.MODID, name = obviousrecipes.NAME, version = obviousrecipes.VERSION)
public class obviousrecipes
{
    public static final String MODID = "obviousrecipes";
    public static final String NAME = "Obvious Recipes";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        CraftingHandler.removeRecipes();
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("{} Version {} loaded", NAME, VERSION);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        SmeltingRecipes.add();
    }
}
