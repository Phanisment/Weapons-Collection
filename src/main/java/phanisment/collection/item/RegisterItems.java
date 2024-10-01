package phanisment.collection.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import phanisment.collection.Weapons;
import phanisment.collection.item.mechanic.*;

public class RegisterItems {
	public static final Item HELLFIRE_TALON = registerItem("hellfire_talon", new HellfireTalonItem());
	public static final Item FROSTFANG_SPEAR = registerItem("frostfang_spear", new FrostfangSpearItem());
	public static final Item CRIMSON_SOVEREIGN = registerItem("crimson_sovereign", new CrimsonSovereignItem());

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(Weapons.MOD_ID, name), item);
	}
	
	public static void register() {
	}
}