package phanisment.collection.client.render;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import phanisment.collection.Weapons;
import phanisment.collection.client.RegisterModelLayers;
import phanisment.collection.client.model.TesModel;
import phanisment.collection.entity.TesEntity;

public class TesRender extends MobEntityRenderer<TesEntity, TesModel> {
	private static final Identifier TEXTURE = new Identifier(Weapons.MOD_ID, "textures/entity/tes.png");

	public TesRenderer(EntityRendererFactory.Context context) {
		super(context, new TesModel(context.getPart(RegisterModelLayers.TES)), 0.6f);
	}

	@Override
	public Identifier getTexture(TesEntity entity) {
		return TEXTURE;
	}

	@Override
	public void render(TesEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
		super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
	}
}