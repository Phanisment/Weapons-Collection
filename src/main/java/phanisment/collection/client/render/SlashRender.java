package phanisment.collection.client.render;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import phanisment.collection.client.model.ModelLayer;
import phanisment.collection.client.model.SlashModel;
import phanisment.collection.entity.SlashEntity;
import phanisment.collection.Weapons;

public class SlashRender extends EntityRenderer<SlashEntity> {
	private static final Identifier TEXTURE = new Identifier(Weapons.MOD_ID, "textures/vfx/slash.png");
	private final SlashModel<SlashEntity> model;

	public SlashRender(EntityRendererFactory.Context context) {
		super(context);
		this.model = new SlashModel<>(context.getPart(ModelLayer.SLASH));
	}

	@Override
	public Identifier getTexture(SlashEntity entity) {
		return TEXTURE;
	}

	@Override
	public void render(SlashEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
		model.render(matrices, vertexConsumers.getBuffer(model.getLayer(TEXTURE)), light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
		super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
	}
}
