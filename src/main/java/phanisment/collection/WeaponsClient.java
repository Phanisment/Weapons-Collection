package phanisment.collection;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import phanisment.collection.client.RegisterModelLayers;
import phanisment.collection.entity.RegisterEntities;
import phanisment.collection.entity.*;
import phanisment.collection.client.render.*;
import phanisment.collection.client.model.*;

public class WeaponsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Hellfire Talon | Slash
		EntityRendererRegistry.register(RegisterEntities.FLAME_SLASH, FlameSlashRender::new);
		EntityModelLayerRegistry.registerModelLayer(RegisterModelLayers.FLAME_SLASH, FlameSlashModel::getTexturedModelData);
		
		// Hellfire Talon | Blaze Leap
		EntityRendererRegistry.register(RegisterEntities.BLAZE_LEAP, BlazeLeapRender::new);
		EntityModelLayerRegistry.registerModelLayer(RegisterModelLayers.BLAZE_LEAP, BlazeLeapModel::getTexturedModelData);
	}
}
