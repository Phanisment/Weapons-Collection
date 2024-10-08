package phanisment.collection.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import phanisment.collection.entity.BlazeLeapEntity;

public class BlazeLeapModel extends EntityModel<BlazeLeapEntity> {
	private final ModelPart Body;

	public BlazeLeapModel(ModelPart root) {
		this.Body = root.getChild("Body");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create().uv(-64, 0).cuboid(-32.0F, 0.0F, -32.0F, 64.0F, 0.0F, 64.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 64);
	}

	@Override
	public void setAngles(BlazeLeapEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}