package phanisment.collection.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import phanisment.collection.entity.TesEntity;
import phanisment.collection.Weapons

public class RegisterEntities {
	public static final EntityType<TesEntity> TES = Registry.register(Registries.ENTITY_TYPE,
		new Identifier(Weapons.MOD_ID, "tes"),
		FabricEntityTypeBuilder.create(SpawnGroup.MISC, TesEntity::new).dimensions(EntityDimensions.fixed(1f, 1f)).build()
	);

	public static void registerModEntities() {
		Weapons.LOGGER.info("Registering Entities for " + Weapons.MOD_ID);
	}
}