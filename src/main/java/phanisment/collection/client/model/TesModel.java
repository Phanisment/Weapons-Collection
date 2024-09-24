package phanisment.collection.client.render;

import net.minecraft.client.render.entity.model.EntityModel; 
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.client.render.VertexConsumers;

import phanisment.collection.entity.TesEntity;

public class TesModel extends EntityModel<TesEntity> {
	private final ModelPart Body;
	public TesModel(ModelPart root) {
		this.Body = root.getChild("Body");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Body = modelPartData.addChild("Body", ModelPartBuilder.create().uv(-80, 0).cuboid(-40.0F, 0.0F, -40.0F, 80.0F, 0.0F, 80.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 80, 80);
	}
	@Override
	public void setAngles(TesEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}