package phanisment.collection.entity;

import java.util.List;
import net.minecraft.class_1282;
import net.minecraft.class_1296;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1429;
import net.minecraft.class_1937;
import net.minecraft.class_3218;
import net.minecraft.class_5132;
import net.minecraft.class_5134;

public class FlameSlashEntity extends class_1429 {
	private int lifeTime = 6;
	private int tickCounter = 0;

	public FlameSlashEntity(class_1299<? extends class_1429> entityType, class_1937 world) {
		super(entityType, world);
	}

	@Override
	public void method_5773() {
		super.method_5773();
		if (!this.method_37908().field_9236) {
			if (this.lifeTime-- <= 0) {
				this.method_31472();
			}
		}
	}

	public int getTickCounter() {
		return this.tickCounter;
	}

	@Override
	public void method_5670() {
	}

	@Override
	public boolean method_5740() {
		return true;
	}

	@Override
	public void method_6087(class_1297 entity) {
	}

	@Override
	public FlameSlashEntity method_5613(class_3218 world, class_1296 mate) {
		return null;
	}

	@Override
	public boolean method_5679(class_1282 damageSource) {
		return true;
	}

	public static class_5132.class_5133 createAttributes() {
		return class_1308.method_26828().method_26868(class_5134.field_23716, 20.0);
	}
}
