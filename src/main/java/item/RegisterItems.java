package phanisment.collection.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.class_1792;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_7923;
import phanisment.collection.Weapons;

public class RegisterItems {
	public static final class_1792 HELLFIRE_TALON = registerItem("hellfire_talon", new class_1792(new FabricItemSettings()));

	private static class_1792 registerItem(String name, class_1792 item) {
		return class_2378.method_10230(class_7923.field_41178, new class_2960(Weapons.MOD_ID, name), item);
	}
}