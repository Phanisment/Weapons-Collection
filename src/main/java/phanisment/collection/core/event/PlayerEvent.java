package phanisment.collection.core.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import phanisment.collection.core.CooldownManager;

public class PlayerEvent {
	public PlayerEvent() {
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			server.getPlayerManager().getPlayerList().forEach(CooldownManager::tick);
		});
	}
}