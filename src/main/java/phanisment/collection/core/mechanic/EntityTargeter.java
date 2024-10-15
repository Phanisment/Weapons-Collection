package phanisment.collection.core.mechanic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class EntityTargeter {
	
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
	public static List<Entity> entityInRadius(World world, Vec3d pos, double radius) {
		List<Entity> entities = world.getEntitiesByClass(Entity.class, new Box(pos.x - radius, pos.y - radius, pos.z - radius, pos.x + radius, pos.y + radius, pos.z + radius), entity -> true);
		return entities;
	}

	public static void entityInRadius(World world, Vec3d pos, double radius, Consumer<Entity> consumer) {
		world.getEntitiesByClass(Entity.class, new Box(pos.x - radius, pos.y - radius, pos.z - radius, pos.x + radius, pos.y + radius, pos.z + radius), entity -> {
			consumer.accept(entity);
		});
	}

	/*
	@Example
	List<Entity> entities = EntityTargeter.entityInFront(world, player, 5, 1, 2);
	for (Entity entity : entities) {
		if (entity instanceof MobEntity) {
			System.out.println("Found a mob: " + entity.getType().toString());
		}
	}
	*/
	public static List<Entity> entityInFront(World world, PlayerEntity player, double distance, double width, double height) {
		Vec3d playerPos = player.getPos();
		Vec3d lookVec = player.getRotationVec(1.0f);
		Vec3d endPos = playerPos.add(lookVec.multiply(distance));
		AxisAlignedBB boundingBox = new AxisAlignedBB(playerPos.x, playerPos.y, playerPos.z, endPos.x, endPos.y + height, endPos.z).expand(width / 2, height / 2, width / 2);
		List<Entity> entities = world.getEntitiesByClass(Entity.class, boundingBox, entity -> true);
		return entities;
	}
}
