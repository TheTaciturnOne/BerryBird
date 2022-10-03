package net.thetaciturnone.berrybird.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.thetaciturnone.berrybird.BerryBird;
import net.thetaciturnone.berrybird.entity.ModEntities;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(BerryBird.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BerryBird.LOGGER.debug("Registering mod items for " + BerryBird.MOD_ID);
    }

    public static final Item BERRY_BIRD_SPAWN_EGG = registerItem("berry_bird_spawn_egg",
            new SpawnEggItem(ModEntities.BERRY_BIRD, 0x386631, 0xEfff12,
                    new FabricItemSettings().group(ItemGroup.MISC)));
}
