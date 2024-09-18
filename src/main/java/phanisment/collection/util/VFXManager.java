package phanisment.collection.util;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.nbt.NbtCompound;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.UUID;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

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
		itemDisplayEntity.setScale(2.0F, 2.0F, 2.0F);
		setItemStack(itemDisplayEntity, itemStack);
		world.spawnEntity(itemDisplayEntity);
		customModelDataMap.put(itemDisplayEntity.getUuid(), 1);
	}

	public static void registerCustomModelDataUpdater() {
		ServerTickEvents.END_WORLD_TICK.register(serverWorld -> {
			List<UUID> toRemove = new ArrayList<>();
			for (UUID uuid : customModelDataMap.keySet()) {
				ItemDisplayEntity itemDisplayEntity = (ItemDisplayEntity) serverWorld.getEntity(uuid);
				if (itemDisplayEntity != null) {
					int currentModelData = customModelDataMap.get(uuid);
					if (currentModelData <= 7) {
						setCustomModelData(itemDisplayEntity, getItemStack(itemDisplayEntity), currentModelData);
						int newModelData = currentModelData + 1;
						if (newModelData > 7) {
							toRemove.add(uuid);
							itemDisplayEntity.discard();
						} else {
							customModelDataMap.put(uuid, newModelData);
						}
					}
				}
			}
			for (UUID uuid : toRemove) {
				customModelDataMap.remove(uuid);
			}
		});
	}

	private static void setCustomModelData(ItemDisplayEntity entity, ItemStack stack, int customModelData) {
		if (!stack.isEmpty()) {
			NbtCompound entityNbt = new NbtCompound();
			writeCustomDataToNbt(entity, entityNbt);
			entityNbt.putInt("CustomModelData", customModelData);
			readCustomDataFromNbt(entity, entityNbt);
			stack.getOrCreateNbt().putInt("CustomModelData", customModelData);
			setItemStack(entity, stack);
		}
	}

	// Reflection 
	private static void setItemStack(ItemDisplayEntity display, ItemStack item) {
		try {
			Method method = ItemDisplayEntity.class.getDeclaredMethod("method_48897", ItemStack.class);
			method.setAccessible(true);
			method.invoke(display, item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ItemStack getItemStack(ItemDisplayEntity display) {
		try {
			Method method = ItemDisplayEntity.class.getDeclaredMethod("method_48900");
			method.setAccessible(true);
			return (ItemStack) method.invoke(display);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ItemStack.EMPTY;
	}
	
	private static void readCustomDataFromNbt(ItemDisplayEntity display, NbtCompound nbt) {
		try {
			Method method = ItemDisplayEntity.class.getDeclaredMethod("method_5749", NbtCompound.class);
			method.setAccessible(true);
			method.invoke(display, nbt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void writeCustomDataToNbt(ItemDisplayEntity display, NbtCompound nbt) {
		try {
			Method method = ItemDisplayEntity.class.getDeclaredMethod("method_5652", NbtCompound.class);
			method.setAccessible(true);
			method.invoke(display, nbt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
