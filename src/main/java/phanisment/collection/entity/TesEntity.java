package phanisment.collection.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TesEntity extends AnimalEntity {
	private int lifeTime = 6;
	private int tickCounter = 0;

	public TesEntity(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public void tick() {
		super.tick();
		
		this.tickCounter++;
		
		if (!this.getWorld().isClient) {
			if (this.lifeTime-- <= 0) {
				this.discard();
			}
		}
	}
	
	public int getTickCounter() {
		return this.tickCounter;
	}

	@Override
	public void baseTick() {
	}

	@Override
	public boolean hasNoGravity() {
		return true;
	}

	@Override
	public boolean damage(DamageSource source, float amount) {
		return false;
	}

	@Override
	public TesEntity createChild(ServerWorld world, PassiveEntity mate) {
		return null;
	}

	@Override
	public boolean isInvulnerableTo(DamageSource damageSource) {
		return true;
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0);
	}
}
