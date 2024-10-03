package phanisment.collection.common.event;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

public class PlayerInteraction {
	public static void register() {
		UseItemCallback.EVENT.register((player, world, hand) -> {
			if (player.isUsingItem()) {
				player.sendMessage(Text.of("You left-clicked in the air!"), false);
			}
			return ActionResult.PASS;
		});
	}
}