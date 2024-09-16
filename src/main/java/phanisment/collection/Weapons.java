package phanisment.collection;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.Builder;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import phanisment.collection.entity.SlashEntity;

public class Weapons implements ModInitializer {
	public static final String MOD_ID = "phanisments-weapons-collection";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<SlashEntity> SLASH = Registry.register(
		Registries.ENTITY_TYPE,
		Identifier.of("phanisment", "slash"),
		EntityType.Builder.create(SlashEntity::new, SpawnGroup.MISC).dimensions(0.5f, 0.5f).build("slash")
	);

	@Override
	public void onInitialize() {
		LOGGER.info("7 Sin's will comes"); // Story of the Weapons
		
	}
}