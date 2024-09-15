package phanisment.collection.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class SlashEntity extends Entity {
	public int animationFrame = 0;
	public final int maxAnimationFrames = 10;

	public SlashEntity(EntityType<? extends SlashEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public void tick() {
		super.tick();
		animationFrame++;
		if (animationFrame >= maxAnimationFrames) {
			this.remove(RemovalReason.DISCARDED);
		}
	}

	@Override
	protected void initDataTracker() {}

	@Override
	protected void readCustomDataFromNbt(NbtCompound nbt) {}

	@Override
	protected void writeCustomDataToNbt(NbtCompound nbt) {}
}
