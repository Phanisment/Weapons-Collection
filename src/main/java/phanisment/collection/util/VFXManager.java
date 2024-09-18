package phanisment.collection.util;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.UUID;

public class VFXManager {
	private static final HashMap<UUID, Integer> customModelDataMap = new HashMap<>();
	
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
		customModelDataMap.put(itemDisplayEntity.getUuid(), 1);
	}

	public static void registerCustomModelDataUpdater() {
		ServerTickEvents.END_WORLD_TICK.register(serverWorld -> {
			customModelDataMap.forEach((uuid, currentModelData) -> {
				ItemDisplayEntity itemDisplayEntity = (ItemDisplayEntity) serverWorld.getEntity(uuid);
				if (itemDisplayEntity != null) {
					ItemStack stack = itemDisplayEntity.getItemStack();
					if (!stack.isEmpty()) {
						stack.getOrCreateNbt().putInt("CustomModelData", currentModelData);
						setItemStack(itemDisplayEntity, itemStack);
						int newModelData = currentModelData + 1;
						if (newModelData > 7) {
							itemDisplayEntity.discard();
							customModelDataMap.remove(uuid);
						} else {
							customModelDataMap.put(uuid, newModelData);
						}
					}
				}
			});
		});
	}

	// Reflection 
	private static void setItemStack(ItemDisplayEntity display, ItemStack item) {
		try {
			Method setItemStackMethod = ItemDisplayEntity.class.getDeclaredMethod("method_48897", ItemStack.class);
			setItemStackMethod.setAccessible(true);
			setItemStackMethod.invoke(display, item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ItemStack getItemStack(ItemDisplayEntity display) {
		try {
			Method getItemStackMethod = ItemDisplayEntity.class.getDeclaredMethod("method_48900");
			getItemStackMethod.setAccessible(true);
			return (ItemStack) getItemStackMethod.invoke(display);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ItemStack.EMPTY;
	}
}
