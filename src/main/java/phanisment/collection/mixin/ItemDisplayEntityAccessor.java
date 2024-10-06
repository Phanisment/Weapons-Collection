package phanisment.collection.mixin;

import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemDisplayEntity.class)
public interface ItemDisplayEntityAccessor {
	@Accessor
	ItemStack getItemStack();
	@Accessor
	ItemStack setItemStack(ItemStack item);
}