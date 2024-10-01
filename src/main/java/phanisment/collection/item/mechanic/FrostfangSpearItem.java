package phanisment.collection.item.mechanic;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Rarity;

public class FrostfangSpearItem extends SwordItem {
	public FrostfangSpearItem() {
		super(ToolMaterials.NETHERITE, 12, -2.4F, new Settings().maxCount(1).rarity(Rarity.EPIC));
	}
}