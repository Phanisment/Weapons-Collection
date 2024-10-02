package phanisment.collection.common.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

import phanisment.collection.common.skill.*;

public class ClickEvent {
	public static void register() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			MinecraftClient mc = MinecraftClient.getInstance();
			if(mc.player != null && mc.world != null) {
				if(mc.options.attackKey.isPressed()) {
					leftClick(mc);
				}
				if(mc.options.useKey.isPressed()) {
					rightClick(mc);
				}
				if(mc.options.sneakKey.isPressed()) {
					sneak(mc);
				}
			}
		});
	}
	
	private static void leftClick(MinecraftClient mc) {
		HellfireTalonSkill.slashSkill(mc);
	}
	private static void rightClick(MinecraftClient mc) {
		
	}
	private static void sneak(MinecraftClient mc) {
		
	}
}