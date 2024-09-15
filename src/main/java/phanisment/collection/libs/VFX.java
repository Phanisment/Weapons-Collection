package phanisment.collection.libs;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class VFX {
	public static ItemStack createItem() {
		ItemStack itemStack = new ItemStack(Items.DIAMOND_SWORD);
		NbtCompound nbt = new NbtCompound();
		nbt.putInt("CustomModelData", 1);
		itemStack.setNbt(nbt);
		return itemStack;
	}

	public static void spawnItemDisplay(ServerWorld world, BlockPos pos) {
		ItemStack customItem = createItem();
		ItemDisplayEntity displayEntity = new ItemDisplayEntity(EntityType.ITEM_DISPLAY, world);
		displayEntity.updatePosition(pos.getX(), pos.getY() + 1, pos.getZ());
		displayEntity.setItemStack(customItem);
		world.spawnEntity(displayEntity);
	}
}