package phanisment.collection;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import phanisment.collection.libs.VFX;

public class Weapons implements ModInitializer {
	public static final String MOD_ID = "phanisments-weapons-collection";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		UseItemCallback.EVENT.register((player, world, hand) -> {
			if (hand == Hand.MAIN_HAND && !world.isClient()) {
				ItemStack mainHandStack = player.getMainHandStack();
				if (mainHandStack.getItem() == Items.DIAMOND_SWORD) {
					createSlashEffect(world, player.getPos(), player.getRotationVec(1.0F));
					return TypedActionResult.success(mainHandStack);
				}
			}
			return TypedActionResult.pass(ItemStack.EMPTY);
		});
	}

	private void createSlashEffect(World world, Vec3d playerPos, Vec3d lookDirection) {
		if (world instanceof ServerWorld serverWorld) {
			Vec3d slashPos = playerPos.add(lookDirection.normalize().multiply(2)); // Efek muncul di depan player
			ItemDisplayEntity slashEffect = VFX.createItemDisplay(serverWorld, Items.DIAMOND_SWORD.getDefaultStack(), slashPos);
			VFX.animateCustomModelData(slashEffect, 5, 5, () -> {
				slashEffect.kill();
			});
		}
	}
}
