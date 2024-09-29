package phanisment.collection.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_4048;
import net.minecraft.class_7923;
import phanisment.collection.entity.FlameSlashEntity;
import phanisment.collection.Weapons;

public class RegisterEntities {
	public static final class_1299<FlameSlashEntity> FLAME_SLASH = class_2378.method_10230(class_7923.field_41177,
		new class_2960(Weapons.MOD_ID, "flame_slash"),
		FabricEntityTypeBuilder.create(class_1311.field_17715, FlameSlashEntity::new).dimensions(class_4048.method_18385(5.5f, 0.1f)).build()
	);
}