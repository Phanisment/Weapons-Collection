package phanisment.collection.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

import phanisment.collection.client.model.SlashModel;
import phanisment.collection.entity.SlashEntity;
import phanisment.collection.Weapons;

public class Weapons implements ClientModInitializer {
	public static final Identifier SLASH_MODEL_LAYER = new Identifier("phanisment", "slash_model_layer");

	@Override
	public void onInitializeClient() {
		EntityModelLayerRegistry.registerModelLayer(SLASH_MODEL_LAYER, SlashModel::getTexturedModelData);
		EntityRendererRegistry.register(Weapons.SLASH_MODEL, (context) -> {
			return new MobEntityRenderer<>(context, new SlashModel(context.getPart(SLASH_MODEL_LAYER)), 0.5f) {
				@Override
				public Identifier getTexture(SlashEntity entity) {
					return new Identifier("phanisment", "textures/vfx/slash.png");
				}
			};
		});
	}
}
