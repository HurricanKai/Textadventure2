package de.noahg_kaij.textadventure.user_interface;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface IScene
{
    static final Font _mainFont = new Font("Arial", Font.PLAIN, 12);
    static final Font _mainFontSmall = _mainFont.deriveFont(15f);
    static final Font _mainFontLarge = _mainFont.deriveFont(25f);
    static final Font _mainFontMegaLarge = _mainFont.deriveFont(40f);
    static final Font _debugFont = new Font("Monospaced", Font.PLAIN, 40);

    static final Color _backCol = new Color(39, 41, 50);
    static final Color _frontCol = new Color(72, 61, 63);
    static final Color _red = new Color(255, 85, 64);
    static final Color _yellow = new Color(236, 192, 91);
    static final Color _green = new Color(114, 151, 117);
    static final Color _textCol = new Color(182, 249, 255);

    /**
     * Renders the scene
     * @param graphics the graphics object to render into
     */
    void render(BetterGraphics graphics);

    /**
     * Signals a mouseclick to the scene
     * @param x the x position
     * @param y the y position
     * @param width the width of the scene
     * @param height the height of the scene
     * @param mouseButton the mouse button pressed
     * @return whether the mouse event was consumed
     */
    boolean mouseClicked(int x, int y, int width, int height, int mouseButton);

    /**
     * Enables the current scene
     * @param sceneManager the scene manager
     */
    void enable(SceneManager sceneManager);

    /**
     * Disables the current scene
     * @param sceneManager the scene manager
     */
    void disable(SceneManager sceneManager);
}
