package phanisment.collection.client.model.base;

import net.minecraft.resources.ResourceLocation;

import software.bernie.geckolib.model.DefaultedEntityGeoModel;

import phanisment.collection.common.entity.base.EffectEntity;
import phanisment.collection.Weapons;

public class EffectModel extends DefaultedEntityGeoModel<EffectEntity> {
	private final ResourceLocation model;
	private final ResourceLocation texture;
	private final ResourceLocation animation;

	public EffectModel(ResourceLocation model, ResourceLocation texture, ResourceLocation animation) {
		this.model = model;
		this.texture = texture;
		this.animation = animation;
	}

	@Override
	public ResourceLocation getModelResource(EffectModel model) {
		return model;
	}

	@Override
	public ResourceLocation getTextureResource(EffectModel texture) {
		return texture;
	}

	@Override
	public ResourceLocation getAnimationResource(EffectModel animation) {
		return animation;
	}
}