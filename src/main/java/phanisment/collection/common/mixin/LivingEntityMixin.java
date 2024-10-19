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
	@Inject(method = "applyDamage", at = @At("HEAD"))
	private void onApplyDamage(DamageSource source, float amount, CallbackInfo ci) {
		new DamageMechanic(source, amount, ci);
	}
}