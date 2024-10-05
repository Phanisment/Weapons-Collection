package phanisment.collection.common.skill;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import phanisment.collection.util.TempVariableUtil;
import phanisment.collection.util.mechanic.SkillMechanic;
import phanisment.collection.entity.BlazeLeapEntity;
import phanisment.collection.entity.RegisterEntities;

import java.util.UUID;

public class BlazeLeapSkill {
	private TempVariableUtil<UUID, Boolean> isLeap = new TempVariableUtil<>();

	public static void run(World world, PlayerEntity player) {
		UUID playerId = player.getUuid(); 
		if (player.isSneaking() && player.isOnGround()) {
			BlazeLeapEntity vfx = new BlazeLeapEntity(RegisterEntities.BLAZE_LEAP, world);
			vfx. setPosition(player.getX(), player.getY() + 0.1, player.getZ());
			world.spawnEntity(vfx);
			
			SkillMechanic.leap(player, 0.2, 1.0);
			isLeap.addTempVariable(playerId, true, 1000);
		} 
		else if (!player.isSneaking() && isLeap.containsKey(playerId)) {
			SkillMechanic.jump(player, -10);
		}
	}
}