package phanisment.collection.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;

import phanisment.collection.Weapons;

public class WeaponsClient implements ClientModInitializer {
	public static final EntityModelLayer SLASH_MODEL_LAYER = new EntityModelLayer(new Identifier(Weapons.MOD_ID, "slash"), "main");
	
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(Weapons.TES, TesRender::new);
		EntityModelLayerRegistry.registerModelLayer(SLASH_MODEL_LAYER, TesModel::getTexturedModelData);
	}
}