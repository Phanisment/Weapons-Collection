package phanisment.collection.mixin;

import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ItemDisplayEntity.class)
public interface VFXEntityMixin {

	@Accessor("itemStack")
	ItemStack getItemStack();

	@Accessor("itemStack")
	void setItemStack(ItemStack stack);

	@Invoker("readCustomDataFromNbt")
	void invokeReadCustomDataFromNbt(NbtCompound nbt);

	@Invoker("writeCustomDataToNbt")
	void invokeWriteCustomDataToNbt(NbtCompound nbt);
}
