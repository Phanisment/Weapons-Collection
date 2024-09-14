package phanisment.collection.libs;

import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class VFX {
	public static ItemEntity createItemDisplay(ServerWorld world, ItemStack itemStack, Vec3d position, boolean noGravity) {
		// Membuat ItemEntity (item jatuh) dengan posisi dan gravitasi tertentu
		ItemEntity itemEntity = new ItemEntity(world, position.x, position.y, position.z, itemStack);
		itemEntity.setNoGravity(noGravity);  // Menentukan apakah item jatuh atau tidak
		itemEntity.setVelocity(Vec3d.ZERO);  // Matikan pergerakan

		world.spawnEntity(itemEntity);  // Spawn entitas di dunia
		return itemEntity;
	}

	public static void animateCustomModelData(ItemEntity itemEntity, int maxFrame, int ticksPerFrame, Runnable onFinish) {
		ServerWorld world = (ServerWorld) itemEntity.getWorld();
		world.getServer().getOverworld().getServer().getScheduler().schedule(() -> {
			for (int frame = 1; frame <= maxFrame; frame++) {
				if (frame <= maxFrame) {
					NbtCompound nbt = itemEntity.getStack().getOrCreateNbt();
					nbt.putInt("CustomModelData", frame);
					itemEntity.getStack().setNbt(nbt);
				}
			}

			// Callback ketika animasi selesai
			onFinish.run();
		}, ticksPerFrame);
	}

	public static void setRotation(ItemEntity itemEntity, float pitch, float yaw, float roll) {
		// Mengubah rotasi item di dunia (rotation pitch, yaw, roll)
		itemEntity.setYaw(yaw);	// Rotasi horizontal
		itemEntity.setPitch(pitch); // Rotasi vertikal
		
		// Tambahan roll (jika diperlukan)
		// Karena Minecraft tidak mendukung "roll" secara langsung untuk item, Anda bisa memodifikasinya secara visual (client-side) menggunakan rendering API khusus.
	}
}
