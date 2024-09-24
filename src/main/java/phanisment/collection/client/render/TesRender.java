package phanisment.collection.client.render;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import phanisment.collection.entity.TesEntity; 
import phanisment.collection.Weapons;
import phanisment.collection.client.WeaponsClient;
import phanisment.collection.client.model.TesModel;

public class TesRender extends MobEntityRenderer<TesEntity, TesModel<TesEntity>> {
	public static final Identifier TEXTURE = Identifier(Weapons.MOD_ID, "textures/entity/slash.png");
	
	public TesRender(EntityRendererFactory.Context context) {
		super(context, new TesModel<>(context.getPart(WeaponsClient.SLASH_MODEL_LAYER)), 0.6f);
	}

	@Override
	public Identifier getTexture(TesEntity entity) {
		return TEXTURE;
	}

	public void render(TesEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
		super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
	}
}