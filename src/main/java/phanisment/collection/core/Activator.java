package phanisment.collection.core;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

public class Activator {
	public class run(MinecraftClient client) {
		if (client.mouse.wasLeftButtonClicked()) {
			ClientPlayerEntity player = client.player;
			if (player != null && !client.world.isClient) {
				
			}
		}
	}
}