package phanisment.collection.entity;

import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class TesEntity extends PathAwareEntity {
	public TesEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
		super(entityType, world);
	}
}
