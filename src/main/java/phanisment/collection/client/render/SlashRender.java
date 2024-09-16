package phanisment.collection.client.render;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayerRegistry;
import net.minecraft.client.render.OverlayTexture;

import phanisment.collection.Weapons;
import phanisment.collection.entity.SlashEntity;
import phanisment.collection.client.model.SlashModel;
import phanisment.collection.client.WeaponsClient;

public class SlashRender extends EntityRenderer<SlashEntity> {

	private final SlashModel model;

	public SlashRender(EntityRendererFactory.Context context) {
		super(context);
		this.model = new SlashModel(context.getPart(WeaponsClient.SLASH_LAYER));
	}

	@Override
	public Identifier getTexture(SlashEntity entity) {
		return new Identifier(Weapons.MOD_ID, "textures/vfx/slash.png");
	}

	@Override
	public void render(SlashEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
		this.model.setAngles(entity, 0, 0, 0, yaw, 0);
		this.model.render(matrices, vertexConsumers.getBuffer(this.model.getLayer(getTexture(entity))), light, OverlayTexture.DEFAULT_UV);
	}
}
