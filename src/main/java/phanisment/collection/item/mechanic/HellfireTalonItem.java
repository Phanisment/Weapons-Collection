package phanisment.collection.item.mechanic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import phanisment.collection.entity.FlameSlashEntity;
import phanisment.collection.entity.RegisterEntities;

public class HellfireTalonItem extends Item {
	public HellfireTalonItem(Settings settings) {
		super(settings);
	}
	
	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.damage(1, attacker, (p) -> p.sendToolBreakStatus(Hand.MAIN_HAND));
		if (attacker instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) attacker;
			spawnSlash(player.getWorld(), player);
		}
		return true;
	}
	
		private void spawnSlash(World world, PlayerEntity player) {
		if (!world.isClient) {
			Vec3d lookVec = player.getRotationVector();
			double x = player.getX() + lookVec.x * 0.5;
			double y = player.getY() + lookVec.y * 0.5 + 1.5;
			double z = player.getZ() + lookVec.z * 0.5;
			FlameSlashEntity slashEntity = new FlameSlashEntity(RegisterEntities.FLAME_SLASH, world);
			slashEntity.setPos(x, y, z);
			slashEntity.setYaw(player.getYaw());
			world.spawnEntity(slashEntity);
		}
	}
}