package phanisment.collection.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;


import phanisment.collection.client.render.SlashRender;
import phanisment.collection.client.model.SlashModel;
import phanisment.collection.entity.SlashEntity;
import phanisment.collection.Weapons;

public class WeaponsClient implements ClientModInitializer {
	public static final EntityModelLayer SLASH_LAYER = new EntityModelLayer(new Identifier(Weapons.MOD_ID, "slash"), "main");

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(Weapons.SLASH, (context) -> {
			return new SlashRender(context);
		});
	}
}
