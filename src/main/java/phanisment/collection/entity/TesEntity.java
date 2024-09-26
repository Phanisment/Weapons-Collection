package phanisment.collection.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
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
		if (!this.getWorld().isClient) {
			if (this.lifeTime-- <= 0) {
				this.discard();
			}
		}
	}

	@Override
	public boolean isPushableByFluids() {
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

	public static DefaultAttributeContainer.Builder createAttributes() {
		return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0);
	}
}
