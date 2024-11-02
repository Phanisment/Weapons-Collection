package phanisment.collection.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class SkillMechanic {
	public static void dash(PlayerEntity player, double power) {
		if (player.isOnGround()) {
			Vec3d direction = calculateDirection(player);
			player.addVelocity(direction.multiply(power));
			player.velocityModified = true;
		}
	}
	
	private static Vec3d calculateDirection(PlayerEntity player) {
		float yaw = player.getYaw();
		float pitch = player.getPitch();
		float yawRad = yaw * 0.017453292F;
		float pitchRad = pitch * 0.017453292F;
		double x = -Math.sin(yawRad) * Math.cos(pitchRad);
		double z = Math.cos(yawRad) * Math.cos(pitchRad);
		return new Vec3d(x, 0, z).normalize();
	}
}