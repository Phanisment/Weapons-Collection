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
	private int frame;
	private int lifeSpan;
	private Entity summoner;

	private float rotationX = 0.0F;
	private float rotationY = 0.0F;
	private float rotationZ = 0.0F;
	
	private float sizeX = 1.0F;
	private float sizeY = 1.0F;
	private float sizeZ = 1.0F;

	public EffectEntity(EntityType<? extends EffectEntity> entityType, World world) {
		super(entityType, world);
		this.frame = 0;
	}

	@Override
	public void tick() {
		frame++;
		
		if (!this.getWorld().isClient) {
			if (lifeSpan-- < 0) {
				this.discard();
			}
		}
		super.tick();
	}
	
	public void setSummoner(Entity summoner) {
		this.summoner = summoner;
	}
	
	public Entity getSummoner() {
		return summoner;
	}
	
	public int getFrame() {
		return this.frame;
	}
	
	public void setLifeTimer(int lifeSpan) {
		this.lifeSpan = lifeSpan;
	}

	public void setRot(float x, float y, float z) {
		this.rotationX = x;
		this.rotationY = y;
		this.rotationZ = z;
	}

	public void setSize(float x, float y, float z) {
		this.sizeX = x;
		this.sizeY = y;
		this.sizeZ = z;
	}

	public float getRotationX() {return rotationX;}
	public float getRotationY() {return rotationY;}
	public float getRotationZ() {return rotationZ;}
	
	public float getSizeX() {return sizeX;}
	public float getSizeY() {return sizeY;}
	public float getSizeZ() {return sizeZ;}

	@Override
	protected void readCustomDataFromNbt(NbtCompound nbt) {
		if (nbt.contains("Frame")) {
			this.frame = nbt.getInt("Frame");
		}
		if (nbt.contains("lifeSpan")) {
			this.lifeSpan = nbt.getInt("lifeSpan");
		}
		
		if (nbt.contains("Summoner")) {
			this.summoner = nbt.getUuid("Summoner");
		}
	}

	@Override
	protected void writeCustomDataToNbt(NbtCompound nbt) {
		nbt.putInt("Frame", this.frame);
		nbt.putInt("lifeSpan", this.lifeSpan);
		nbt.putUuid("Summoner", this.summoner.getUuid());
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