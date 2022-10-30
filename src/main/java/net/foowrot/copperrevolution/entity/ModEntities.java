package net.foowrot.copperrevolution.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.foowrot.copperrevolution.CopperRevolution;
import net.foowrot.copperrevolution.entity.custom.PhysicsBlockEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities
{
    public static final EntityType<PhysicsBlockEntity> PHYSICS_BLOCK_ENTITY = Registry.register(
    Registry.ENTITY_TYPE,
        new Identifier(CopperRevolution.MOD_ID, "physics_block_entity"),
                FabricEntityTypeBuilder.createLiving()
                        .entityFactory(PhysicsBlockEntity::new)
                        .spawnGroup(SpawnGroup.MISC)
                        .defaultAttributes(LivingEntity::createLivingAttributes)
                        .dimensions(EntityDimensions.fixed(1.0f, 1.0f))
        .trackRangeBlocks(80)
                        .build()
        );
}
