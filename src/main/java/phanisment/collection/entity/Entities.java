package phanisment.collection.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import phanisment.collection.Weapons;
import phanisment.collection.entity.SlashEntity;

public class Entities {
	public static final EntityType<SlashEntity> SLASH = Registry.register(Registries.ENTITY_TYPE,
		new Identifier(Weapons.MOD_ID, "slash"),
		FabricEntityTypeBuilder.create(SpawnGroup.MISC, SlashEntity::new).dimensions(EntityDimensions.fixed(1f, 1f)).build()
	);
}