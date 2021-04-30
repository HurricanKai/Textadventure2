package de.noahg_kaij.textadventure.user_interface;

import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * A simple JFrame implementation that calls into a single {@link de.noahg_kaij.textadventure.user_interface.PaintAction} for drawing
 */
public final class SimplePaintFrame extends JFrame {

	private final PaintAction _action;

	public SimplePaintFrame(PaintAction action)
	{
		_action = action;
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		BetterGraphics g2 = new BetterGraphics(g);
		_action.paint(g2);
	}
}