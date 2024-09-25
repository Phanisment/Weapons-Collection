package phanisment.collection;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import phanisment.collection.entity.TesEntity;

public class Weapons implements ModInitializer {
	public static final String MOD_ID = "phanisment";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<TesEntity> TES = Registry.register(Registries.ENTITY_TYPE, new Identifier(MOD_ID, "tes"),
		FabricEntityTypeBuilder.create(SpawnGroup.MISC, TesEntity::new)
			.dimensions(EntityDimensions.fixed(1f, 1f)).build()
	);

	@Override
	public void onInitialize() {
		LOGGER.info("7 Sin's will come!");
		
		FabricDefaultAttributeRegistry.register(TES, TesEntity.createMobAttributes());
	}
}
