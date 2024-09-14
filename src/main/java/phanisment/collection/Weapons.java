package phanisment.collection;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import phanisment.collection.libs.VFX;

public class Weapons implements ModInitializer {
	public static final String MOD_ID = "phanisments-weapons-collection";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (!world.isClient() && hand == Hand.MAIN_HAND) {
				ItemStack itemInHand = player.getMainHandStack();
				if (itemInHand.getItem() == Items.DIAMOND_SWORD) {
					spawnVFX((ServerWorld) world, player);
				}
			}
			return ActionResult.PASS;
		});
	}

	public static void spawnVFX(ServerWorld world, PlayerEntity player) {		Vec3d playerPos = player.getPos();
		ItemStack itemStack = new ItemStack(Items.DIAMOND_SWORD);
		Vec3d spawnPos = playerPos.add(player.getRotationVector().multiply(1.5));
		ItemDisplayEntity itemDisplay = VFX.createItemDisplay(world, itemStack, spawnPos);
		VFX.animateCustomModelData(itemDisplay, 7, 5, () -> {
			itemDisplay.discard();
		});
		VFX.setRotation(itemDisplay, 45.0F, 90.0F, 0.0F);
	}
}
