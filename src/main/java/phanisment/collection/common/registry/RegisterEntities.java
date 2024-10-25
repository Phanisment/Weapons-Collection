package phanisment.collection.common.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import phanisment.collection.Weapons;
import phanisment.collection.common.entity.base.EffectEntity;
import phanisment.collection.client.render.base.EffectRender;
import phanisment.collection.util.AnimationSprite;

public class RegisterEntities {
	// Models.
	private static final Identifier FLAT = new Identifier(Weapons.MOD_ID, "geo/flat.geo.json");
	private static final Identifier WALL = new Identifier(Weapons.MOD_ID, "geo/wall.geo.json");
	
	// Animations.
	private static final Identifier FLAT_ANIMATION = new Identifier(Weapons.MOD_ID, "animations/flat.animation.json");
	
	// Entities.
	public static final EntityType<EffectEntity> FLAME_SLASH = registerEffect("flame_slash", 0.1F, 0.1F);
	
	// Entities Render Registry.
	public static void registerRender() {
		EntityRendererRegistry.register(FLAME_SLASH, (context) -> new EffectRender(context, FLAT, AnimationSprite.FLAME_SLASH, FLAT_ANIMATION));
	}
	
	// Entity Attributes Registry.
	public static void registerAttributes() {
		
	}
	
	private static EntityType<EffectEntity> registerEffect(String name, float width, float height) {
		return Registry.register(Registries.ENTITY_TYPE,
			new Identifier(Weapons.MOD_ID, name),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, EffectEntity::new)
				.dimensions(EntityDimensions.fixed(width, height)).build()
		);
	}
}