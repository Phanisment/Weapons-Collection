package phanisment.collection.core;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;

import java.util.HashSet;
import java.util.Set;

public class Delay {
	private static final Set<Delay> activeDelays = new HashSet<>();
	private int delayTicks;
	private final int maxDelay;
	private final Runnable skillAction;

	public Delay(int maxDelay, Runnable skillAction) {
		this.delayTicks = 0;
		this.maxDelay = maxDelay;
		this.skillAction = skillAction;
		activeDelays.add(this);
	}

	public static void run(int ticks, Runnable skillAction) {
		new Delay(ticks, skillAction);
	}

	public static void register() {
		ServerTickEvents.END_SERVER_TICK.register(context -> {
			for (Delay delay : new HashSet<>(activeDelays)) {
				if (delayTicks >= maxDelay) {
					skillAction.run();
					activeDelays.remove(this);
				} else {
					delayTicks++;
				}
			}
		});
	}
}