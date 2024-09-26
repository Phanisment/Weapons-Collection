package phanisment.collection;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import phanisment.collection.client.RegisterModelLayers;
import phanisment.collection.entity.RegisterEntities;
import phanisment.collection.entity.TesEntity;
import phanisment.collection.client.render.TesRender;
import phanisment.collection.client.model.TesModel;

public class WeaponsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(RegisterEntities.TES, TesRender::new);
		EntityModelLayerRegistry.registerModelLayer(RegisterModelLayers.TES, TesModel::getTexturedModelData);
	}
}
