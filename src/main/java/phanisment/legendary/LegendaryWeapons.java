package phanisment.legendary;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LegendaryWeapons implements ModInitializer {
	public static final String MOD_ID = "legendary-weapons";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("This world, will by MINE.");
	}
}