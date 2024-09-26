package phanisment.collection.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import phanisment.collection.Weapons;

public class RegisterModelLayers {
	public static final EntityModelLayer TES = new EntityModelLayer(new Identifier(Weapons.MOD_ID, "tes"), "main");
}