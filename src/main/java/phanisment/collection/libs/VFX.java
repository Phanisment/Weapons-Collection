package phanisment.collection.libs;

import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import java.lang.reflect.Method;

public class VFX {

	public static void summonAndModifyItemDisplay(ServerWorld world, BlockPos pos) {
		ItemDisplayEntity displayEntity = new ItemDisplayEntity(EntityType.ITEM_DISPLAY, world);
		displayEntity.updatePosition(pos.getX(), pos.getY() + 1, pos.getZ());
		world.spawnEntity(displayEntity);
		modifyItemDisplayNBT(displayEntity);
	}

	public static void modifyItemDisplayNBT(ItemDisplayEntity displayEntity) {
		try {
			ItemStack customItemStack = createCustomItem();
			Method setItemStackMethod = ItemDisplayEntity.class.getDeclaredMethod("setItemStack", ItemStack.class);
			setItemStackMethod.setAccessible(true);
			setItemStackMethod.invoke(displayEntity, customItemStack);
			NbtCompound entityNbt = new NbtCompound();
			entityNbt.putFloat("Rotation", 45.0F);
			entityNbt.putFloat("Scale", 2.0F);
			displayEntity.readCustomDataFromNbt(entityNbt);
			System.out.println("Berhasil mengubah NBT dari Item Display!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ItemStack createCustomItem() {
		ItemStack itemStack = new ItemStack(Items.DIAMOND_SWORD);
		NbtCompound nbt = new NbtCompound();
		nbt.putInt("CustomModelData", 12345);
		itemStack.setNbt(nbt);
		return itemStack;
	}
}

}