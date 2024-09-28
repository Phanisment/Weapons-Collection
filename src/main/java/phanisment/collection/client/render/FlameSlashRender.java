package phanisment.collection.client.render;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import phanisment.collection.Weapons;
import phanisment.collection.client.RegisterModelLayers;
import phanisment.collection.client.model.FlameSlashModel;
import phanisment.collection.entity.FlameSlashEntity;

public class FlameSlashRender extends MobEntityRenderer<FlameSlashEntity, FlameSlashModel> {
	private static final Identifier[] TEXTURE = {
		new Identifier(Weapons.MOD_ID, "textures/entity/hellfire_talon/slash_1.png"),
		new Identifier(Weapons.MOD_ID, "textures/entity/hellfire_talon/slash_2.png"),
		new Identifier(Weapons.MOD_ID, "textures/entity/hellfire_talon/slash_3.png"),
		new Identifier(Weapons.MOD_ID, "textures/entity/hellfire_talon/slash_4.png"),
		new Identifier(Weapons.MOD_ID, "textures/entity/hellfire_talon/slash_5.png"),
		new Identifier(Weapons.MOD_ID, "textures/entity/hellfire_talon/slash_6.png"),
		new Identifier(Weapons.MOD_ID, "textures/entity/hellfire_talon/slash_7.png")
	};

	public FlameSlashRender(EntityRendererFactory.Context context) {
		super(context, new TesModel(context.getPart(RegisterModelLayers.TES)), 0.6f);
	}

	@Override
	public Identifier getTexture(TesEntity entity) {
		int tick = entity.getTickCounter();
		if(tick > 6) {
			tick = 6;
		}
		return TEXTURE[tick];
	}

	@Override
	public void render(FlameSlashEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
		super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
	}
}