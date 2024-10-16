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
		if (!player.isSneaking()) {
			EffectEntity vfx = new EffectEntity(RegisterEntities.TEST, world);
			vfx.setPosition(player.getX(), player.getY() + 1.5, player.getZ());
			vfx.setSummoner(player.getUuid());
			vfx.setYaw(player.getYaw());
			world.spawnEntity(vfx);
		} else if (player.isSneaking() && player.isOnGround()) {
			EffectEntity vfx = new EffectEntity(RegisterEntities.TEST, world);
			vfx.setPosition(player.getX(), player.getY() + 0.1, player.getZ());
			vfx.setSummoner(player.getUuid());
			vfx.setYaw(player.getYaw());
			world.spawnEntity(vfx);
			SkillMechanic.leap(player, 0.2, 1.0);
			isLeap.addTempVariable(playerId, true, 1000);
		} else if (!player.isSneaking() && isLeap.containsKey(playerId)) {
			SkillMechanic.leap(player, 0.4, -1.5);
			EffectEntity vfx = new EffectEntity(RegisterEntities.TEST, world);
			vfx.setPosition(player.getX(), player.getY() + 1.5, player.getZ());
			vfx.setSummoner(player.getUuid());
			vfx.setYaw(player.getYaw());
			world.spawnEntity(vfx);
		}
	}
}