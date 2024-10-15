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
	private void tick() {
		frame++;
		if (!this.getWorld().isClient) {
			if (lifetime-- <= 0) {
				this.remove();
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
		controller.setAnimation(new AnimationBuilder().addAnimation(animationName, true));
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, "type_0", 5, state -> {
			return state.setAndContinue("animation.model.type_0");
		}));
		controllers.add(new AnimationController<>(this, "type_1", 5, state -> {
			return state.setAndContinue("animation.model.type_1");
		}));
		controllers.add(new AnimationController<>(this, "type_2", 5, state -> {
			return state.setAndContinue("animation.model.type_2");
		}));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return cache;
	}
}