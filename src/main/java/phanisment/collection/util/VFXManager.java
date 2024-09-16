package phanisment.collection.util;

import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class VFXManager {
	public static void spawnVFX(ServerWorld world, BlockPos pos, ItemStack itemStack) {
		ItemDisplayEntity itemDisplayEntity = new ItemDisplayEntity(world, pos.getX(), pos.getY(), pos.getZ());
		itemDisplayEntity.setStack(itemStack);
		world.spawnEntity(itemDisplayEntity);
	}
}