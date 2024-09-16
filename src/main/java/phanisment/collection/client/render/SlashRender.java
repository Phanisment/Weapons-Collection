package phanisment.collection.client.render;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import phanisment.collection.client.model.ModelLayer
import phanisment.collection.client.model.SlashModel;
import phanisment.collection.entity.SlashEntity;
import phanisment.collection.Weapons;

public class SlashRender extends MobEntityRenderer<SlashEntity, SlashModel<SlashEntity>> {
	private static final Identifier TEXTURE = new Identifier(Weapons.MOD_ID, "textures/vfx/slash.png");

	public PorcupineRenderer(EntityRendererFactory.Context context) {
		super(context, new SlashModel<>(context.getPart(ModelLayer.SLASH)), 0.6f);
	}

	@Override
	public Identifier getTexture(SlashEntity entity) {
		return TEXTURE;
	}

	@Override
	public void render(SlashEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
		super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
	}
}