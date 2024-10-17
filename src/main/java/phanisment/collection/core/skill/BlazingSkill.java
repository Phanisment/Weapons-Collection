package phanisment.collection.core.skill;

import net.minecraft.util.Identifier;
import net.minecraft.text.Text;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import phanisment.collection.util.TempVariableUtil;
import phanisment.collection.core.mechanic.SkillMechanic;
import phanisment.collection.common.registry.RegisterEntities;
import phanisment.collection.common.entity.base.EffectEntity;
import phanisment.collection.core.CooldownManager;
import phanisment.collection.Weapons;
import phanisment.collection.core.mechanic.DamageMechanic;

import java.util.UUID;

public class BlazingSkill {
	private static TempVariableUtil<UUID, Boolean> isLeap = new TempVariableUtil<>();
	
	private static final Identifier blazing_leap = new Identifier(Weapons.MOD_ID, "blazing_leap");
	private static final Identifier inferno_wheel = new Identifier(Weapons.MOD_ID, "inferno_wheel");
	
	public static void run(World world, PlayerEntity player) {
		UUID playerId = player.getUuid(); 
		if (!player.isSneaking() && !isLeap.containsKey(playerId)) { // Inferno Wheel
			if (CooldownManager.isCooldown(player, inferno_wheel)) {
				EffectEntity vfx = new EffectEntity(RegisterEntities.INFERNO_WHEEL, world);
				vfx.setPosition(player.getX(), player.getY() + 1.2, player.getZ());
				vfx.setSummoner(player.getUuid());
				vfx.setYaw(player.getYaw());
				world.spawnEntity(vfx);
			}
			CooldownManager.setCooldown(player, inferno_wheel, 50);
		} else if (player.isSneaking() && player.isOnGround()) { // Blazing Leap
			if (CooldownManager.isCooldown(player, blazing_leap)) {
				EffectEntity vfx = new EffectEntity(RegisterEntities.BLAZING_LEAP, world);
				vfx.setPosition(player.getX(), player.getY() + 0.1, player.getZ());
				vfx.setYaw(player.getYaw());
				vfx.setSummoner(player.getUuid());
				world.spawnEntity(vfx);
				
				SkillMechanic.leap(player, 0.2, 2.0);
				isLeap.addTempVariable(playerId, true, 2000);
				DamageMechanic.activateTemporaryFallDamageCancel(player, true, 2000)
			}
			CooldownManager.setCooldown(player, blazing_leap, 100);
		} else if (!player.isSneaking() && isLeap.containsKey(playerId)) { //Hellfire Wheel
			SkillMechanic.leap(player, 0.2, -1.0);
			
			EffectEntity vfx = new EffectEntity(RegisterEntities.INFERNO_WHEEL, world);
			vfx.setPosition(player.getX(), player.getY() + 1.5, player.getZ());
			vfx.setSummoner(player.getUuid());
			vfx.setYaw(player.getYaw());
			world.spawnEntity(vfx);
		}
	}
}