package phanisment.collection.util;

import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.nbt.NbtCompound;

import java.lang.reflect.Method;

public class ItemDisplayEntityUtil {
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
}