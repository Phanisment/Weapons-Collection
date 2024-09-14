package phanisment.collection.mixin;

import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ItemDisplayEntity.class)
public interface VFXEntityMixin {

	@Accessor("method_48900") // Sesuaikan dengan nama obfuscated yang benar
	ItemStack getItemStack();

	@Accessor("method_48897")
	void setItemStack(ItemStack stack);

	@Invoker("method_5749") // Sesuaikan dengan nama obfuscated untuk readCustomDataFromNbt
	void readCustomDataFromNbt(NbtCompound nbt);

	@Invoker("method_5652") // Sesuaikan dengan nama obfuscated untuk writeCustomDataToNbt
	void writeCustomDataToNbt(NbtCompound nbt);
}