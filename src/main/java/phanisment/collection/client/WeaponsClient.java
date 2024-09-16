package phanisment.collection.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import phanisment.collection.client.model.ModelLayer;
import phanisment.collection.client.model.SlashModel;
import phanisment.collection.client.render.SlashRender;
import phanisment.collection.entity.Entities;

public class WeaponsClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(Entities.SLASH, SlashRender::new);
		EntityModelLayerRegistry.registerModelLayer(ModelLayer.SLASH_LAYER, SlashModel::getTexturedModelData);
	}
}
