package phanisment.collection.client.render;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import phanisment.collection.Weapons;
import phanisment.collection.client.RegisterModelLayers;
import phanisment.collection.client.model.BlazeLeapModel;
import phanisment.collection.entity.BlazeLeapEntity;

public class BlazeLeapRender extends MobEntityRenderer<BlazeLeapEntity, BlazeLeapModel> {
	private static final Identifier[] TEXTURE = {
		new Identifier(Weapons.MOD_ID, "textures/entity/hellfire_talon/blaze_leap/blaze_leap_1.png"),
		new Identifier(Weapons.MOD_ID, "textures/entity/hellfire_talon/blaze_leap/blaze_leap_2.png"),
		new Identifier(Weapons.MOD_ID, "textures/entity/hellfire_talon/blaze_leap/blaze_leap_3.png"),
		new Identifier(Weapons.MOD_ID, "textures/entity/hellfire_talon/blaze_leap/blaze_leap_4.png"),
		new Identifier(Weapons.MOD_ID, "textures/entity/hellfire_talon/blaze_leap/blaze_leap_5.png"),
		new Identifier(Weapons.MOD_ID, "textures/entity/hellfire_talon/blaze_leap/blaze_leap_6.png"),
		new Identifier(Weapons.MOD_ID, "textures/entity/hellfire_talon/blaze_leap/blaze_leap_7.png")
	};

	public BlazeLeapRender(EntityRendererFactory.Context context) {
		super(context, new FlameSlashModel(context.getPart(RegisterModelLayers.BLAZE_LEAP)), 0.6f);
	}

	@Override
	public Identifier getTexture(BlazeLeapEntity entity) {
		int tick = entity.getTickCounter();
		if(tick > 6) {
			tick = 6;
		}
		return TEXTURE[tick];
	}

	@Override
	public void render(BlazeLeapEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
		super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
	}
}