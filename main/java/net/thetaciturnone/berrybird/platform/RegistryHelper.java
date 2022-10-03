package net.thetaciturnone.berrybird.platform;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.structure.processor.StructureProcessor;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.function.Supplier;

public final class RegistryHelper
{
    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        throw new AssertionError();
    }

    public static void registerEntityModelLayer(EntityModelLayer location, Supplier<TexturedModelData> definition) {
        throw new AssertionError();
    }

    public static <T extends Entity> void registerEntityRenderer(
            Supplier<EntityType<T>> type,
            EntityRendererFactory<T> renderProvider
    ) {
        throw new AssertionError();
    }

    public static <T extends Entity> Supplier<EntityType<T>> registerEntityType(
            String name,
            Supplier<EntityType<T>> entityType
    ) {
        throw new AssertionError();
    }

    public static void registerEntityAttribute(
            Supplier<? extends EntityType<? extends LivingEntity>> type,
            Supplier<DefaultAttributeContainer.Builder> attribute
    ) {
        throw new AssertionError();
    }


    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        throw new AssertionError();
    }

    public static <T extends PointOfInterestType> Supplier<T> registerPointOfInterestType(
            String name,
            Supplier<T> pointOfInterestType
    ) {
        throw new AssertionError();
    }


    public static void registerRenderType(RenderLayer type, Block... blocks) {
        throw new AssertionError();
    }

    public static <T extends SoundEvent> Supplier<T> registerSoundEvent(String name, Supplier<T> soundEvent) {
        throw new AssertionError();
    }

    public static <T extends VillagerProfession> Supplier<T> registerVillagerProfession(
            String name,
            Supplier<T> villagerProfession
    ) {
        throw new AssertionError();
    }

    public static <T extends Block> void registerFlammableBlock(Supplier<T> block, int burnChance, int spreadChance) {
        registerFlammableBlock(Blocks.FIRE, block, burnChance, spreadChance);
    }

    public static <T extends Block> void registerFlammableBlock(
            Block fireBlock,
            Supplier<T> block,
            int burnChance,
            int spreadChance
    ) {
        throw new AssertionError();
    }

    public static void registerStructureProcessorType(
            Identifier identifier,
            StructureProcessorType<? extends StructureProcessor> structureProcessorType
    ) {
        throw new AssertionError();
    }
}
