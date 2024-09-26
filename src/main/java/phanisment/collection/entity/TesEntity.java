package phanisment.collection.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TesEntity extends AnimalEntity {
	private int lifeTime = 100;

	public TesEntity(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.world.isClient) {
			if (this.lifeTime-- <= 0) {
				this.discard();
			}
		}
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
	public void move(Vec3d movementInput) {
	}

	@Override
	public void baseTick() {
	}

	@Override
	public TesEntity createChild(ServerWorld world, PassiveEntity mate) {
		return null;
	}
}