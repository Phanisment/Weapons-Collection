package phanisment.collection.lib;
/*
import java.util.HashMap;
import java.util.Map;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class TempVar<K, V> {
	private static final Map<K, TempVar<?, ?>> activeVars = new HashMap<>();
	private static Map<K, V> data = new HashMap<>();
	private int tick;
	private final int maxTick;
	private final Runnable actionTick;
	private final Runnable actionEnd;
	private final K key;
	private final V value;

	public TempVar(K key, V value, int maxTick, Runnable actionTick, Runnable actionEnd) {
		this.key = key;
		this.value = value;
		this.tick = 0;
		this.maxTick = maxTick;
		this.actionTick = actionTick;
		this.actionEnd = actionEnd;
		activeVars.put(key, this);
		data.put(key, value);
	}
	
	public TempVar(K key, V value, int maxTick) {
		this(key, value, maxTick, () -> {}, () -> {});
	}

	public static <K, V> void create(K key, V value, int maxTick, Runnable actionTick, Runnable actionEnd) {
		new TempVar<>(key, value, maxTick, actionTick, actionEnd);
	}
	
	public static <K, V> void create(K key, V value, int maxTick) {
		new TempVar<>(key, value, maxTick);
	}

	public static void register() {
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			for (K key : new HashMap<>(activeVars.keySet())) {
				TempVar<?, ?> tempVar = activeVars.get(key);
				if (tempVar != null) tempVar.tick();
			}
		});
	}

	private void tick() {
		if (tick >= maxTick) {
			actionEnd.run();
			activeVars.remove(key);
			data.remove(key);
		} else {
			actionTick.run();
			tick++;
		}
	}

	public static <K, V> V get(K key) {
		return (V) data.get(key);
	}
}
*/