package net.thetaciturnone.berrybird.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableShoulderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.thetaciturnone.berrybird.tag.BerryBirdTags;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;


public class BerryBirdEntity extends TameableShoulderEntity implements IAnimatable {
    public BerryBirdEntity(EntityType<? extends TameableShoulderEntity> entityType, World world) {
        super(entityType, world);
    }
    private AnimationFactory factory = new AnimationFactory(this);

    public static DefaultAttributeContainer.Builder setAttributes() {
        return TameableShoulderEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2D)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.8);
    }

    public static void canMobSpawn() {
    }

    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
    }

    public static boolean canSpawn(EntityType<ParrotEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isIn(BlockTags.PARROTS_SPAWNABLE_ON) && isLightLevelValidForNaturalSpawn(world, pos);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(0, new SitOnOwnerShoulderGoal(this));
        this.goalSelector.add(0, new SitGoal(this));
        this.goalSelector.add(0, new WanderAroundPointOfInterestGoal(this, 0.75f, false));
        this.goalSelector.add(0, new LookAroundGoal(this));
        this.goalSelector.add(0, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.model.fly", true));
            return PlayState.CONTINUE;
        }
        event.getController();
        return PlayState.CONTINUE;
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        Item item = itemstack.getItem();

        Item itemForTaming = Items.GLOW_BERRIES;

        if (item == itemForTaming && !isTamed()) {
            if (this.world.isClient()) {
                return ActionResult.CONSUME;
            } else {
                if (!player.getAbilities().creativeMode) {
                    itemstack.decrement(1);
                }

                if (!this.world.isClient()) {
                    super.setOwner(player);
                    this.navigation.recalculatePath();
                    this.setTarget(null);
                    this.world.sendEntityStatus(this, (byte)7);
                }

                return ActionResult.SUCCESS;
            }
        }

        if (itemstack.getItem() == itemForTaming) {
            return ActionResult.PASS;
        }

        return super.interactMob(player, hand);
    }

    public static boolean canSpawn(
            EntityType<BerryBirdEntity> berryBirdEntityEntityType,
            ServerWorldAccess serverWorldAccess,
            SpawnReason spawnReason,
            BlockPos blockPos,
            Random random
    ) {
        BlockState blockState = serverWorldAccess.getBlockState(blockPos.down());

        boolean isBelowSurfaceLevel = blockPos.getY() < 63;
        boolean isSkyHidden = !serverWorldAccess.isSkyVisible(blockPos);
        boolean isBlockPosLightEnough = serverWorldAccess.getBaseLightLevel(blockPos, 0) > 3;
        boolean isRelatedBlock = blockState.isIn(BerryBirdTags.BERRY_BIRD_SPAWNABLE_ON);

        return isBelowSurfaceLevel
                && isRelatedBlock
                && isSkyHidden
                && isBlockPosLightEnough;
    }

    public boolean isInAir() {
        return false;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    private static SoundEvent getSound(EntityType<?> imitate) {
        return (SoundEvents.ENTITY_PARROT_AMBIENT);
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PARROT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PARROT_DEATH;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_PARROT_STEP, 0.15F, 1.0F);
    }

}
