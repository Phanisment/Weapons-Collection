package phanisment.collection.libs;

import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class VFX {
	public static ItemDisplayEntity createItemDisplay(ServerWorld world, ItemStack itemStack, Vec3d position) {
		// Menggunakan ItemDisplayEntity dari DisplayEntity
		ItemDisplayEntity itemDisplay = new ItemDisplayEntity(world, position.x, position.y, position.z);
		itemDisplay.setStack(itemStack); // Set ItemStack ke item display
		world.spawnEntity(itemDisplay); // Spawn entity di dunia
		return itemDisplay;
	}

	public static void animateCustomModelData(ItemDisplayEntity itemEntity, int maxFrame, int ticksPerFrame, Runnable onFinish) {
		ServerWorld world = (ServerWorld) itemEntity.getWorld();

		// Menggunakan ServerTickEvents untuk animasi frame-by-frame
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			long tick = world.getServer().getTicks(); // Mengambil jumlah tick saat ini

			int frame = (int) ((tick / ticksPerFrame) % (maxFrame + 1)); // Menghitung frame berdasarkan tick

			if (frame <= maxFrame) {
				NbtCompound nbt = itemEntity.getStack().getOrCreateNbt();
				nbt.putInt("CustomModelData", frame); // Set CustomModelData ke frame saat ini
				itemEntity.getStack().setNbt(nbt); // Set NBT kembali ke ItemStack
			}

			// Jalankan callback ketika animasi selesai
			if (frame == maxFrame) {
				onFinish.run();
			}
		});
	}

	public static void setRotation(ItemDisplayEntity itemEntity, float pitch, float yaw, float roll) {
		itemEntity.setYaw(yaw); // Set yaw (horizontal rotation)
		itemEntity.setPitch(pitch); // Set pitch (vertical rotation)
		// Note: Roll biasanya tidak disediakan untuk entitas Minecraft, jadi perlu diimplementasikan sendiri jika ingin.
	}
}
