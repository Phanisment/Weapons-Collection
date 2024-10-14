package phanisment.collection.util;

import net.minecraft.util.Identifier;
import phanisment.collection.Weapons;

public class Identify {
	public Identifier register(String p) {
		return new Identifier(Weapons.MOD_ID, p);
	}
}