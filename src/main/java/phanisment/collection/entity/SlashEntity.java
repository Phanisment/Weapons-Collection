package phanisment.collection.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class SlashEntity extends Entity {
	public SlashEntity(EntityType<? extends Entity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void writeCustomDataToNbt(NbtCompound nbt) {
	}

	@Override
	protected void readCustomDataFromNbt(NbtCompound nbt) {
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void initDataTracker() {
	}
}
