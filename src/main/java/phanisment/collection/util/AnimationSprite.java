package phanisment.collection.util;

import net.minecraft.util.Identifier;
import phanisment.collection.Weapons;

public class AnimationSprite {
	public static final Identifier[] FLAME_SLASH = {
		texture("flame_slash/flame_slash_1.png"),
		texture("flame_slash/flame_slash_2.png"),
		texture("flame_slash/flame_slash_3.png"),
		texture("flame_slash/flame_slash_4.png"),
		texture("flame_slash/flame_slash_5.png"),
		texture("flame_slash/flame_slash_6.png"),
		texture("flame_slash/flame_slash_7.png")
	};

	private static Identifier texture(String path) {
		return new Identifier(Weapons.MOD_ID, "textures/entity/" + path);
	}
}