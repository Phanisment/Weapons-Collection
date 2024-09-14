package phanisment.collection.libs;

import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import phanisment.collection.mixin.VFXEntityMixin;

public class VFX {

	public static ItemDisplayEntity createItemDisplay(ServerWorld world, ItemStack itemStack, Vec3d position) {
		ItemDisplayEntity itemDisplay = new ItemDisplayEntity(world);
		itemDisplay.setPos(position.x, position.y, position.z);

		// Gunakan accessor untuk mengatur itemStack
		((VFXEntityMixin) itemDisplay).setItemStack(itemStack);

		NbtCompound nbt = new NbtCompound();
		itemStack.writeNbt(nbt);
		((VFXEntityMixin) itemDisplay).invokeReadCustomDataFromNbt(nbt);

		world.spawnEntity(itemDisplay);
		return itemDisplay;
	}

	public static void animateCustomModelData(ItemDisplayEntity itemDisplay, int maxFrame, int ticksPerFrame, Runnable onFinish) {
		new Thread(() -> {
			try {
				for (int frame = 1; frame <= maxFrame; frame++) {
					ItemStack itemStack = ((VFXEntityMixin) itemDisplay).getItemStack();
					NbtCompound nbt = itemStack.getOrCreateNbt();
					nbt.putInt("CustomModelData", frame);
					itemStack.setNbt(nbt);
					((VFXEntityMixin) itemDisplay).setItemStack(itemStack);

					Thread.sleep(ticksPerFrame * 50);
				}
				onFinish.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
