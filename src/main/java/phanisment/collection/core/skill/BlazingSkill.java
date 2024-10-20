package phanisment.collection.core.skill;

import net.minecraft.util.Identifier;
import net.minecraft.text.Text;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;

import phanisment.collection.core.mechanic.EntityTargeter;
import phanisment.collection.util.TempVariableUtil;
import phanisment.collection.core.mechanic.SkillMechanic;
import phanisment.collection.common.registry.RegisterEntities;
import phanisment.collection.common.entity.base.EffectEntity;
import phanisment.collection.core.CooldownManager;
import phanisment.collection.Weapons;

import java.util.UUID;
import java.util.List;
import java.util.Arrays;

public class BlazingSkill {
	private static TempVariableUtil<UUID, Boolean> isLeap = new TempVariableUtil<>();
	
	public static void run(World world, PlayerEntity player) {
		UUID playerId = player.getUuid(); 
		if (!player.isSneaking() && !isLeap.containsKey(playerId)) { // Inferno Wheel
			
		} else if (player.isSneaking() && player.isOnGround()) { // Blazing Leap
			EffectEntity vfx = new EffectEntity(RegisterEntities.BLAZING_LEAP, world);
			vfx.setPosition(player.getX(), player.getY() + 0.1, player.getZ());
			vfx.setYaw(player.getYaw());
			vfx.setSummoner(player.getUuid());
			world.spawnEntity(vfx);
			
			SkillMechanic.leap(player, 0.2, 1.0);
			isLeap.addTempVariable(playerId, true, 2000);
		} else if (!player.isSneaking() && isLeap.containsKey(playerId)) { //Hellfire Wheel
			SkillMechanic.leap(player, 0.2, -1.0);
			
			EffectEntity vfx = new EffectEntity(RegisterEntities.INFERNO_WHEEL, world);
			vfx.setPosition(player.getX(), player.getY() + 1.5, player.getZ());
			vfx.setSummoner(player.getUuid());
			vfx.setYaw(player.getYaw());
			world.spawnEntity(vfx);
		}
	}
	
	public static void slash(MinecraftClient client, ClientPlayerEntity player) {
			EffectEntity vfx = new EffectEntity(RegisterEntities.INFERNO_WHEEL, world);
			vfx.setPosition(player.getX(), player.getY() + 1.5, player.getZ());
			vfx.setSummoner(player.getUuid());
			vfx.setYaw(player.getYaw());
			client.world.spawnEntity(vfx);
	}
}