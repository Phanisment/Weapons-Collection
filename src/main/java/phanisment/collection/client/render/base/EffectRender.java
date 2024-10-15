package phanisment.collection.client.render.base;

import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.EntityRendererFactory;

import software.bernie.geckolib.renderer.GeoEntityRenderer;

import phanisment.collection.common.entity.base.EffectEntity;
import phanisment.collection.client.model.base.EffectModel;

public class EffectRender extends GeoEntityRenderer<EffectEntity> {
	public EffectRender(EntityRendererFactory.Context render, Identifier model, Identifier texture, Identifier animation) {
		super(render, new EffectModel(model, texture, animation));
	}
}