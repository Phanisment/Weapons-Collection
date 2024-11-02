package phanisment.collection;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import phanisment.collection.common.registry.*;
import phanisment.collection.common.item.ItemsGroup;
import phanisment.collection.common.skill.*;
import phanisment.collection.util.SkillRegistry;
import phanisment.collection.util.Skill;
import phanisment.collection.lib.Delay;
import phanisment.collection.common.command.SkillCommand;

public class Weapons implements ModInitializer {
	public static final String MOD_ID = "phanisment";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		new ItemsGroup();
		new RegisterItems();
		new RegisterEntities();
		
		Delay.register();
		SkillRegistry.register("dash", new DashSkill());
		
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			SkillCommand.register(dispatcher);
		});
	}
}