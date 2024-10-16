package phanisment.collection.common.entity.base;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import net.minecraft.nbt.NbtCompound;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.constant.DefaultAnimations;

public class EffectEntity extends Entity implements GeoEntity {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	public int frame = 0;
	private int lifeTime = 7;

	public EffectEntity(EntityType<? extends EffectEntity> entityType, World world) {
		super(entityType, world);
		this.frame = 0;
	}

	@Override
	public void tick() {
		frame++;
		if (!this.getWorld().isClient) {
			if (lifeTime-- <= 0) {
				this.discard();
			}
		}
		super.tick();
	}
	
	public int getFrame() {
		return this.frame;
	}
	
	public void setLifeTimer(int lifeTime) {
		this.lifeTime = lifeTime;
	}

	@Override
	protected void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		this.frame = nbt.getInt("Frame");
		this.lifeTime = nbt.getInt("LifeTime");
	}

	@Override
	protected void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("Frame", this.frame);
		nbt.putInt("LifeTime", this.lifeTime);
	}

	@Override
	protected void initDataTracker() {
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, "idle", 5, state -> state.setAndContinue(DefaultAnimations.IDLE)));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}
}