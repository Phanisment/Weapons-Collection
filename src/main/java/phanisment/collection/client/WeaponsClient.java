package phanisment.collection.client;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import phanisment.collection.Weapons;
import phanisment.collection.client.model.TesModel;
import phanisment.collection.client.render.TesRender;

public class WeaponsClient implements ClientModInitializer {
	public static final EntityModelLayer SLASH_MODEL_LAYER = new EntityModelLayer(new Identifier(Weapons.MOD_ID, "slash"), "main");
	
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(Weapons.TES, TesRender::new);
		EntityModelLayerRegistry.registerModelLayer(SLASH_MODEL_LAYER, TesModel::getTexturedModelData);
	}
}