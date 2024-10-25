package phanisment.collection.client.render.base;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.RenderLayer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.util.math.RotationAxis;

import org.jetbrains.annotations.Nullable;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.model.GeoModel;

import phanisment.collection.common.entity.base.EffectEntity;

public class EffectRender extends GeoEntityRenderer<EffectEntity> {
	private Identifier model;
	private Identifier[] textures;
	private Identifier animation;
	
	public EffectRender(EntityRendererFactory.Context render, Identifier model, Identifier[] textures, Identifier animation) {
		super(render, new GeoModel<EffectEntity>() {
			@Override
			public Identifier getModelResource(EffectEntity entity) {
				return model;
			}
			
			@Override
			public Identifier getTextureResource(EffectEntity entity) {
				int frame = entity.getFrame();
				int maxFrame = textures.length - 1;
				if (frame >= maxFrame) {
					frame = maxFrame;
				}
				return textures[frame];
			}
			
			@Override
			public Identifier getAnimationResource(EffectEntity entity) {
				return animation;
			}
		});
		this.model = model;
		this.textures = textures;
		this.animation = animation;
	}
	
	@Override
	public void render(EffectEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
		int maxLight = 15728880;
		
		poseStack.push();
		poseStack.scale(entity.getSizeX(), entity.getSizeY(), entity.getSizeZ());
		
		poseStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(entity.getRotationX()));
		poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entity.getRotationY()));
		poseStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(entity.getRotationZ()));
		
		super.render(entity, entityYaw, partialTick, poseStack, bufferSource, maxLight);
		poseStack.pop();
	}
}