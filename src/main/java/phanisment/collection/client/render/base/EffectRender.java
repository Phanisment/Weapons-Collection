package phanisment.collection.client.render.base;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import phanisment.collection.common.entity.base.EffectEntity

public class EffectRender extends GeoEntityRenderer<EffectEntity> {
	private final ResourceLocation model;
	private final ResourceLocation texture;
	private final ResourceLocation animation;

	public EffectRender(EntityRendererProvider.Context render, ResourceLocation model, ResourceLocation texture, ResourceLocation animation) {
		super(render, new EffectModel(model, texture, animation));
		this.model = model;
		this.texture = texture;
		this.animation = animation;
	}

	public ResourceLocation getModelResource(EffectRender model) {
		return model;
	}

	public ResourceLocation getTextureResource(EffectRender texture) {
		return texture;
	}

	public void setTextureResource(ResourceLocation texture) {
		this.texture = texture;
	}

	public ResourceLocation getAnimationResource(EffectRender animation) {
		return animation;
	}
}