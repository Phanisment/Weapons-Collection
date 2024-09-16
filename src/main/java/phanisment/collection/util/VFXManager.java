package phanisment.collection.util;

import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import phanisment.collection.util.ItemDisplay;

public class VFXManager {
	public static void spawnVFX(ServerWorld world, ItemStack itemStack, Vec3d pos) {
		ItemDisplayEntity itemDisplayEntity = new ItemDisplayEntity(EntityType.ITEM_DISPLAY, world);
		itemDisplayEntity.setPos(pos.x, pos.y, pos.z);
		ItemDisplay.setItemStack(itemDisplayEntity, itemStack);
		world.spawnEntity(itemDisplayEntity);
	}
}