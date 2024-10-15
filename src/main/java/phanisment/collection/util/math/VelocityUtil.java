package phanisment.collection.util.math;

import net.minecraft.util.math.Vec3d;

public class VelocityUtil {
	public static Vec3d targetToPlayer(Vec3d player, Vec3d target) {
		return targetToPlayer(player, target, 1.0);
	}

	public static Vec3d targetToPlayer(Vec3d player, Vec3d target, double speed) {
		if (player.equals(target)) return Vec3d.ZERO;
		Vec3d direction = target.subtract(player).normalize();
		return direction.scale(speed);
	}
}