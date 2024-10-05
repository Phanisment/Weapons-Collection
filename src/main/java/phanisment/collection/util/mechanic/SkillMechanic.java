package phanisment.collection.util.mechanic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;

public class SkillMechanic {
	public static void leap(LivingEntity entity, double forward, double upward) {
		Vec3d lookVec = entity.getRotationVec(1.0F);
		entity.addVelocity(lookVec.x * forward, upward, lookVec.z * forward);
		entity.velocityModified = true;
	}
	
	public static void leapPlayer(PlayerEntity player, double forward, double upward) {
		Vec3d lookVec = player.getRotationVec(1.0F);
		player.addVelocity(lookVec.x * forward, upward, lookVec.z * forward);
		player.velocityModified = true;
	}
}