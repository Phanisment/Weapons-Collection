package phanisment.collection.common.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import phanisment.collection.Weapons;
import phanisment.collection.common.registry.RegisterItems;

public class ItemsGroup {
	public static final ItemGroup WEAPONS_GROUP = Registry.register(Registries.ITEM_GROUP,
		new Identifier(Weapons.MOD_ID, "weapons"), 
		FabricItemGroup.builder().displayName(Text.translatable("itemgroup.phanisment.weapons")).icon(() -> new ItemStack(RegisterItems.HELLFIRE_TALON)).entries((displayContext, item) -> {
			item.add(RegisterItems.HELLFIRE_TALON);
		}).build()
	);
}