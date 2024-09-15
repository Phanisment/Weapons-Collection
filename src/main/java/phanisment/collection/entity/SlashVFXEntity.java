package phanisment.collection.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class SlashVFXEntity extends Entity {
	public int lifeTime = 20;
	public SlashVFXEntity(EntityType<? extends SlashVFXEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public void tick() {
		super.tick();
		
		if (this.lifeTime-- <= 0) {
			this.discard();
		}
	}

	@Override
	protected void initDataTracker() {
	}

	@Override
	protected void readCustomDataFromNbt(NbtCompound nbt) {
		this.lifeTime = nbt.getInt("LifeTime");
	}

	@Override
	protected void writeCustomDataToNbt(NbtCompound nbt) {
		nbt.putInt("LifeTime", this.lifeTime);
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		return false;
	}

	@Override
	public boolean collides() {
		return false;
	}
}
