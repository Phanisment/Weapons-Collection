package phanisment.collection;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import phanisment.collection.entity.SlashEntity;

public class Weapons implements ModInitializer {
	public static final String MOD_ID = "phanisments-weapons-collection";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<DecorativeEntity> SLASH_ENTITY = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier("phanisment", "slash_entity"),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, SlashEntity::new)
					.dimensions(EntityDimensions.fixed(0.5f, 0.5f))
					.trackRangeBlocks(80)
					.trackedUpdateRate(3)
					.build()

	@Override
	public void onInitialize() {
		LOGGER.info("7 Sin's will comes"); // Story of the Weapons
		
	}
}