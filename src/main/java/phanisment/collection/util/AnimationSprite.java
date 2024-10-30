package phanisment.collection.util;

import net.minecraft.util.Identifier;
import phanisment.collection.Weapons;

public class AnimationSprite {
	public static final Identifier[] BASIC_DASH = {
		texture("basic_dash/dash_1.png"),
		texture("basic_dash/dash_2.png"),
		texture("basic_dash/dash_3.png"),
		texture("basic_dash/dash_4.png")
	};
	
	public static final Identifier[] BASIC_IMPACT = {
		texture("basic_dash/impact_1.png"),
		texture("basic_dash/impact_2.png"),
		texture("basic_dash/impact_3.png"),
		texture("basic_dash/impact_4.png")
	};
	
	public static final Identifier[] SCARLETT_SLASH = {
		texture("scarlett_slash/scarlett_slash_1.png"),
		texture("scarlett_slash/scarlett_slash_2.png"),
		texture("scarlett_slash/scarlett_slash_3.png"),
		texture("scarlett_slash/scarlett_slash_4.png"),
		texture("scarlett_slash/scarlett_slash_5.png"),
		texture("scarlett_slash/scarlett_slash_6.png")
	};

	private static Identifier texture(String path) {
		return new Identifier(Weapons.MOD_ID, "textures/effects/" + path);
	}
}