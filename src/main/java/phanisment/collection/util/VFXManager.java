package phanisment.collection.util;

import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class VFXManager {
	public static void spawnVFX(ServerWorld world, ItemStack itemStack) {
		ItemDisplayEntity itemDisplayEntity = new ItemDisplayEntity(EntityType.ITEM_DISPLAY, world);
		itemDisplayEntity.setItemStack(itemStack);
		world.spawnEntity(itemDisplayEntity);
	}
}