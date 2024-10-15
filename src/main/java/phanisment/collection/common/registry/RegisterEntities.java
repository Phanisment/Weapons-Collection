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

public class RegisterEntities {
	private static final Identifier FLAT = regis("geo/flat.geo.json");
	private static final Identifier FLAT_64 = regis("geo/flat_64.geo.json");
	
	public static final EntityType<EffectEntity> TEST = create("test");
	
	private static EntityType<EffectEntity> create(String name) {
		return Registry.register(Registries.ENTITY_TYPE,
			new Identifier(Weapons.MOD_ID, name),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, EffectEntity::new)
				.dimensions(EntityDimensions.fixed(0.1f, 0.1f)).build()
		);
	}
	
	private static Identifier regis(String p) {
		return new Identifier(Weapons.MOD_ID, p);
	}
	
	public static void registerRender() {
		EntityRendererRegistry.register(TEST, (context) -> new EffectRender(context, FLAT_64, AnimationSprite.SLASH, regis("animations/flat.animation.json")));
	}
	
	public static void registerAttributes() {
		
	}
}