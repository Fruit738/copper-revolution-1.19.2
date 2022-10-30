package net.foowrot.copperrevolution.entity.client.render;

import com.jme3.math.Quaternion;
import net.foowrot.copperrevolution.CopperRevolution;
import net.foowrot.copperrevolution.entity.custom.PhysicsBlockEntity;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import dev.lazurite.rayon.impl.bullet.math.Convert;

public class PhysicsBlockEntityRenderer extends EntityRenderer<PhysicsBlockEntity> {
    private static final Identifier texture = new Identifier(CopperRevolution.MOD_ID, "textures/entity/physics_block.png");
    private final PhysicsBlockEntityModel model;
    public PhysicsBlockEntityRenderer(EntityRendererFactory.Context ctx, PhysicsBlockEntityModel model) {
        super(ctx);
        this.model = model;
        this.shadowRadius = 0.2F;
    }

    public void render(PhysicsBlockEntity cubeEntity, float yaw, float delta, MatrixStack matrixStack, VertexConsumerProvider multiBufferSource, int i) {
        final var rot = Convert.toMinecraft(cubeEntity.getPhysicsRotation(new Quaternion(), delta));
        final var box = cubeEntity.getBoundingBox();

        matrixStack.push();
        matrixStack.multiply(rot);
        matrixStack.translate(box.getXLength() * -0.5, box.getYLength() * -0.5, box.getZLength() * -0.5);

        final var vertexConsumer = multiBufferSource.getBuffer(model.getLayer(this.getTextureLocation(cubeEntity)));
        model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();

        super.render(cubeEntity, yaw, delta, matrixStack, multiBufferSource, i);
    }

    @Override
    public Identifier getTexture(PhysicsBlockEntity entity) {
        return null;
    }

    @Override
    public boolean shouldRender(PhysicsBlockEntity entity, Frustum frustum, double d, double e, double f) {
        return true;
    }


    public Identifier getTextureLocation(PhysicsBlockEntity entity) {
        return texture;
    }
}