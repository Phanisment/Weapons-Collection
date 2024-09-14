package phanisment.collection.libs;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class VFX {
	public static ItemDisplayEntity createItemDisplay(ServerWorld world, ItemStack itemStack, Vec3d position) {
		// Menggunakan ItemDisplayEntity dengan EntityType dan World
		ItemDisplayEntity itemDisplay = new ItemDisplayEntity(EntityType.ITEM_DISPLAY, world);
		
		// Set posisi entity
		itemDisplay.setPos(position.x, position.y, position.z);

		// Set ItemStack ke item display menggunakan NBT
		NbtCompound nbt = new NbtCompound();
		itemStack.writeNbt(nbt);
		itemDisplay.readCustomDataFromNbt(nbt); // Membaca data dari NBT untuk item display

		// Spawn entity di dunia
		world.spawnEntity(itemDisplay);

		return itemDisplay;
	}

	public static void animateCustomModelData(ItemDisplayEntity itemEntity, int maxFrame, int ticksPerFrame, Runnable onFinish) {
		ServerWorld world = (ServerWorld) itemEntity.getWorld();

		// Menggunakan ServerTickEvents untuk animasi frame-by-frame
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			long tick = world.getServer().getTicks(); // Mengambil jumlah tick saat ini

			int frame = (int) ((tick / ticksPerFrame) % (maxFrame + 1)); // Menghitung frame berdasarkan tick

			if (frame <= maxFrame) {
				// Mengambil NBT dari entity display
				NbtCompound nbt = new NbtCompound();
				itemEntity.writeCustomDataToNbt(nbt);

				// Set CustomModelData ke frame saat ini
				nbt.putInt("CustomModelData", frame);

				// Tulis kembali NBT ke entity display
				itemEntity.readCustomDataFromNbt(nbt);
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
