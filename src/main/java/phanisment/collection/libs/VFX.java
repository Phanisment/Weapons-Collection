package phanisment.collection.libs;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class VFX {

	public static ItemDisplayEntity createItemDisplay(ServerWorld world, ItemStack itemStack, Vec3d position) {
		DisplayItem itemDisplay = new DisplayItem(EntityType.ITEM_DISPLAY, world);
		itemDisplay.setPos(position.x, position.y, position.z);

		// Mengatur data item ke dalam NBT
		NbtCompound nbt = new NbtCompound();
		itemStack.writeNbt(nbt);
		itemDisplay.setCustomData(nbt);

		world.spawnEntity(itemDisplay);
		return itemDisplay;
	}

	public static void animateCustomModelData(ItemDisplayEntity itemDisplay, int maxFrame, int ticksPerFrame, Runnable onFinish) {
		new Thread(() -> {
			try {
				for (int frame = 1; frame <= maxFrame; frame++) {
					// Ambil NBT dari item display
					NbtCompound nbt = itemDisplay.getCustomData();
					nbt.putInt("CustomModelData", frame);

					// Simpan NBT ke item display
					itemDisplay.setCustomData(nbt);
					Thread.sleep(ticksPerFrame * 50); // Tidur untuk durasi animasi
				}
				onFinish.run(); // Jalankan callback setelah animasi selesai
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	public static class DisplayItem extends ItemDisplayEntity {
		public DisplayItem(EntityType<?> type, ServerWorld world) {
			super(type, world);
		}

		// Membaca dan menulis data kustom ke NBT
		public void setCustomData(NbtCompound nbt) {
			this.readCustomDataFromNbt(nbt);
		}

		public NbtCompound getCustomData() {
			NbtCompound nbt = new NbtCompound();
			this.writeCustomDataToNbt(nbt);
			return nbt;
		}
	}
}
