package phanisment.collection.core;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownManager {
	private static final Map<UUID, Map<Identifier, Integer>> playerCooldowns = new HashMap<>();

	public static void tick(PlayerEntity player) {
		UUID playerId = player.getUuid();
		if (playerCooldowns.containsKey(playerId)) {
			Map<Identifier, Integer> cooldowns = playerCooldowns.get(playerId);
			cooldowns.forEach((skillId, timeLeft) -> {
				if (timeLeft > 0) {
					cooldowns.put(skillId, timeLeft - 1);
				}
			});
		}
	}

	public static void setCooldown(PlayerEntity player, Identifier skillId, int ticks) {
		UUID playerId = player.getUuid();
		Map<Identifier, Integer> cooldowns = playerCooldowns.computeIfAbsent(playerId, k -> new HashMap<>());
		int currentCooldown = cooldowns.getOrDefault(skillId, 0);
		if (currentCooldown <= 0) {
			cooldowns.put(skillId, ticks);
		}
	}

	public static boolean isCooldown(PlayerEntity player, Identifier skillId) {
		UUID playerId = player.getUuid();
		return playerCooldowns.containsKey(playerId) && playerCooldowns.get(playerId).getOrDefault(skillId, 0) > 0;
	}

	public static int getCooldown(PlayerEntity player, Identifier skillId) {
		UUID playerId = player.getUuid();
		return playerCooldowns.getOrDefault(playerId, new HashMap<>()).getOrDefault(skillId, 0);
	}
}
