package phanisment.collection;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import phanisment.collection.common.event.ClickEvent;
import phanisment.collection.client.RegisterModelLayers;
import phanisment.collection.entity.RegisterEntities;
import phanisment.collection.entity.FlameSlashEntity;
import phanisment.collection.client.render.FlameSlashRender;
import phanisment.collection.client.model.FlameSlashModel;

public class WeaponsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(RegisterEntities.FLAME_SLASH, FlameSlashRender::new);
		EntityModelLayerRegistry.registerModelLayer(RegisterModelLayers.FLAME_SLASH, FlameSlashModel::getTexturedModelData);
	}
}
