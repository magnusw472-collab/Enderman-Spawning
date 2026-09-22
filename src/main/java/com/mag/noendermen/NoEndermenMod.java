package com.mag.noendermen;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.server.world.ServerWorld;

/**
 * Removes Endermen the instant they load into the world, regardless of how
 * they came to exist - natural spawning, a mob spawner, a spawn egg, or
 * /summon. Same pattern used for the elytra-removal mod: rather than try
 * to intercept and cancel the spawn attempt itself (which would need a
 * "cancel spawn" API this Fabric API version doesn't actually expose),
 * this lets the entity load and then immediately discards it before it
 * can act or a player would meaningfully perceive it.
 */
public class NoEndermenMod implements ModInitializer {

    @Override
    public void onInitialize() {
        ServerEntityEvents.ENTITY_LOAD.register(NoEndermenMod::onEntityLoad);
    }

    private static void onEntityLoad(Entity entity, ServerWorld world) {
        if (entity.getType() == EntityType.ENDERMAN) {
            entity.discard();
        }
    }
}
