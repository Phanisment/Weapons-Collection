package phanisment.collection.mixin;

import net.minecraft.entity.decoration.DisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(DisplayEntity.ItemDisplayEntity.class)
public class VFXEntityMixin {

	@Shadow
	private ItemStack itemStack;

	@Shadow
	private void setItemStack(ItemStack stack) {
		// Shadow method to set item stack
	}

	@Shadow
	private void readCustomDataFromNbt(NbtCompound nbt) {
		// Shadow method to read custom data
	}

	@Shadow
	private void writeCustomDataToNbt(NbtCompound nbt) {
		// Shadow method to write custom data
	}

	public void setCustomData(NbtCompound nbt) {
		readCustomDataFromNbt(nbt);
	}

	public NbtCompound getCustomData() {
		NbtCompound nbt = new NbtCompound();
		writeCustomDataToNbt(nbt);
		return nbt;
	}
}
