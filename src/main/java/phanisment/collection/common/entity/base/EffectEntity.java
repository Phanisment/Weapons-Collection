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
	private UUID summonerUuid;

	private float rotationX = 0.0F;
	private float rotationY = 0.0F;
	private float rotationZ = 0.0F;
	
	private float sizeX = 1.0F;
	private float sizeY = 1.0F;
	private float sizeZ = 1.0F;

	private final AnimationController<EffectEntity> animationController;

	public EffectEntity(EntityType<? extends EffectEntity> entityType, World world) {
		super(entityType, world);
		this.frame = 0;
		
		animationController = new AnimationController<>(this, "controller", 0, this::animationPredicate);
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
	
	public void setLifeSpan(int lifeSpan) {
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

	public Entity getSummoner() { return summoner; }
	public UUID getSummonerByUUID() { return summonerUuid; }
	public int getFrame() { return frame; }
	public int getLifeSpan() { return lifeSpan; }
	
	public float getRotationX() { return rotationX; }
	public float getRotationY() { return rotationY; }
	public float getRotationZ() { return rotationZ; }
	
	public float getSizeX() { return sizeX; }
	public float getSizeY() { return sizeY; }
	public float getSizeZ() { return sizeZ; }

	@Override
	protected void readCustomDataFromNbt(NbtCompound nbt) {
		if (nbt.contains("Frame")) {
			this.frame = nbt.getInt("Frame");
		}
		if (nbt.contains("lifeSpan")) {
			this.lifeSpan = nbt.getInt("lifeSpan");
		}
		
		if (nbt.contains("Summoner")) {
			this.summonerUuid = nbt.getUuid("Summoner");
		}
	}

	@Override
	protected void writeCustomDataToNbt(NbtCompound nbt) {
		nbt.putInt("Frame", this.frame);
		nbt.putInt("lifeSpan", this.lifeSpan);
		nbt.putUuid("Summoner", this.summoner.getUuid());
	}

	@Override
	protected void initDataTracker() {}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(animationController);
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() { return cache; }

	private <E extends GeoEntity> PlayState animationPredicate(AnimationState<E> event) {
		return PlayState.CONTINUE;
	}

	public void playAnimation(String animationName, LoopType loopType) {
		animationController.setAnimation(RawAnimation.begin().then(animationName, loopType));
	}
}
