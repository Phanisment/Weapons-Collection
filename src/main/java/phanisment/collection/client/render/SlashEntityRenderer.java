package phanisment.collection.client.renderer;

import phanisment.collection.entity.SlashEntity;
import phanisment.collection.client.model.SlashModel;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.EntityModels;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class SlashEntityRenderer extends EntityRenderer<SlashEntity> {
	private static final Identifier[] TEXTURES = {
		new Identifier("phanisment", "textures/vfx/slash/slash_1.png"),
		new Identifier("phanisment", "textures/vfx/slash/slash_2.png"),
	};

	private final SlashModel model;

	public SlashEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
		this.model = new SlashModel(context.getPart(EntityModelLayers.PLAYER_HEAD));
	}

	@Override
	public Identifier getTexture(SlashEntity entity) {
		int frame = entity.animationFrame % TEXTURES.length;
		return TEXTURES[frame];
	}

	@Override
	public void render(SlashEntity entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light) {
		super.render(entity, yaw, tickDelta, matrixStack, vertexConsumerProvider, light);

		VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntityCutoutNoCull(getTexture(entity)));
		model.render(matrixStack, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
	}
}
