package net.foowrot.copperrevolution;

import dev.lazurite.rayon.impl.dev.RayonDev;
import dev.lazurite.rayon.impl.dev.client.render.StoneBlockEntityModel;
import dev.lazurite.rayon.impl.dev.client.render.StoneBlockEntityRenderer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.foowrot.copperrevolution.block.ModBlocks;
import net.foowrot.copperrevolution.entity.ModEntities;
import net.foowrot.copperrevolution.entity.client.render.PhysicsBlockEntityModel;
import net.foowrot.copperrevolution.entity.client.render.PhysicsBlockEntityRenderer;
import net.foowrot.copperrevolution.entity.custom.PhysicsBlockEntity;
import net.foowrot.copperrevolution.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopperRevolution implements ModInitializer {

	public static final String MOD_ID = "copperrevolution";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();


		EntityRendererRegistry.register(ModEntities.PHYSICS_BLOCK_ENTITY, (context) -> {
			return new PhysicsBlockEntityRenderer(context, new PhysicsBlockEntityModel(15, 15, 15));
		});

		//EntityRendererRegistry.register(ModEntities.PHYSICS_BLOCK_ENTITY, (context) ->
		//		new PhysicsBlockEntityRenderer(context, new PhysicsBlockEntityModel(15, 15, 15)));

		FabricDefaultAttributeRegistry.register(ModEntities.PHYSICS_BLOCK_ENTITY, PhysicsBlockEntity.createLivingAttributes());

	}
}
