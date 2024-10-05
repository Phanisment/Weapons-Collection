package phanisment.collection.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import phanisment.collection.entity.*;
import phanisment.collection.Weapons;

public class RegisterEntities {
	public static final EntityType<FlameSlashEntity> FLAME_SLASH = Registry.register(Registries.ENTITY_TYPE,
		new Identifier(Weapons.MOD_ID, "flame_slash"),
		FabricEntityTypeBuilder.create(SpawnGroup.MISC, FlameSlashEntity::new).dimensions(EntityDimensions.fixed(0.1f, 0.1f)).build()
	);
	public static final EntityType<BlazeLeapEntity> BLAZE_LEAP = Registry.register(Registries.ENTITY_TYPE,
		new Identifier(Weapons.MOD_ID, "blaze_leap"),
		FabricEntityTypeBuilder.create(SpawnGroup.MISC, BlazeLeapEntity::new).dimensions(EntityDimensions.fixed(0.1f, 0.1f)).build()
	);
}