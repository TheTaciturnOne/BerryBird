package net.thetaciturnone.berrybird.tag;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.thetaciturnone.berrybird.BerryBird;

public final class BerryBirdTags
    {
        public static final TagKey<Biome> HAS_BERRY_BIRD = biomeTag("has_berry_bird");
        public static final TagKey<Block> BERRY_BIRD_SPAWNABLE_ON = blockTag("berry_bird_spawnable_on");


        private static TagKey<Biome> biomeTag(String name) {
            return TagKey.of(Registry.BIOME_KEY, BerryBird.makeID(name));
        }
        private static TagKey<Block> blockTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, BerryBird.makeID(name));
        }
    }
