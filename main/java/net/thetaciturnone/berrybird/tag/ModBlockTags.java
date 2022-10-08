package net.thetaciturnone.berrybird.tag;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockTags {
    public static final TagKey<Block> BERRY_BIRDS_SPAWNABLE_ON = of("berry_birds_spawnable_on");

    private ModBlockTags() {
    }

    private static TagKey<Block> of(String id) {
        return TagKey.of(Registry.BLOCK_KEY, new Identifier(id));
    }
}
