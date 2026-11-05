package com.fossman.obviousrecipes.spawners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.Event.Result;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

/** Places the deliberately marked spawner recipe result without requiring OP. */
public final class ObviousRecipesSpawnersPlugin extends JavaPlugin implements Listener {
    private static final String CHICKEN_SPAWNER_NAME = "Chicken Spawner";

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlaceSpawner(PlayerInteractEvent event) {
        if (event.getHand() != EquipmentSlot.HAND || event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        ItemStack stack = event.getItem();
        if (!isCraftedChickenSpawner(stack)) {
            return;
        }
        Block clicked = event.getClickedBlock();
        if (clicked == null) {
            return;
        }
        Block target = clicked.getRelative(event.getBlockFace());
        if (!target.isReplaceable() || event.useInteractedBlock() == Result.DENY) {
            return;
        }

        event.setCancelled(true);
        target.setType(Material.SPAWNER, false);
        if (target.getState() instanceof CreatureSpawner spawner) {
            spawner.setSpawnedType(EntityType.CHICKEN);
            spawner.update(true, false);
            if (!event.getPlayer().getGameMode().isInvulnerable()) {
                stack.subtract(1);
            }
        } else {
            target.setType(Material.AIR, false);
            getLogger().warning("Spawner block did not expose CreatureSpawner state; item was not consumed.");
        }
    }

    private static boolean isCraftedChickenSpawner(ItemStack stack) {
        if (stack == null || stack.getType() != Material.SPAWNER || !stack.hasItemMeta()) {
            return false;
        }
        ItemMeta meta = stack.getItemMeta();
        return meta.hasDisplayName() && CHICKEN_SPAWNER_NAME.equals(meta.getDisplayName());
    }
}
