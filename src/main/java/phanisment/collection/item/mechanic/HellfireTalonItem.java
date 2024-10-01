package phanisment.collection.item.mechanic;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Rarity;

public class HellfireTalonItem extends SwordItem {
	public HellfireTalonItem() {
		super(ToolMaterials.NETHERITE, 12, -2.4F, new Settings().maxCount(1).rarity(Rarity.EPIC));
	}
}