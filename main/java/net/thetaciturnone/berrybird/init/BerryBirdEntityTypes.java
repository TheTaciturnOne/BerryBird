package net.thetaciturnone.berrybird.init;

import net.minecraft.SharedConstants;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.thetaciturnone.berrybird.BerryBird;
import net.thetaciturnone.berrybird.entity.custom.BerryBirdEntity;
import net.thetaciturnone.berrybird.platform.BiomeModifications;
import net.thetaciturnone.berrybird.platform.CustomSpawnGroup;
import net.thetaciturnone.berrybird.platform.RegistryHelper;
import net.thetaciturnone.berrybird.tag.BerryBirdTags;

import java.util.function.Supplier;

import static net.minecraft.entity.mob.MobEntity.createMobAttributes;

public final class BerryBirdEntityTypes {
    public static boolean previousUseChoiceTypeRegistrations = SharedConstants.useChoiceTypeRegistrations;

    public static final Supplier<EntityType<BerryBirdEntity>> BERRY_BIRD;

    static {
        SharedConstants.useChoiceTypeRegistrations = false;
        BERRY_BIRD = RegistryHelper.registerEntityType("", () -> EntityType.Builder.create(BerryBirdEntity::new, SpawnGroup.CREATURE).setDimensions(0.9F, 1.4F).maxTrackingRange(10).build(BerryBird.makeStringID("moobloom")));
        SharedConstants.useChoiceTypeRegistrations = previousUseChoiceTypeRegistrations;
    }

    public static void init() {
        createMobAttributes();
    }

    public static void postInit() {
        addSpawns();
    }

    public static void createMobAttributes() {
        RegistryHelper.registerEntityAttribute(BerryBirdEntityTypes.BERRY_BIRD, BerryBirdEntity::createLivingAttributes);
    }

    public static void addSpawns() {
        BiomeModifications.addMobSpawn(BerryBirdTags.HAS_BERRY_BIRD, BERRY_BIRD.get(), CustomSpawnGroup.getBerryBirdsCategory());
    }
}
