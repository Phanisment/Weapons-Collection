package phanisment.collection.core.mechanic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

public class SkillMechanic {
	public static void leap(PlayerEntity player, double forward, double upward) {
		Vec3d lookVec = player.getRotationVec(1.0F);
		player.addVelocity(lookVec.x * forward, upward, lookVec.z * forward);
		player.velocityModified = true;
	}
	
	public static void jump(PlayerEntity player, double height) {
		player.addVelocity(0, height, 0);
		player.velocityModified = true;
	}
}