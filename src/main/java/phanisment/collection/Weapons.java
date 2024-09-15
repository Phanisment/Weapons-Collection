package phanisment.collection;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import phanisment.collection.entity.SlashVFXEntity;
import phanisment.collection.client.renderer.SlashVFXEntityRenderer;

public class Weapons implements ModInitializer {
	public static final String MOD_ID = "phanisments-weapons-collection";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<SlashVFXEntity> SLASH_VFX_ENTITY = Registry.register(
		Registry.ENTITY_TYPE,
		new Identifier("phanisment", "slash_vfx"),
		FabricEntityTypeBuilder.create(SpawnGroup.MISC, SlashVFXEntity::new)
			.dimensions(EntityDimensions.fixed(1.0f, 1.0f))
			.build()
	);

	@Override
	public void onInitialize() {
		LOGGER.info("7 Sin's will comes"); // Story of the Weapons
		
		EntityRendererRegistry.register(SLASH_VFX_ENTITY, SlashVFXEntityRenderer::new);
	}
}