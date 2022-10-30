package net.foowrot.copperrevolution.entity.client.render;

import java.util.ArrayList;
import java.util.HashMap;

import net.foowrot.copperrevolution.entity.custom.PhysicsBlockEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class PhysicsBlockEntityModel extends EntityModel<PhysicsBlockEntity> {
    private final ModelPart modelPart;
    public PhysicsBlockEntityModel(int x, int y, int z) {
        var cuboidData = ModelPartBuilder.create().cuboid(0, 0, 0, x, y, z).build();
        var cuboids = new ArrayList<ModelPart.Cuboid>();

        for (var data : cuboidData) {
            cuboids.add(data.createCuboid(32, 32));
        }

        modelPart = new ModelPart(cuboids, new HashMap<>());
    }


    public void setupAnim(PhysicsBlockEntity entity, float f, float g, float h, float i, float j) {

    }

    @Override
    public void render(MatrixStack poseStack, VertexConsumer vertexConsumer, int i, int j, float f, float g, float h, float k) {
        modelPart.render(poseStack, vertexConsumer, i, j, f, g, h, k);
    }

    @Override
    public void setAngles(PhysicsBlockEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}
