package phanisment.collection.client.renderer;

import phanisment.collection.registry.Entities;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ModEntityRenderers {
	public static void registerEntityRenderers() {
		EntityRendererRegistry.register(Entities.SLASH_ENTITY_TYPE, SlashEntityRenderer::new);
	}
}
