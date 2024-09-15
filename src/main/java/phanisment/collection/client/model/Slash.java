package phanisment.collection.client.model;

import phanisment.collection.entity.SlashVFXEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

public class Slash extends EntityModel<SlashVFXEntity> {
	private final ModelPart Head;

	public Slash(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("Head", 
			ModelPartBuilder.create()
				.uv(0, 0)
				.cuboid(-16.0F, 0.0F, -16.0F, 32.0F, 0.0F, 32.0F, new Dilation(0.0F)), 
			ModelTransform.pivot(0.0F, 24.0F, 0.0F)
		);
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(SlashVFXEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}