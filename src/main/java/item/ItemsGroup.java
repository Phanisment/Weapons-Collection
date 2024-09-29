package phanisment.collection.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.class_1761;
import net.minecraft.class_1799;
import net.minecraft.class_2378;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_7923;
import phanisment.collection.Weapons;
import phanisment.collection.item.RegisterItems;

public class ItemsGroup {
	public static final class_1761 WEAPONS_GROUP = class_2378.method_10230(class_7923.field_44687,
		new class_2960(Weapons.MOD_ID, "weapons"), 
		FabricItemGroup.builder().method_47321(class_2561.method_43471("itemgroup.phanisment.weapons")).method_47320(() -> new class_1799(RegisterItems.HELLFIRE_TALON)).method_47317((displayContext, item) -> {
			item.method_45421(RegisterItems.HELLFIRE_TALON);
		}).method_47324()
	);
}