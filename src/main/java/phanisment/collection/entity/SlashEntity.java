package phanisment.collection.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public abstract class SlashEntity extends Entity {
	public SlashEntity(EntityType<? extends Entity> entityType, World world) {
		super(entityType, world);
	}
}