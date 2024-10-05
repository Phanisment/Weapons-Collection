package phanisment.collection.item.mechanic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import phanisment.collection.util.mechanic.SkillMechanic;

public class HellfireTalonItem extends SwordItem {
	public HellfireTalonItem() {
		super(ToolMaterials.NETHERITE, 12, -2.4F, new Settings().maxCount(1).rarity(Rarity.EPIC));
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack item = player.getStackInHand(hand);
		if (!world.isClient) {
			HellfireLeapSkill(world, player)
		}
		return TypedActionResult.success(item);
	}
	
	private void HellfireLeapSkill(World world, PlayerEntity player) {
		if (player.isSneaking() && player.isOnGround()) {
			SkillMechanic.leapPlayer(player, 0.5, 2);
		}
	}
}