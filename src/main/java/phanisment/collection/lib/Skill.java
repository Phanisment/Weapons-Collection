package phanisment.collection.lib;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;

public interface Skill {
	void cast(PlayerEntity player, World world);
}