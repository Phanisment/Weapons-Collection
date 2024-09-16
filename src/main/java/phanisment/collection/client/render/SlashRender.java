package phanisment.collection.client.render;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import phanisment.collection.Weapons;
import phanisment.collection.entity.SlashEntity;
import phanisment.collection.client.model.SlashModel

public class SlashRender extends MobEntityRenderer<SlashEntity, SlashModel> {

	public SlashRender(EntityRendererFactory.Context context) {
		super(context, new SlashModel(context.getPart(WeaponsClient.SLASH_LAYER)), 0.5f);
	}

	@Override
	public Identifier getTexture(SlashEntity entity) {
		return new Identifier(Weapons.MOD_ID, "textures/vfx/slash.png");
	}
}