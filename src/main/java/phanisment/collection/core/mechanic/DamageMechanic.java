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

	public static boolean damageFall(DamageSource source) {
		if (source.getAttacker() instanceof PlayerEntity) {
			UUID playerId = source.getAttacker().getUuid();
			if (status.containsKey(playerId)) {
				return false;
			}
		}
		return true;
	}

	public static void cancelFallDamage(PlayerEntity player, long duration) {
		UUID playerId = player.getUuid();
		status.addTempVariable(playerId, true, duration);
	}
}