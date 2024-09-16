package phanisment.collection.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

import phanisment.collection.client.model.SlashModel;
import phanisment.collection.entity.SlashEntity;
import phanisment.collection.Weapons;

public class Weapons implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModEntityRenderers.registerEntityRenderers();
	}
}
