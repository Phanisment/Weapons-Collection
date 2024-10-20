package phanisment.collection;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import phanisment.collection.common.registry.*;
import phanisment.collection.core.Activator;

public class WeaponsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		RegisterEntities.registerRender();
		
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.world != null && !client.isPaused()) {
				Activator.run(client);
			}
		});
	}
}
