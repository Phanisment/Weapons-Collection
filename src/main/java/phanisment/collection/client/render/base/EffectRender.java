package phanisment.collection.client.render.base;

import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import phanisment.collection.common.entity.base.EffectEntity;

public class EffectRender extends GeoEntityRenderer<EffectEntity> {
	private final Identifier model;
	private final Identifier texture;
	private final Identifier animation;

	public EffectRender(EntityRendererProvider.Context render, Identifier model, Identifier texture, Identifier animation) {
		super(render, new EffectModel(model, texture, animation));
		this.model = model;
		this.texture = texture;
		this.animation = animation;
	}

	public Identifier getModelResource(EffectRender model) {
		return model;
	}

	public Identifier getTextureResource(EffectRender texture) {
		return texture;
	}

	public void setTextureResource(Identifier texture) {
		this.texture = texture;
	}

	public Identifier getAnimationResource(EffectRender animation) {
		return animation;
	}
}