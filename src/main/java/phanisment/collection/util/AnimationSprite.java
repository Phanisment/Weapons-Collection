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
	}
	
	public static final Identifier[] BLAZE_LEAP = {
		texture("blaze_leap/blaze_leap_1.png"),
		texture("blaze_leap/blaze_leap_2.png"),
		texture("blaze_leap/blaze_leap_3.png"),
		texture("blaze_leap/blaze_leap_4.png"),
		texture("blaze_leap/blaze_leap_5.png"),
		texture("blaze_leap/blaze_leap_6.png"),
		texture("blaze_leap/blaze_leap_7.png")
	};
	
	public static final Identifier[] INFERNO_WHEEL = {
		texture("inferno_wheel/inferno_wheel_1.png"),
		texture("inferno_wheel/inferno_wheel_2.png"),
		texture("inferno_wheel/inferno_wheel_3.png"),
		texture("inferno_wheel/inferno_wheel_4.png"),
		texture("inferno_wheel/inferno_wheel_5.png"),
		texture("inferno_wheel/inferno_wheel_6.png"),
		texture("inferno_wheel/inferno_wheel_7.png"),
		texture("inferno_wheel/inferno_wheel_8.png"),
		texture("inferno_wheel/inferno_wheel_9.png"),
		texture("inferno_wheel/inferno_wheel_10.png")
	};
	
	private static Identifier texture(String path) {
		return new Identifier(Weapons.MOD_ID, "textures/entity/" + path);
	}
}