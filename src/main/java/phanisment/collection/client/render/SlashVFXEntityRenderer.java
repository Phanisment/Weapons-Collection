package com.example.mod.client.renderer;

import com.example.mod.entity.SlashVFXEntity;
import com.example.mod.client.model.Slash;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SlashVFXEntityRenderer extends EntityRenderer<SlashVFXEntity> {
	private static final Identifier[] TEXTURES = {
		new Identifier("phanisment", "textures/vfx/slash_1.png"),
		new Identifier("phanisment", "textures/vfx/slash_2.png"),
		new Identifier("phanisment", "textures/vfx/slash_3.png"),
		new Identifier("phanisment", "textures/vfx/slash_4.png"),
		new Identifier("phanisment", "textures/vfx/slash_5.png"),
		new Identifier("phanisment", "textures/vfx/slash_6.png"),
		new Identifier("phanisment", "textures/vfx/slash_7.png"),
		new Identifier("phanisment", "textures/vfx/slash_8.png")
	};

	private final Slash model;
	private static final int FRAME_COUNT = TEXTURES.length;

	public SlashVFXEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
		this.model = new Slash(context.getPart(Slash.getTexturedModelData()));
	}

	@Override
	public void render(SlashVFXEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
		matrices.push();

		int maxLife = 20;
		int lifeTime = maxLife - entity.lifeTime;
		int currentFrame = (lifeTime * FRAME_COUNT) / maxLife;
		currentFrame = Math.min(currentFrame, FRAME_COUNT - 1);
		Identifier currentTexture = TEXTURES[currentFrame];
		VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.model.getLayer(currentTexture));
		this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1, 1, 1, 1);
		matrices.pop();
	}

	@Override
	public Identifier getTexture(SlashVFXEntity entity) {
		return TEXTURES[0];
	}
}
