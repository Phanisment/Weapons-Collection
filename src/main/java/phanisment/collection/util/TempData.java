package panisment.collection.

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class TempVariableUtil<K, V> {
	private final HashMap<K, V> tempMap = new HashMap<>();
	private final Timer timer = new Timer();

	public void addTempVariable(K key, V value, long expireTimeMillis) {
		tempMap.put(key, value);

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				tempMap.remove(key);
			}
		}, expireTimeMillis);
	}

	public V getTempVariable(K key) {
		return tempMap.get(key);
	}

	public void removeTempVariable(K key) {
		tempMap.remove(key);
	}

	public boolean containsKey(K key) {
		return tempMap.containsKey(key);
	}

	public void clearAll() {
		tempMap.clear();
		timer.cancel();
	}
}
