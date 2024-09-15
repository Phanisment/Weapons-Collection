package phanisment.collection.client;

import phanisment.collection.client.renderer.EntityRenderers;
import net.fabricmc.api.ClientModInitializer;

public class Weapons implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModEntityRenderers.registerEntityRenderers();
	}
}
