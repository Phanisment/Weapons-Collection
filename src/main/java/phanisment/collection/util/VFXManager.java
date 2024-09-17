package phanisment.collection.util;

import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

import java.lang.reflect.Method;

public class VFXManager {
	public static void spawnVFX(ServerWorld world, ItemStack itemStack, Vec3d pos) {
		ItemDisplayEntity itemDisplayEntity = new ItemDisplayEntity(EntityType.ITEM_DISPLAY, world);
		itemDisplayEntity.setPos(pos.x, pos.y, pos.z);
		setItemStack(itemDisplayEntity, itemStack);
		world.spawnEntity(itemDisplayEntity);
	}
	
	public static void spawnVFXFacingPlayer(ServerWorld world, ItemStack itemStack, Vec3d pos, float yaw) {
		ItemDisplayEntity itemDisplayEntity = new ItemDisplayEntity(EntityType.ITEM_DISPLAY, world);
		itemDisplayEntity.setPos(pos.x, pos.y, pos.z);
		itemDisplayEntity.setYaw(yaw);
		setItemStack(itemDisplayEntity, itemStack);
		world.spawnEntity(itemDisplayEntity);
	}

	private static void setItemStack(ItemDisplayEntity itemDisplayEntity, ItemStack itemStack) {
		try {
			Method setItemStackMethod = ItemDisplayEntity.class.getDeclaredMethod("method_48897", ItemStack.class);
			setItemStackMethod.setAccessible(true);
			setItemStackMethod.invoke(itemDisplayEntity, itemStack);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
