package phanisment.collection.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import phanisment.collection.entity.TesEntity;
import phanisment.collection.Weapons;

public class EntityRegister {
	public static final EntityType<SlashEntity> SLASH_ENTITY = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier(Weapons.MOD_ID, "tes"),
		FabricEntityTypeBuilder.create(SpawnGroup.MISC, SlashEntity::new)
			.dimensions(EntityDimensions.fixed(1.0f, 1.0f))
			.trackRangeBlocks(80)
			.trackedUpdateRate(3)
			.build()
	);

	public static void registerEntities() {
	}
}
