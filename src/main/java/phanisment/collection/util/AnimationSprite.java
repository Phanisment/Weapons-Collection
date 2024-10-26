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

	private static Identifier texture(String path) {
		return new Identifier(Weapons.MOD_ID, "textures/entity/" + path);
	}
}