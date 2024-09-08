package phanisment.legendary;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LegendaryWeapons implements ModInitializer {
	public static final String MOD_ID = "legendary_weapons";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Item VFX_ITEM = new Item(new Item.Settings().maxCount(1));
	
	@Override
	public void onInitialize() {
		LOGGER.info("This world, will by MINE.");
		
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "slash"), VFX_ITEM);
	}
}