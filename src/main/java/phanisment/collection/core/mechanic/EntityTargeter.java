package phanisment.collection.core.mechanic;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class EntityTargeter {
	public static List<Entity> entityInRadius(World world, Vec3d pos, double radius) {
		List<Entity> entities = world.getEntitiesByClass(Entity.class, new Box(pos.x - radius, pos.y - radius, pos.z - radius, pos.x + radius, pos.y + radius, pos.z + radius), entity -> true);
		return entities;
	}
	
	public static List<Entity> entitiesInRadiusExcludingTypes(World world, Vec3d pos, double radius, PlayerEntity currentPlayer, List<Class<? extends Entity>> excludedEntityClasses) {
		List<Entity> entities = world.getEntitiesByClass(Entity.class, new Box(pos.x - radius, pos.y - radius, pos.z - radius, pos.x + radius, pos.y + radius, pos.z + radius),
			entity -> !excludedEntityClasses.stream().anyMatch(clazz -> clazz.isInstance(entity)) && !entity.equals(currentPlayer));
		return entities;
}

}
