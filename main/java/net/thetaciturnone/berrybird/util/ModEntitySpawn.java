package net.thetaciturnone.berrybird.util;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.thetaciturnone.berrybird.entity.ModEntities;

public class ModEntitySpawn {
    public static void addEntitySpawn() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.GROVE), SpawnGroup.CREATURE,
                ModEntities.BERRY_BIRD, 10, 1, 2);

    }
}
