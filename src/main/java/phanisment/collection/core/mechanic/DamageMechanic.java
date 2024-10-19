package phanisment.collection.core.mechanic;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

import phanisment.collection.util.TempVariableUtil;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

public class DamageMechanic {
	private static final TempVariableUtil<UUID, Boolean> status = new TempVariableUtil<>();
	
	public DamageSource source;
	public float amount;
	
	public DamageMechanic(DamageSource source, float amount, CallbackInfo ci) {
		if (source.getAttacker() instanceof PlayerEntity) {
			UUID playerId = source.getAttacker().getUuid();
			if (source.getName().equals("fall") && status.containsKey(playerId)) {
				ci.cancel();
			}
		}
		this.source = source;
		this.amount = amount;
	}

	public static void cancelFallDamage(PlayerEntity player, long duration) {
		UUID playerId = player.getUuid();
		status.addTempVariable(playerId, true, duration);
	}
}