package net.thetaciturnone.berrybird.entity;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thetaciturnone.berrybird.BerryBird;
import net.thetaciturnone.berrybird.entity.custom.BerryBirdEntity;

public class ModEntities {
    public static final EntityType<BerryBirdEntity> BERRY_BIRD = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(BerryBird.MOD_ID, "berry_bird"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, BerryBirdEntity::new)
                    .dimensions(EntityDimensions.fixed((float) 0.6, (float) 0.6)).build());

    public static <T extends Entity> EntityType<T> registerEntity(String name, EntityType<T> entry) {
        return Registry.register(
                Registry.ENTITY_TYPE,
                new Identifier(BerryBird.MOD_ID, name),
                entry
        );
    }
}
