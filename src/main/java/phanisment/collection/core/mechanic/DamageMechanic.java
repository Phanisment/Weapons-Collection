package phanisment.collection.core.mechanic;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import phanisment.collection.util.TempVariableUtil;

import java.util.UUID;

public class DamageMechanic {
	private static final TempVariableUtil<UUID, Boolean> fallDamageCancelStatus = new TempVariableUtil<>();

	public static void register() {
		ServerEntityCombatEvents.AFTER_DAMAGE.register((entity, source, amount) -> {
			if (entity instanceof PlayerEntity player) {
				UUID playerId = player.getUuid();
				if (source == DamageSource.FALL && fallDamageCancelStatus.containsKey(playerId)) {
					return 0.0F;
				}
			}
			return amount;
		});
	}
	
	public static void activateTemporaryFallDamageCancel(PlayerEntity player, long durationMillis) {
		UUID playerId = player.getUuid();
		fallDamageCancelStatus.addTempVariable(playerId, true, durationMillis);
	}
}