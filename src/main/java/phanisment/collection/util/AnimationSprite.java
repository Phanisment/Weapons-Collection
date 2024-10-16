package phanisment.collection.util;

import net.minecraft.util.Identifier;
import phanisment.collection.Weapons;

public class AnimationSprite {
	public static final Identifier[] BLAZE_LEAP = {
		texture("blaze_leap/blaze_leap_1.png"),
		texture("blaze_leap/blaze_leap_2.png"),
		texture("blaze_leap/blaze_leap_3.png"),
		texture("blaze_leap/blaze_leap_4.png"),
		texture("blaze_leap/blaze_leap_5.png"),
		texture("blaze_leap/blaze_leap_6.png"),
		texture("blaze_leap/blaze_leap_7.png")
	};
	
	private static Identifier texture(String path) {
		return new Identifier(Weapons.MOD_ID, "textures/entity/" + path);
	}
}