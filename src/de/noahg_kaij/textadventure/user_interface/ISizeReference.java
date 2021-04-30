package de.noahg_kaij.textadventure.user_interface;

/**
 * Represents a size or offset that can be retrieved relative to some value
 * @author Kai Jellinghaus
 */
public interface ISizeReference {
	/**
	 * Retrieves the size or offset relative to {@param relativeTo}
	 * @param relativeTo the value that the value retrieved should be relative to
	 * @return the retrieved value
	 */
	int getValue(int relativeTo);
}
