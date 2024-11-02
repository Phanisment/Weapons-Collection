package phanisment.collection.lib;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;

import java.util.HashSet;
import java.util.Set;

/* 
 * This class provides a utility for scheduling delayed actions in the Minecraft server environment.
 * It utilizes server ticks to manage the delays and ensures proper execution after the specified time.
 */
public class Delay {

	/* 
	 * A static Set of type Delay is used to store all currently active delays. This allows for
	 * efficient tracking and processing of delays during server ticks.
	 */
	private static final Set<Delay> activeDelays = new HashSet<>();

	/* 
	 * The current number of ticks elapsed for this specific delay.
	 */
	private int delayTicks;

	/*
	 * The maximum number of ticks this delay should last before executing the action.
	 */
	private final int maxDelay;

	/* 
	 * The Runnable object containing the action to be executed after the delay.
	 */
	private final Runnable action;

	/* 
	 * Constructor to create a new Delay object.
	 * 
	 * @param maxDelay The number of ticks to wait before executing the action.
	 * @param action   The Runnable object containing the action to be performed.
	 */
	public Delay(int maxDelay, Runnable action) {
		this.delayTicks = 0;
		this.maxDelay = maxDelay;
		this.action = action;
		activeDelays.add(this); // Add this instance to the set of active delays
	}

	/* 
	 * Static method to create and schedule a new Delay object with the specified parameters.
	 *
	 * @param ticks  The number of ticks to wait before executing the action.
	 * @param action The Runnable object containing the action to be performed.
	 */
	public static void run(int ticks, Runnable action) {
		new Delay(ticks, action);
	}

	/* 
	 * Registers a server tick event listener to handle all active delays. This method gets
	 * called at the end of each server tick and iterates through all active delays.
	 * It checks if the delay has reached its maximum duration and executes the associated action
	 * if so. Delays that haven't reached their duration are incremented by one tick.
	 */
	public static void register() {
		ServerTickEvents.END_SERVER_TICK.register(context -> {
			// Create a copy of the active delays to avoid ConcurrentModificationException
			for (Delay delay : new HashSet<>(activeDelays)) {
				if (delay.delayTicks >= delay.maxDelay) {
					delay.action.run();
					activeDelays.remove(delay); // Remove the completed delay
				} else {
					delay.delayTicks++;         // Increment the tick counter for ongoing delays
				}
			}
		});
	}
}