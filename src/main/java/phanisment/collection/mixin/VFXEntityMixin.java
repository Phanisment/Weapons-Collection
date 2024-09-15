package phanisment.collection.mixin;

import net.minecraft.entity.decoration.DisplayEntity.ItemDisplayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemDisplayEntity.class)
public class VFXEntityMixin {

	private int tickCounter = 0;
	private final int maxFrame = 7;  // Jumlah frame animasi
	private final int ticksPerFrame = 10; // Durasi per frame dalam tick

	@Inject(method = "tick", at = @At("HEAD"))
	public void onTick(CallbackInfo ci) {
		ItemDisplayEntity itemDisplay = (ItemDisplayEntity) (Object) this;

		// Setiap beberapa tick, kita ubah CustomModelData untuk membuat animasi
		if (tickCounter++ % ticksPerFrame == 0) {
			// Dapatkan ItemStack dari item display
			ItemStack itemStack = itemDisplay.getStack();
			NbtCompound nbt = itemStack.getOrCreateNbt();

			// Ubah CustomModelData untuk frame animasi
			int currentFrame = (tickCounter / ticksPerFrame) % (maxFrame + 1);
			nbt.putInt("CustomModelData", currentFrame);
			itemStack.setNbt(nbt);

			// Set ItemStack kembali ke item display setelah diupdate
			itemDisplay.setStack(itemStack);
		}
	}
}
