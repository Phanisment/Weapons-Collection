package phanisment.collection.common.item.mechanic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import phanisment.collection.util.TempVariableUtil;
import phanisment.collection.util.mechanic.SkillMechanic;
import phanisment.collection.common.entity.BlazeLeapEntity;
import phanisment.collection.common.entity.RegisterEntities;

import java.util.UUID;

public class HellfireTalonItem extends SwordItem {
	private TempVariableUtil<UUID, Boolean> isLeap = new TempVariableUtil<>();
	
	public HellfireTalonItem() {
		super(ToolMaterials.NETHERITE, 12, -2.4F, new Settings().maxCount(1).rarity(Rarity.EPIC));
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack item = player.getStackInHand(hand);
		if (!world.isClient) {
			blazeLeapSkill(world, player);
		}
		return TypedActionResult.success(item);
	}
	
	private void blazeLeapSkill(World world, PlayerEntity player) {
		UUID playerId = player.getUuid(); 
		if (player.isSneaking() && player.isOnGround()) {
			BlazeLeapEntity vfx = new BlazeLeapEntity(RegisterEntities.BLAZE_LEAP, world);
			vfx. setPosition(player.getX(), player.getY() + 0.1, player.getZ());
			world.spawnEntity(vfx);
			
			SkillMechanic.leap(player, 0.2, 1.0);
			isLeap.addTempVariable(playerId, true, 1000);
		} 
		else if (!player.isSneaking() && isLeap.containsKey(playerId)) {
			SkillMechanic.jump(player, -10);
		}
	}
}