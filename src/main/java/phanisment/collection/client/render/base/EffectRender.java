package phanisment.collection.client.render.base;

import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;

import software.bernie.geckolib.renderer.GeoEntityRenderer;

import phanisment.collection.common.entity.base.EffectEntity;
import phanisment.collection.client.model.base.EffectModel;

public class EffectRender extends GeoEntityRenderer<EffectEntity> {
	private Identifier[] texture;
	
	public EffectRender(EntityRendererFactory.Context render, Identifier model, Identifier[] texture, Identifier animation) {
		super(render, new EffectModel(model, texture, animation));
		this.texture = texture;
	}
	
	@Override
	public Identifier[] getTextureLocation(EffectEntity entity) {
		int frame = entity.getFrame();
		int maxFrame = texture;
		if (frame > texture.length) {
			frame = texture.length;
		}
		return texture[frame];
	}
}