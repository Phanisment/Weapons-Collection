package phanisment.collection.client.model.base;

import net.minecraft.util.Identifier;

import software.bernie.geckolib.model.GeoModel;

import phanisment.collection.common.entity.base.EffectEntity;
import phanisment.collection.Weapons;

public class EffectModel extends GeoModel<EffectEntity> {
	private final Identifier model;
	private final Identifier texture;
	private final Identifier animation;

	public EffectModel(Identifier model, Identifier texture, Identifier animation) {
		this.model = model;
		this.texture = texture;
		this.animation = animation;
	}

	@Override
	public Identifier getModelResource(EffectEntity model) {
		return this.model;
	}

	@Override
	public Identifier getTextureResource(EffectEntity texture) {
		return this.texture;
	}

	@Override
	public Identifier getAnimationResource(EffectEntity animation) {
		return this.animation;
	}
}