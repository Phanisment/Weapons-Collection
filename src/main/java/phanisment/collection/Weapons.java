package phanisment.collection;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.slashvfx.registry.ModEntities;
import phanisment.collection.entity.SlashEntity;
import phanisment.collection.client.renderer.SlashEntityRenderer;

public class Weapons implements ModInitializer {
	public static final String MOD_ID = "phanisments-weapons-collection";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<SlashVFXEntity> SLASH_VFX_ENTITY = Registry.register(
		Registry.ENTITY_TYPE,
		new Identifier("phanisment", "slash_vfx"),
		FabricEntityTypeBuilder.create(SpawnGroup.MISC, SlashVFXEntity::new)
			.dimensions(EntityDimensions.fixed(1.0f, 1.0f))
			.build()
	);

	@Override
	public void onInitialize() {
		LOGGER.info("7 Sin's will comes"); // Story of the Weapons
		
		
	}
}