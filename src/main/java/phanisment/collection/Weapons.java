package phanisment.collection;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import phanisment.collection.entity.RegisterEntities;
import phanisment.collection.entity.FlameSlashEntity;

public class Weapons implements ModInitializer {
	public static final String MOD_ID = "phanisment";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		RegisterItems.register();
		
		FabricDefaultAttributeRegistry.register(RegisterEntities.FLAME_SLASH, FlameSlashEntity.createAttributes());
	}
}