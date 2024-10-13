package phanisment.collection.client.model.base;

import net.minecraft.util.Identifier;

import software.bernie.geckolib.model.DefaultedEntityGeoModel;

import phanisment.collection.common.entity.base.EffectEntity;
import phanisment.collection.Weapons;

public class EffectModel extends DefaultedEntityGeoModel<EffectEntity> {
	private final Identifier model;
	private final Identifier texture;
	private final Identifier animation;

	public EffectModel(Identifier model, Identifier texture, Identifier animation) {
		this.model = model;
		this.texture = texture;
		this.animation = animation;
	}

	@Override
	public Identifier getModelResource(EffectModel model) {
		return model;
	}

	@Override
	public Identifier getTextureResource(EffectModel texture) {
		return texture;
	}

	@Override
	public Identifier getAnimationResource(EffectModel animation) {
		return animation;
	}
}