package de.noahg_kaij.textadventure.user_interface;

/**
 * A simple interface for basic drawing operations. Can be used with lambdas.
 */
public interface PaintAction {
	/**
	 * Executes the paint action
	 * @param g the graphics context to use for painting
	 */
	void paint(BetterGraphics g);
}
