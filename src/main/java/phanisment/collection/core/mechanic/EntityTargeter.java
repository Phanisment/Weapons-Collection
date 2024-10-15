package phanisment.collection.core.mechanic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Consumer;

public class EntityTargeter {
	public static List<Entity> entityInRadius(World world, Vec3d pos, double radius) {
		List<Entity> entities = world.getEntitiesByClass(Entity.class, new Box(pos.x - radius, pos.y - radius, pos.z - radius, pos.x + radius, pos.y + radius, pos.z + radius), entity -> true);
		return entities;
	}

	/*
	@Example
	Vec3d playerPos = player.getPos();
	List<Entity> nearbyEntities = EntityTargeter.entityInRadius(world, playerPos, 5);
	for (Entity entity : nearbyEntities) {
		if (entity instanceof MobEntity) {
			System.out.println("Found a mob: " + entity.getType().toString());
		}
	}
	*/
	public static void entityInRadius(World world, Vec3d pos, double radius, Consumer<Entity> consumer) {
		world.getEntitiesByClass(Entity.class, new Box(pos.x - radius, pos.y - radius, pos.z - radius, pos.x + radius, pos.y + radius, pos.z + radius), entity -> {
			consumer.accept(entity);
		});
	}
}
