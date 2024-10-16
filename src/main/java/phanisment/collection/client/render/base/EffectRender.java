package phanisment.collection.client.render.base;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.VertexConsumer;
import com.mojang.blaze3d.systems.RenderSystem;

import org.jetbrains.annotations.Nullable;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.model.GeoModel;

import phanisment.collection.common.entity.base.EffectEntity;
import phanisment.collection.Weapons;

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
	public void defaultRender(PoseStack poseStack, EffectEntity entity, MultiBufferSource bufferSource, @Nullable RenderType renderType, @Nullable VertexConsumer buffer, float yaw, float partialTick, int packedLight) {
		super.defaultRender(poseStack, entity, bufferSource, renderType, buffer, yaw, partialTick, packedLight);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		VertexConsumer glowingBuffer = bufferSource.getBuffer(RenderType.getTranslucent());
		super.defaultRender(poseStack, entity, glowingBuffer, null, yaw, partialTick, packedLight);
		RenderSystem.disableBlend();
	}
}
