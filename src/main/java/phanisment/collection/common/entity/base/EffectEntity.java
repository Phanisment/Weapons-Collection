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
	public static int frame = 0;
	private int lifetime = 7;

	public EffectEntity(EntityType<? extends EffectEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public void tick() {
		frame++;
		if (!this.getWorld().isClient) {
			if (lifetime-- <= 0) {
				this.discard();
			}
		}
		super.tick();
	}
	
	public static Integer getFrame() {
		return frame;
	}
	
	public void setLifeTimer(Integer time) {
		lifetime = time;
	}

	@Override
	protected void readCustomDataFromNbt(NbtCompound nbt) {
	}

	@Override
	protected void writeCustomDataToNbt(NbtCompound nbt) {
	}

	@Override
	protected void initDataTracker() {
	}

	public void playAnimation(String animationName) {
		AnimationController<EffectEntity> controller = this.cache.getController("type_0");
		controller.setAnimation(RawAnimation.begin().then(animationName, Animation.LoopType.LOOP));
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, "type_0", 5, state -> {
			return state.setAndContinue(RawAnimation.begin().then("animation.model.type_0", Animation.LoopType.LOOP));
		}));
		controllers.add(new AnimationController<>(this, "type_1", 5, state -> {
			return state.setAndContinue(RawAnimation.begin().then("animation.model.type_1", Animation.LoopType.LOOP));
		}));
		controllers.add(new AnimationController<>(this, "type_2", 5, state -> {
			return state.setAndContinue(RawAnimation.begin().then("animation.model.type_2", Animation.LoopType.LOOP));
		}));
		controllers.add(new AnimationController<>(this, "type_3", 5, state -> {
			return state.setAndContinue(RawAnimation.begin().then("animation.model.type_3", Animation.LoopType.LOOP));
		}));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}
}