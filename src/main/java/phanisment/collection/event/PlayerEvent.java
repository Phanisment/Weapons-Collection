package phanisment.collection.event;

import net.fabricmc.fabric.api.event.player.PlayerInteractEvent;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import phanisment.collection.util.VFXManager;

public class PlayerEvent {
	public static void registerEvents() {
		PlayerInteractEvent.LEFT_CLICK_AIR.register((player, world, hand) -> {
			if (world instanceof ServerWorld serverWorld) {
				ItemStack heldItem = player.getMainHandStack();
				if (heldItem.getItem() == Items.DIAMOND_SWORD) {
					Vec3d playerPos = player.getPos();
					Vec3d lookVec = player.getRotationVec(1.0F);
					Vec3d spawnPos = playerPos.add(lookVec.multiply(2.0)).add(0, 0.5, 0);
					ItemStack displayItem = new ItemStack(Items.DIAMOND_SWORD);
					float yaw = player.getYaw();
					VFXManager.spawnVFXFacingPlayer(serverWorld, displayItem, spawnPos, yaw);
					return ActionResult.SUCCESS;
				}
			}
			return ActionResult.PASS;
		});
	}
}