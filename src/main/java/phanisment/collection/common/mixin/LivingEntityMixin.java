package phanisment.collection.common.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import phanisment.collection.core.mechanic.DamageMechanic;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	@Inject(method = "handleFallDamage", at = @At("HEAD"))
	private boolean onFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource, CallbackInfo ci) {
		return DamageMechanic.damageFall(damageSource);
	}
}