package phanisment.legendary.vfx;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class AnimatedSlashEntity extends ItemEntity {
	public int animationTick = 0;
	private int maxAnimationTick = 20;
	
	public AnimatedSlashEntity(EntityType<? extends ItemEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override
	public void tick() {
		super.tick();
		animationTick++;
		if (animationTick >= maxAnimationTick) {
			animationTick = 0;
		}
	}
	
	@Override
	public boolean canPlayerPickup(PlayerEntity player) {
		return false;
	}
}