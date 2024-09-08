package phanisment.legendary;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import phanisment.legendary.vfx.AnimatedSlashEntity:

public class LegendaryWeapons implements ModInitializer {
	public static final String MOD_ID = "legendary_weapons";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Item VFX_ITEM = new Item(new Item.Settings().maxCount(1));
	
	@Override
	public void onInitialize() {
		LOGGER.info("This world, will by MINE.");
		
		Registry.register(Registry.ITEM, new Identifier("legendary_weapons", "slash"), VFX_ITEM);
	}
}