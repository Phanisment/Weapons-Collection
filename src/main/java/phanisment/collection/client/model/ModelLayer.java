package phanisment.collection.client.model;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import phanisment.collection.Weapons;

public class ModelLayer {
	public static final EntityModelLayer SLASH = new EntityModelLayer(new Identifier(Weapons.MOD_ID, "slash"), "main");
}