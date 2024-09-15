package phanisment.collection.registry;

import phanisment.collection.entity.SlashEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Entities {
	public static final EntityType<SlashEntity> SLASH_ENTITY_TYPE = Registry.register(
		Registries.ENTITY_TYPE,
		new Identifier("modid", "slash"),
		FabricEntityTypeBuilder.create(SpawnGroup.MISC, SlashEntity::new)
			.dimensions(EntityDimensions.fixed(1.0f, 1.0f))
			.trackRangeBlocks(64).build()
	);
}
