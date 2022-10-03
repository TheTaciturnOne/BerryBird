package net.thetaciturnone.berrybird.platform;

import net.minecraft.entity.SpawnGroup;

public final class CustomSpawnGroup
{
    public static final String BERRY_BIRDS_INTERNAL_NAME = "BERRY_BIRDS";
    public static final String NAME = "berry_birds";
    public static final int SPAWN_CAP = 15;
    public static final boolean PEACEFUL = true;
    public static final boolean RARE = false;
    public static final int IMMEDIATE_DESPAWN_RANGE = 128;

    public static SpawnGroup getBerryBirdsCategory() {
        throw new AssertionError();
    }
}
