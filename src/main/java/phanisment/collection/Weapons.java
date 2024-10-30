package phanisment.collection;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import phanisment.collection.common.registry.*;
import phanisment.collection.common.item.ItemsGroup;
import phanisment.collection.core.Delay;

public class Weapons implements ModInitializer {
	public static final String MOD_ID = "phanisment";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		new ItemsGroup();
		new RegisterItems();
		new RegisterEntities();
		
		Delay.register();
	}
}