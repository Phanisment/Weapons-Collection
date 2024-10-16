package phanisment.collection.common.item.mechanic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import phanisment.collection.core.skill.BlazeLeap;

public class HellfireTalonItem extends SwordItem {

	
	public HellfireTalonItem() {
		super(ToolMaterials.NETHERITE, 12, -2.4F, new Settings().maxCount(1).rarity(Rarity.EPIC));
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack item = player.getStackInHand(hand);
		if (!world.isClient) {
			BlazeLeap.run(world, player);
		}
		return TypedActionResult.success(item);
	}
}