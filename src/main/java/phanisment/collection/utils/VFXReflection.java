import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public class VFXReflection {

	public static ItemStack getItemStack(Object itemDisplayEntity) {
		try {
			Field itemStackField = itemDisplayEntity.getClass().getDeclaredField("itemStack");
			itemStackField.setAccessible(true);
			return (ItemStack) itemStackField.get(itemDisplayEntity);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void setItemStack(Object itemDisplayEntity, ItemStack stack) {
		try {
			Field itemStackField = itemDisplayEntity.getClass().getDeclaredField("itemStack");
			itemStackField.setAccessible(true);
			itemStackField.set(itemDisplayEntity, stack);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readCustomDataFromNbt(Object itemDisplayEntity, NbtCompound nbt) {
		try {
			Method readCustomDataMethod = itemDisplayEntity.getClass().getDeclaredMethod("readCustomDataFromNbt", NbtCompound.class);
			readCustomDataMethod.setAccessible(true);
			readCustomDataMethod.invoke(itemDisplayEntity, nbt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeCustomDataToNbt(Object itemDisplayEntity, NbtCompound nbt) {
		try {
			Method writeCustomDataMethod = itemDisplayEntity.getClass().getDeclaredMethod("writeCustomDataToNbt", NbtCompound.class);
			writeCustomDataMethod.setAccessible(true);
			writeCustomDataMethod.invoke(itemDisplayEntity, nbt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}