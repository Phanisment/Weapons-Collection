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
	private static final Identifier FLAT = regis("geo/flat.geo.json");
	private static final Identifier WALL_FRONT = regis("geo/wall_front.geo.json");
	
	public static final EntityType<EffectEntity> BLAZING_LEAP = create("blazing_leap");
	public static final EntityType<EffectEntity> INFERNO_WHEEL = create("inferno_wheel");
	
	public static void registerRender() {
		EntityRendererRegistry.register(BLAZING_LEAP, (context) -> new EffectRender(context, FLAT, AnimationSprite.BLAZE_LEAP, regis("animations/flat.animation.json")));
		EntityRendererRegistry.register(INFERNO_WHEEL, (context) -> new EffectRender(context, WALL_FRONT, AnimationSprite.INFERNO_WHEEL, regis("animations/flat.animation.json")));
	}
	
	public static void registerAttributes() {
		
	}
	
	private static EntityType<EffectEntity> create(String name) {
		return Registry.register(Registries.ENTITY_TYPE,
			new Identifier(Weapons.MOD_ID, name),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, EffectEntity::new)
				.dimensions(EntityDimensions.fixed(0f, 0f)).build()
		);
	}
	
	private static Identifier regis(String p) {
		return new Identifier(Weapons.MOD_ID, p);
	}
}