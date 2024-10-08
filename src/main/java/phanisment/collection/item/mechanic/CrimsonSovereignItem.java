package phanisment.collection.item.mechanic;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;

public class CrimsonSovereignItem extends SwordItem {
	public CrimsonSovereignItem() {
		super(ToolMaterials.NETHERITE, 12, -2.4F, new Settings().maxCount(1));
	}
}