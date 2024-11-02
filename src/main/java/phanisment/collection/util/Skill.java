package phanisment.collection.util;

import net.minecraft.entity.player.PlayerEntity;

/* 
 * This interface defines a contract for skills in the game. 
 * Any class implementing this interface represents a skill that can be cast by a player.
 */
public interface Skill {
	/* 
	* This method is called when the skill is cast by a player.
	* It should contain the logic for the skill's effects and behaviors.
	* 
	* @param player The player who cast the skill.
	*/
	void cast(PlayerEntity player);
}