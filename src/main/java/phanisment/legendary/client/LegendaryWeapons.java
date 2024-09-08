package phanisment.legendary.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import phanisment.legendary.vfx.render.AnimatedSlashRenderer;
import phanisment.legendary.vfx.AnimatedSlashEntity;

public class LegendaryWeapons implements ClientModInitializer {
	public static final EntityType<AnimatedSlashEntity> ANIMATED_SLASH_ENTITY = Registry.register(
	Registry.ENTITY_TYPE,
	new Identifier("legendary_weapons", "slash"),
	EntityType.Builder.create(AnimatedSlashEntity::new, SpawnGroup.MISC)
		.setDimensions(0.5F, 0.5F)
		.build()
	);
	
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ANIMATED_SLASH_ENTITY, AnimatedSlashRenderer::new);
	}
}