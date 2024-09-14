package phanisment.collection.libs;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class VFX {
	public static ItemDisplayEntity createItemDisplay(ServerWorld world, ItemStack itemStack, Vec3d position) {
		ItemDisplayEntity itemDisplay = new ItemDisplayEntity(world, position);
		itemDisplay.setPos(position.x, position.y, position.z);
		NbtCompound nbt = new NbtCompound();
		itemStack.writeNbt(nbt);
		itemDisplay.getItemDisplayData().setData(nbt);
		world.spawnEntity(itemDisplay);
		return itemDisplay;
	}
}
