package phanisment.legendary.vfx.render;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.util.math.Vec3f;

import phanisment.legendary.vfx.AnimatedSlashEntity;

public class AnimatedSlashRender extends EntityRenderer<AnimatedSlashEntity> {
	private static final Identifier[] SLASH_TEXTURES = {
		new Identifier("legendary_weapons", "textures/vfx/slash_1.png"),
		new Identifier("legendary_weapons", "textures/vfx/slash_2.png"),
		new Identifier("legendary_weapons", "textures/vfx/slash_3.png"),
		new Identifier("legendary_weapons", "textures/vfx/slash_4.png"),
		new Identifier("legendary_weapons", "textures/vfx/slash_5.png"),
		new Identifier("legendary_weapons", "textures/vfx/slash_6.png")
	};
	
	public AnimatedSlashRenderer(EntityRendererFactory.Context context) {
		super(context);
	}
	
	@Override
	public void render(AnimatedSlashEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
		int frame = (entity.animationTick / 5) % SLASH_TEXTURES.length;
		Identifier texture = SLASH_TEXTURES[frame];
		
		matrices.push();
		matrices.translate(0, 0.5, 0);
		matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(yaw));
		
		MinecraftClient.getInstance().getItemRenderer().renderItem(
			entity.getStack(), 
			ModelTransformation.Mode.GROUND, 
			light, 
			OverlayTexture.DEFAULT_UV, 
			matrices, 
			vertexConsumers, 
			entity.getId()
		);
		matrices.pop();
		
		super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
	}
	
	@Override
	public Identifier getTexture(AnimatedSlashEntity entity) {
		return SLASH_TEXTURES[0];
	}
}