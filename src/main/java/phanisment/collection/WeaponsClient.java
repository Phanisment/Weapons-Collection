package phanisment.collection;

import net.fabricmc.api.ClientModInitializer;

import phanisment.collection.common.registry.*;

public class WeaponsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		RegisterEntities.registerRender();
	}
}
