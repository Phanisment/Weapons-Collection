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
	public static ItemStack createItem(Items item, int model) {
		ItemStack itemStack = new ItemStack(item);
		NbtCompound nbt = new NbtCompound();
		nbt.putInt("CustomModelData", model);
		itemStack.setNbt(nbt);
		return itemStack;
	}
	
	public static void spawnItemDisplay(ServerWorld world, BlockPos pos) {
		ItemStack item = this.createCustomItem();
		ItemDisplayEntity displayEntity = new ItemDisplayEntity(EntityType.ITEM_DISPLAY, world);
		displayEntity.updatePosition(pos.getX(), pos.getY(), pos.getZ());
		displayEntity.setStack(item);
		world.spawnEntity(displayEntity);
	}
}