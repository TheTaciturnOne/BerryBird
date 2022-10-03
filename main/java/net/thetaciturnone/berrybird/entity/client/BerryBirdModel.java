package net.thetaciturnone.berrybird.entity.client;

import net.minecraft.util.Identifier;
import net.thetaciturnone.berrybird.BerryBird;
import net.thetaciturnone.berrybird.entity.custom.BerryBirdEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BerryBirdModel extends AnimatedGeoModel<BerryBirdEntity> {
    @Override
    public Identifier getModelResource(BerryBirdEntity object) {
        return new Identifier(BerryBird.MOD_ID, "geo/berry_bird.geo.json");
    }

    @Override
    public Identifier getTextureResource(BerryBirdEntity instance) {
        return new Identifier(BerryBird.MOD_ID, "textures/entity/berry_bird.png");
    }

    @Override
    public Identifier getAnimationResource(BerryBirdEntity instance) {
        return new Identifier(BerryBird.MOD_ID, "animations/berry_bird.animation.json");
    }

}
