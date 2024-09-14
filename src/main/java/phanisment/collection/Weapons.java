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
			// Pastikan pemain menggunakan tangan utama dan dunia adalah server-side (bukan client)
			if (!world.isClient() && hand == Hand.MAIN_HAND) {
				ItemStack itemInHand = player.getMainHandStack();

				// Cek apakah item yang dipegang adalah Diamond Sword
				if (itemInHand.getItem() == Items.DIAMOND_SWORD) {
					// Spawn VFX di posisi pemain
					spawnVFX((ServerWorld) world, player);
				}
			}
			return ActionResult.PASS;
		});
	}

	public static void spawnVFX(ServerWorld world, PlayerEntity player) {
		// Posisi spawn VFX di sekitar pemain
		Vec3d playerPos = player.getPos();

		// Spawn item display menggunakan VFX pada posisi pemain
		ItemStack itemStack = new ItemStack(Items.DIAMOND_SWORD);

		// Spawn VFX di depan pemain sedikit
		Vec3d spawnPos = playerPos.add(player.getRotationVector().multiply(1.5));
		
		// Spawn item display
		ItemDisplayEntity itemDisplay = VFX.createItemDisplay(world, itemStack, spawnPos);

		// Animate CustomModelData dari 0 (basic texture) hingga 7
		VFX.animateCustomModelData(itemDisplay, 7, 5, () -> {
			// Callback saat animasi selesai, bisa disesuaikan
			itemDisplay.discard(); // Menghapus item display setelah animasi selesai
		});

		// Set rotasi dari item display
		VFX.setRotation(itemDisplay, 45.0F, 90.0F, 0.0F);
	}
}
