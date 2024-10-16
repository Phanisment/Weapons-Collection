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

import java.util.UUID;

public class EffectEntity extends Entity implements GeoEntity {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private int frame = 0;
	private int lifeTime = 7;
	private UUID summoner;

	public EffectEntity(EntityType<? extends EffectEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public void tick() {
		frame++;
		if (!this.getWorld().isClient) {
			if (lifeTime-- < 0) {
				this.discard();
			}
		}
		super.tick();
	}
	
	public void setSummoner(UUID summoner) {
		this.summoner = summoner;
	}
	
	public UUID getSummoner() {
		return summoner;
	}
	
	public int getFrame() {
		return this.frame;
	}
	
	public void setLifeTimer(int lifeTime) {
		this.lifeTime = lifeTime;
	}

	@Override
	protected void readCustomDataFromNbt(NbtCompound nbt) {
		if (nbt.contains("Frame")) {
			this.frame = nbt.getInt("Frame");
		}
		if (nbt.contains("LifeTime")) {
			this.lifeTime = nbt.getInt("LifeTime");
		}
		
		if (nbt.contains("Summoner")) {
			this.summoner = nbt.getUuid("Summoner");
		}
	}

	@Override
	protected void writeCustomDataToNbt(NbtCompound nbt) {
		nbt.putInt("Frame", this.frame);
		nbt.putInt("LifeTime", this.lifeTime);
		nbt.putUuid("Summoner", this.summoner);
	}

	@Override
	protected void initDataTracker() {
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}
}