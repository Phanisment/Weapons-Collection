package phanisment.collection.libs;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class VFX {
	public static ItemDisplayEntity createItemDisplay(ServerWorld world, ItemStack itemStack, Vec3d position) {
		CustomItemDisplayEntity itemDisplay = new CustomItemDisplayEntity(EntityType.ITEM_DISPLAY, world);
		itemDisplay.setPos(position.x, position.y, position.z);
		
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
					ItemStack itemStack = itemDisplay.getStack();
					NbtCompound nbt = itemStack.getOrCreateNbt();
					nbt.putInt("CustomModelData", frame);
					itemStack.setNbt(nbt);
					itemDisplay.setStack(itemStack);
					Thread.sleep(ticksPerFrame * 50);
				}
				onFinish.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	public static class CustomItemDisplayEntity extends ItemDisplayEntity {
		public CustomItemDisplayEntity(EntityType<?> type, ServerWorld world) {
			super(type, world);
		}

		public void setCustomData(NbtCompound nbt) {
			this.readCustomDataFromNbt(nbt);
		}
	}
}
