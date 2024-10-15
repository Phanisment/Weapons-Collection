package phanisment.collection.util.math;

import net.minecraft.util.math.Vec3d;

public class VelocityUtil {
	public static Vec3d playerToTarget(Vec3d playerPos, Vec3d targetPos, double speed) {
		double distanceX = targetPos.getX() - playerPos.getX();
		double distanceY = targetPos.getY() - playerPos.getY();
		double distanceZ = targetPos.getZ() - playerPos.getZ();
		double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
		double normX = distanceX / distance;
		double normY = distanceY / distance;
		double normZ = distanceZ / distance;
		double velocityX = normX * speed;
		double velocityY = normY * speed;
		double velocityZ = normZ * speed;
		return new Vec3d(velocityX, velocityY, velocityZ);
	}
}
