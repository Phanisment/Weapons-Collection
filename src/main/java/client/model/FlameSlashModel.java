package phanisment.collection.client.model;

import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_583;
import net.minecraft.class_630;
import net.minecraft.client.model.*;
import phanisment.collection.entity.FlameSlashEntity;

public class FlameSlashModel extends class_583<FlameSlashEntity> {
	private final class_630 Body;

	public FlameSlashModel(class_630 root) {
		this.Body = root.method_32086("Body");
	}

	public static class_5607 getTexturedModelData() {
		class_5609 modelData = new class_5609();
		class_5610 modelPartData = modelData.method_32111();
		class_5610 Body = modelPartData.method_32117("Body", class_5606.method_32108().method_32101(-64, 0).method_32098(-32.0F, 0.0F, -32.0F, 64.0F, 0.0F, 64.0F, new class_5605(0.0F)), class_5603.method_32090(0.0F, 24.0F, 0.0F));
		return class_5607.method_32110(modelData, 128, 128);
	}

	@Override
	public void setAngles(FlameSlashEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void method_2828(class_4587 matrices, class_4588 vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Body.method_22699(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}