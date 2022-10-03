package net.thetaciturnone.berrybird;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.util.Identifier;
import net.thetaciturnone.berrybird.entity.ModEntities;
import net.thetaciturnone.berrybird.entity.custom.BerryBirdEntity;
import net.thetaciturnone.berrybird.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class BerryBird implements ModInitializer {
	public static final String MOD_ID = "berrybird";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier makeID(String path) {
		return new Identifier(
				MOD_ID,
				path
		);
	}

	public static String makeStringID(String name) {
		return MOD_ID + ":" + name;
	}

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		BerryBirdEntity.canMobSpawn();
		FabricDefaultAttributeRegistry.register(ModEntities.BERRY_BIRD, BerryBirdEntity.setAttributes());
		GeckoLib.initialize();
	}


}
