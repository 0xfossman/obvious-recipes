package com.fossman.obviousrecipes;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ObviousRecipesMod implements ModInitializer {
  public static final String MOD_ID = "obviousrecipes";
  private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
    LOGGER.info("Obvious Recipes initialized.");
  }
}
