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
		itemDisplay.setCustomData(nbt);  // Memanggil metode dari subclass
		
		world.spawnEntity(itemDisplay);
		return itemDisplay;
	}

	// Subclass untuk mengakses metode protected
	public static class CustomItemDisplayEntity extends ItemDisplayEntity {
		public CustomItemDisplayEntity(EntityType<?> type, ServerWorld world) {
			super(type, world);
		}

		public void setCustomData(NbtCompound nbt) {
			this.readCustomDataFromNbt(nbt);  // Sekarang bisa mengakses metode protected
		}
	}
}
