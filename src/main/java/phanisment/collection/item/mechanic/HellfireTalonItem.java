package phanisment.collection.item.mechanic;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;

import phanisment.collection.entity.FlameSlashEntity;
import phanisment.collection.entity.RegisterEntities;

public class HellfireTalonItem extends SwordItem {
	public HellfireTalonItem() {
		super(ToolMaterials.NETHERITE, 12, -2.4F, new Settings().maxCount(1).rarity(Rarity.EPIC));
	}
	
	@Override
	public boolean postHit(LivingEntity target, PlayerEntity player) {
		super.postHit(target, player);
		if (player.isOnGround() && !player.getAttackCooldownProgress(0.5f) < 1.0f) {
			if (player.getWorld().getEntitiesByClass(LivingEntity.class, new Box(player.getPos().add(-3.0D, -1.0D, -3.0D), player.getPos().add(3.0D, 1.0D, 3.0D)), entity -> entity != player && entity != target && !player.isTeammate(entity)).size() > 0) {
				slash(player);
			}
		}
		return true;
	}
	
	private void slash(PlayerEntity player) {
		World world = player.getWorld();
		Vec3d lookVec = player.getRotationVec(1.0F);
		double playerX = player.getX();
		double playerY = player.getY() + 1.5;
		double playerZ = player.getZ();

		double spawnX = playerX + lookVec.x * 1.5;
		double spawnY = playerY + lookVec.y * 1.5;
		double spawnZ = playerZ + lookVec.z * 1.5;

		FlameSlashEntity slash = new FlameSlashEntity(RegisterEntities.FLAME_SLASH, world);
		slash.refreshPositionAndAngles(spawnX, spawnY, spawnZ, player.getYaw(), player.getPitch());

		world.spawnEntity(slash);
	}
}