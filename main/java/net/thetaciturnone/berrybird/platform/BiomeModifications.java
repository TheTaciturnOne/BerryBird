package net.thetaciturnone.berrybird.platform;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.tag.TagKey;
import net.minecraft.world.biome.Biome;
import net.thetaciturnone.berrybird.entity.custom.BerryBirdEntity;

public final class BiomeModifications
{
    public static void addMobSpawn(
            TagKey<Biome> tag,
            EntityType<?> entityType,
            SpawnGroup spawnGroup,
            int weight,
            int minGroupSize,
            int maxGroupSize
    ) {
    }

    public static void addMobSpawn(TagKey<Biome> hasBerryBird, EntityType<BerryBirdEntity> berryBirdEntityEntityType, SpawnGroup berryBirdsCategory) {
    }
}