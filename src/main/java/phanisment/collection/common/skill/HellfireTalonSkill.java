package phanisment.collection.common.skill;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import phanisment.collection.entity.FlameSlashEntity;
import phanisment.collection.entity.RegisterEntities;
import phanisment.collection.item.RegisterItems;

public class HellfireTalonSkill {
	public static void slashSkill(MinecraftClient mc) {
		ItemStack heldItem = mc.player.getMainHandStack();
		if (heldItem.isOf(RegisterItems.HELLFIRE_TALON)) {
			Vec3d lookVec = mc.player.getRotationVec(1.0F);
			double playerX = mc.player.getX();
			double playerY = mc.player.getY() + 1.5;
			double playerZ = mc.player.getZ();
			double spawnX = playerX + lookVec.x * 1.5;
			double spawnY = playerY + lookVec.y * 1.5;
			double spawnZ = playerZ + lookVec.z * 1.5;
			World world = mc.player.getWorld();

			FlameSlashEntity slash = new FlameSlashEntity(RegisterEntities.FLAME_SLASH, world);
			slash.refreshPositionAndAngles(spawnX, spawnY, spawnZ, mc.player.getYaw(), mc.player.getPitch());
			world.spawnEntity(slash);
		}
	}
	
	public static void infernoWheelSkill() {
		
	}
	
	public static void leapSkill() {
		
	}
}