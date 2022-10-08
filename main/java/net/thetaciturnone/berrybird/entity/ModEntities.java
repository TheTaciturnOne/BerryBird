package net.thetaciturnone.berrybird.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.thetaciturnone.berrybird.BerryBird;
import net.thetaciturnone.berrybird.entity.custom.BerryBirdEntity;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<BerryBirdEntity> BERRY_BIRD = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(BerryBird.MOD_ID, "berry_bird"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BerryBirdEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.4f)).build());
    }
