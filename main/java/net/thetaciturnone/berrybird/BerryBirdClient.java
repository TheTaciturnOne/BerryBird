package net.thetaciturnone.berrybird;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.thetaciturnone.berrybird.entity.ModEntities;
import net.thetaciturnone.berrybird.entity.client.BerryBirdRenderer;

public class BerryBirdClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.BERRY_BIRD, BerryBirdRenderer::new);

    }
}
