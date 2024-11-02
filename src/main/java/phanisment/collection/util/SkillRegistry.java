package phanisment.collection.util;

import java.util.HashMap;
import java.util.Map;

import phanisment.collection.util.Skill;

/* 
 * This class provides a registry for managing skills. It offers methods
 * to register new skills and retrieve existing ones.
 */
public class SkillRegistry {

	/* 
	 * A private static final Map of type String and Skill is used to store
	 * the registered skills. The key is the name of the skill (String),
	 * and the value is the Skill object itself. This Map is initialized
	 * using a HashMap implementation, ensuring efficient key-value lookups.
	 */
	private static final Map<String, Skill> skills = new HashMap<>();

	/* 
	 * Registers a new skill in the registry.
	 * 
	 * @param name  The unique name of the skill to be registered.
	 * @param skill The Skill object representing the skill to be added.
	 * 
	 * @throws      IllegalArgumentException If a skill with the same name already
	 *              exists in the registry.
	 */
	public static void register(String name, Skill skill) {
		if (skills.containsKey(name)) {
			throw new IllegalArgumentException("A skill with the name '" + name + "' already exists.");
		}
		skills.put(name, skill);
	}

	/* 
	 * Retrieves a registered skill by its name.
	 * 
	 * @param name The name of the skill to retrieve.
	 * @return     The Skill object associated with the given name, or null if
	 *             the skill is not found.
	 */
	public static Skill getSkill(String name) {
		return skills.get(name);
	}

	/* 
	 * **(Not recommended for modification)**
	 *
	 * Returns a reference to the internal Map containing all registered skills.
	 * Modifying this Map directly can lead to unexpected behavior and potential
	 * inconsistencies in the registry. It's generally recommended to use the
	 * `getSkill(String name)` method to retrieve specific skills.
	 *
	 * @return An unmodifiable view of the internal Map containing registered skills.
	 */
	public static Map<String, Skill> getSkill() {
		return skills; // Return an unmodifiable copy
	}
}