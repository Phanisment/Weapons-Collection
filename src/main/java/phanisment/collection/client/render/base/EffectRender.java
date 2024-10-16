package phanisment.collection.client.render.base;

import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;

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
				int maxFrame = textures.length;
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
}