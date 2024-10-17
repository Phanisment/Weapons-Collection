package phanisment.collection.core.skill;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import phanisment.collection.util.TempVariableUtil;
import phanisment.collection.core.mechanic.SkillMechanic;
import phanisment.collection.common.registry.RegisterEntities;
import phanisment.collection.common.entity.base.EffectEntity;

import java.util.UUID;

public class BlazingSkill {
	private static TempVariableUtil<UUID, Boolean> isLeap = new TempVariableUtil<>();
	
	public static void run(World world, PlayerEntity player) {
		UUID playerId = player.getUuid(); 
		if (!player.isSneaking() && !isLeap.containsKey(playerId)) { // Inferno Wheel
			
		} else if (player.isSneaking() && player.isOnGround()) { // Blazing Leap
			SkillMechanic.effect(player, RegisterEntities.BLAZING_LEAP, world, 0.1);
			SkillMechanic.leap(player, 0.2, 1.0);
			isLeap.addTempVariable(playerId, true, 2000);
		} else if (!player.isSneaking() && isLeap.containsKey(playerId)) { // Hellfire Wheel
			SkillMechanic.leap(player, 0.4, -1.5);
			SkillMechanic.effect(player, RegisterEntities.INFERNO_WHEEL, world, 0.1);
		}
	}
}