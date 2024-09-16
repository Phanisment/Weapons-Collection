package phanisment.collection.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class SlashEntity extends Entity {
	public SlashEntity(EntityType<? extends SlashEntity> entityType, World world) {
		super(entityType, world);
	}
	@Override
	protected void initDataTracker() {
	}

	@Override
	protected void readCustomDataFromNbt(NbtCompound nbt) {
	}

	@Override
	protected void writeCustomDataToNbt(NbtCompound nbt) {
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		return false;
	}

	@Override
	public boolean collides() {
		return false;
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void pushAway(Entity entity) {
	}

	@Override
	public HitResult raycast(double maxDistance, float tickDelta, boolean includeFluids) {
		return null;
	}

	@Override
	public void tick() {
		super.tick();
	}
}