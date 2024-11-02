package phanisment.collection.common.skill;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;

import phanisment.collection.common.registry.RegisterEntities;
import phanisment.collection.common.entity.base.EffectEntity;
import phanisment.collection.util.Skill;
import phanisment.collection.util.SkillMechanic;
import phanisment.collection.lib.Delay;

public class DashSkill implements Skill {
	
	@Override
	public void cast(PlayerEntity player) {
		SkillMechanic.dash(player, 2);
		World world = player.getWorld();
		
		spawnImpact(player, world);
		Delay.run(1, () -> {
			spawnDash(player, world);
		});
	}
	
	private void spawnDash(PlayerEntity player, World world) {
		EffectEntity dash = new EffectEntity(RegisterEntities.BASIC_DASH, world);
		dash.setPosition(player.getPos());
		dash.setYaw(player.getYaw());
		dash.setLifeSpan(4);
		dash.setSummoner(player);
		world.spawnEntity(dash);
	}
	
	private void spawnImpact(PlayerEntity player, World world) {
		Vec3d pos = player.getPos();
		EffectEntity impact = new EffectEntity(RegisterEntities.BASIC_IMPACT, world);
		impact.setYaw(player.getYaw());
		impact.setPosition(pos.x, pos.y + 0.2, pos.z);
		impact.setLifeSpan(4);
		impact.setSummoner(player);
		world.spawnEntity(impact);
	}
}