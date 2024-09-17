package phanisment.collection.event;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.server.world.ServerWorld;

import phanisment.collection.util.VFXManager;

public class PlayerEvent {
	public static void registerEvents() {
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (world instanceof ServerWorld serverWorld) {
				ItemStack heldItem = player.getMainHandStack();
				if (heldItem.getItem() == Items.DIAMOND_SWORD) {
					Vec3d playerPos = player.getPos();
					Vec3d lookVec = player.getRotationVec(1.0F);
					Vec3d spawnPos = playerPos.add(lookVec.multiply(2.0));
					ItemStack displayItem = new ItemStack(Items.DIAMOND_SWORD);
					VFXManager.spawnVFX(serverWorld, displayItem, spawnPos);

					return ActionResult.SUCCESS;
				}
			}
			return ActionResult.PASS;
		});
	}
}