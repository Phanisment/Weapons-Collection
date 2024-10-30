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
	private static final Identifier[] MODELS = {
		new Identifier(Weapons.MOD_ID, "geo/flat.geo.json"),
		new Identifier(Weapons.MOD_ID, "geo/wall.geo.json"),
		new Identifier(Weapons.MOD_ID, "geo/effects/dash.geo.json")
	};
	
	// Animations.
	private static final Identifier[] ANIMATIONS = {
		new Identifier(Weapons.MOD_ID, "animations/flat.animation.json"),
		new Identifier(Weapons.MOD_ID, "animations/effects/dash.animation.json")
	};
	
	// Entities.
	public static final EntityType<EffectEntity> BASIC_DASH = registerEffect("basic_dash", 0.1F, 0.1F);
<<<<<<< HEAD
	public static final EntityType<EffectEntity> BASIC_IMPACT = registerEffect("basic_impact", 0.1F, 0.1F);
	public static final EntityType<EffectEntity> BASIC_SLASH = registerEffect("basic_slash", 0.1F, 0.1F);
	
	public static final EntityType<EffectEntity> SCARLETT_SLASH = registerEffect("scarlett_slash", 0.1F, 0.1F);
=======
>>>>>>> 3bcd9832b9e96d777e493bee93ffb6b4aa9c522a
	
	// Entities Render Registry.
	public static void registerRender() {
		EntityRendererRegistry.register(BASIC_DASH, (context) -> new EffectRender(context, MODELS[2], AnimationSprite.BASIC_DASH, ANIMATIONS[1]));
<<<<<<< HEAD
		EntityRendererRegistry.register(BASIC_IMPACT, (context) -> new EffectRender(context, MODELS[0], AnimationSprite.BASIC_IMPACT, ANIMATIONS[0]));
=======
	}
	
	// Entity Attributes Registry.
	public static void registerAttributes() {
		
>>>>>>> 3bcd9832b9e96d777e493bee93ffb6b4aa9c522a
	}
	
	private static EntityType<EffectEntity> registerEffect(String name, float width, float height) {
		return Registry.register(Registries.ENTITY_TYPE,
			new Identifier(Weapons.MOD_ID, name),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, EffectEntity::new)
				.dimensions(EntityDimensions.fixed(width, height)).build()
		);
	}
}