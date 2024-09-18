package phanisment.collection;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import phanisment.collection.event.PlayerEvent;
import phanisment.collection.util.VFXManager;

public class Weapons implements ModInitializer {
	public static final String MOD_ID = "phanisment";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		PlayerEvent.registerEvents();
		VFXManager.registerCustomModelDataUpdater();
	}
}
