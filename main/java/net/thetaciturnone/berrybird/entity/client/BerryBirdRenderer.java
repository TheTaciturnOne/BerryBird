package net.thetaciturnone.berrybird.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.thetaciturnone.berrybird.BerryBird;
import net.thetaciturnone.berrybird.entity.custom.BerryBirdEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BerryBirdRenderer extends GeoEntityRenderer<BerryBirdEntity> {
    public BerryBirdRenderer(EntityRendererFactory.Context cxt) {
        super(cxt, new BerryBirdModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(BerryBirdEntity instance) {
        return new Identifier(BerryBird.MOD_ID, "textures/entity/berry_bird.png");
    }

    public RenderLayer getRenderType(BerryBirdEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.8f, 0.8f, 0.8f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
