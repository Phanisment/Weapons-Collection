package phanisment.collection.libs;

import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.decoration.DisplayEntity;

public class VFX {
	public static ItemEntity createItemDisplay(ServerWorld world, ItemStack itemStack, Vec3d position) {
		ItemDisplayEntity itemDisplay = new ItemDisplayEntity(world, position.x, position.y, position.z, itemStack);
		world.spawnEntity(itemDisplay);
		return itemDisplay;
	}

	public static void animateCustomModelData(ItemEntity itemEntity, int maxFrame, int ticksPerFrame, Runnable onFinish) {
		ServerWorld world = (ServerWorld) itemEntity.getWorld();
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			for (int frame = 1; frame <= maxFrame; frame++) {
				if (frame <= maxFrame) {
					NbtCompound nbt = itemEntity.getStack().getOrCreateNbt();
					nbt.putInt("CustomModelData", frame);
					itemEntity.getStack().setNbt(nbt);
				}
			}
			onFinish.run();
		});
	}

	public static void setRotation(ItemEntity itemEntity, float pitch, float yaw, float roll) {
		itemEntity.setYaw(yaw);
		itemEntity.setPitch(pitch);
	}
}
