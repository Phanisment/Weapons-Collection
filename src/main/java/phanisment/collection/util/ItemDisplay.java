package phanisment.collection.util;

import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.item.ItemStack;

import java.lang.reflect.Method;

public class ItemDisplay {
	public static void writeCustomDataToNbt(ItemDisplayEntity itemDisplayEntity, NbtCompound nbtCompound) {
		try {
			Method writeMethod = ItemDisplayEntity.class.getDeclaredMethod("writeCustomDataToNbt", NbtCompound.class);
			writeMethod.setAccessible(true);
			writeMethod.invoke(itemDisplayEntity, nbtCompound);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readCustomDataFromNbt(ItemDisplayEntity itemDisplayEntity, NbtCompound nbtCompound) {
		try {
			Method readMethod = ItemDisplayEntity.class.getDeclaredMethod("readCustomDataFromNbt", NbtCompound.class);
			readMethod.setAccessible(true);
			readMethod.invoke(itemDisplayEntity, nbtCompound);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setItemStack(ItemDisplayEntity itemDisplayEntity, ItemStack itemStack) {
		try {
			Method setItemStackMethod = ItemDisplayEntity.class.getDeclaredMethod("setItemStack", ItemStack.class);
			setItemStackMethod.setAccessible(true);
			setItemStackMethod.invoke(itemDisplayEntity, itemStack);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ItemStack getItemStack(ItemDisplayEntity itemDisplayEntity) {
		try {
			Method getItemStackMethod = ItemDisplayEntity.class.getDeclaredMethod("getItemStack");
			getItemStackMethod.setAccessible(true);
			return (ItemStack) getItemStackMethod.invoke(itemDisplayEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}