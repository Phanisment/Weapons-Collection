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
		ItemDisplayEntity itemDisplay = new ItemDisplayEntity(EntityType.ITEM_DISPLAY, world);
		itemDisplay.setPos(position.x, position.y, position.z);
		NbtCompound nbt = new NbtCompound();
		itemStack.writeNbt(nbt);
		itemDisplay.readCustomDataFromNbt(nbt);
		world.spawnEntity(itemDisplay);
		return itemDisplay;
	}

	public static void animateCustomModelData(ItemDisplayEntity itemEntity, int maxFrame, int ticksPerFrame, Runnable onFinish) {
		ServerWorld world = (ServerWorld) itemEntity.getWorld();
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			long tick = world.getServer().getTicks(); // Mengambil jumlah tick saat ini
			int frame = (int) ((tick / ticksPerFrame) % (maxFrame + 1)); // Menghitung frame berdasarkan tick

			if (frame <= maxFrame) {
				NbtCompound nbt = new NbtCompound();
				itemEntity.writeCustomDataToNbt(nbt);
				nbt.putInt("CustomModelData", frame);
				itemEntity.readCustomDataFromNbt(nbt);
			}
			if (frame == maxFrame) {
				onFinish.run();
			}
		});
	}

	public static void setRotation(ItemDisplayEntity itemEntity, float pitch, float yaw, float roll) {
		itemEntity.setYaw(yaw);
		itemEntity.setPitch(pitch);
	}
}
