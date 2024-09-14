package phanisment.collection.libs;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class VFX {
	public static DisplayEntity.ItemDisplayEntity createItemDisplay(ServerWorld world, ItemStack itemStack, Vec3d position) {
		DisplayEntity.ItemDisplayEntity itemDisplay = new DisplayEntity.ItemDisplayEntity(EntityType.ITEM_DISPLAY, world);
		itemDisplay.setPos(position.x, position.y, position.z);
		NbtCompound nbt = new NbtCompound();
		itemStack.writeNbt(nbt);
		itemDisplay.setCustomData(nbt);
		world.spawnEntity(itemDisplay);
		return itemDisplay;
	}

	public static void animateCustomModelData(DisplayEntity.ItemDisplayEntity itemDisplay, int maxFrame, int ticksPerFrame, Runnable onFinish) {
		new Thread(() -> {
			try {
				for (int frame = 1; frame <= maxFrame; frame++) {
					NbtCompound nbt = itemDisplay.getCustomData();
					nbt.putInt("CustomModelData", frame);
					itemDisplay.setCustomData(nbt);
					Thread.sleep(ticksPerFrame * 50);
				}
				onFinish.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
