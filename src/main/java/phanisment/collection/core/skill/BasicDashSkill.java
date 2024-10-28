package phanisment.collection.core.skill;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import phanisment.collection.common.entity.base.EffectEntity;
import phanisment.collection.common.registry.RegisterEntities;
import phanisment.collection.core.mechanic.SkillMechanic;

public class BasicDashSkill {
	public void cast(PlayerEntity player, World world) {
		spawnBasicDash(player, world);
		SkillMechanic.leap(player, 2, 0, 2);
	}

	private void spawnBasicDash(PlayerEntity player, World world) {
		EffectEntity vfx = new EffectEntity(RegisterEntities.BASIC_DASH, world);
		vfx.setPosition(player.getPos());
		vfx.setRot(0, player.getYaw(), 0);
		vfx.setSummoner(player);
		world.spawnEntity(vfx);
	}
}
