package phanisment.collection.client;

import net.fabricmc.api.ClientModInitializer;

import phanisment.collection.client.model.SlashModel;
import phanisment.collection.entity.SlashEntity;
import phanisment.collection.Weapons;

public class Weapons implements ClientModInitializer {
	public static final Identifier SLASH_MODEL_LAYER = new Identifier("phanisment", "slash_model_layer");

	@Override
	public void onInitializeClient() {
	}
}
