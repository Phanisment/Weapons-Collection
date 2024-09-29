package phanisment.collection.client.render;

import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5617;
import net.minecraft.class_927;
import phanisment.collection.Weapons;
import phanisment.collection.client.RegisterModelLayers;
import phanisment.collection.client.model.FlameSlashModel;
import phanisment.collection.entity.FlameSlashEntity;

public class FlameSlashRender extends class_927<FlameSlashEntity, FlameSlashModel> {
	private static final class_2960[] TEXTURE = {
		new class_2960(Weapons.MOD_ID, "textures/entity/hellfire_talon/slash_1.png"),
		new class_2960(Weapons.MOD_ID, "textures/entity/hellfire_talon/slash_2.png"),
		new class_2960(Weapons.MOD_ID, "textures/entity/hellfire_talon/slash_3.png"),
		new class_2960(Weapons.MOD_ID, "textures/entity/hellfire_talon/slash_4.png"),
		new class_2960(Weapons.MOD_ID, "textures/entity/hellfire_talon/slash_5.png"),
		new class_2960(Weapons.MOD_ID, "textures/entity/hellfire_talon/slash_6.png"),
		new class_2960(Weapons.MOD_ID, "textures/entity/hellfire_talon/slash_7.png")
	};

	public FlameSlashRender(class_5617.class_5618 context) {
		super(context, new FlameSlashModel(context.method_32167(RegisterModelLayers.FLAME_SLASH)), 0.6f);
	}

	@Override
	public class_2960 getTexture(FlameSlashEntity entity) {
		int tick = entity.getTickCounter();
		if(tick > 6) {
			tick = 6;
		}
		return TEXTURE[tick];
	}

	@Override
	public void render(FlameSlashEntity mobEntity, float f, float g, class_4587 matrixStack, class_4597 vertexConsumerProvider, int i) {
		super.method_4072(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
	}
}