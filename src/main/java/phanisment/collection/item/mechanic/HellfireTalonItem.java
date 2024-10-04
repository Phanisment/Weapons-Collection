package phanisment.collection.item.mechanic;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;

import phanisment.collection.entity.FlameSlashEntity;
import phanisment.collection.entity.RegisterEntities;
import phanisment.collection.util.SkillMechanic;

public class HellfireTalonItem extends SwordItem {
	public HellfireTalonItem() {
		super(ToolMaterials.NETHERITE, 12, -2.4F, new Settings().maxCount(1).rarity(Rarity.EPIC));
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		SkillManager.leapPlayer(player, 2, 6);
		return ActionResult.PASS;
	}
}