package phanisment.collection.common;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import phanisment.collection.entity.TesEntity;

public class PlayerInteraction {
	public static void register() {
		AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
			if (!world.isClientSide && hand == player.getUsedItemHand()) {
				if (!player.isShiftKeyDown()) {
					summonTesEntity(player);
				}
			}
			return InteractionResult.PASS;
		});
	}
	
	public static void summonTesEntity(PlayerEntity player) {
		World world = player.getWorld();
		TesEntity tesEntity = new TesEntity(RegisterEntities.TES, world, player);
		tesEntity.setPos(player.getX(), player.getY(), player.getZ());
		tesEntity.lookAtPlayer(player);
		world.spawnEntity(tesEntity);
	}
}