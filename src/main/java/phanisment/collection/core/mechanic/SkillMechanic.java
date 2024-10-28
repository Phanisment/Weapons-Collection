package phanisment.collection.core.mechanic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class SkillMechanic {
	public static void leap(PlayerEntity target, double forward, double upward, double velocity) {
		Vec3d lookVec = target.getRotationVec(1.0F);
		target.addVelocity(lookVec.x + forward * velocity, upward * velocity, lookVec.z + forward * velocity);
		target.velocityModified = true;
	}
	
	public static void jump(PlayerEntity target, double height) {
		target.addVelocity(0, height, 0);
		target.velocityModified = true;
	}
}