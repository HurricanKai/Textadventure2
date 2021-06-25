package de.noahg_kaij.textadventure.user_interface;

import javax.swing.*;
import java.awt.*;

public interface IScene
{
    Font _mainFont = new Font("Arial", Font.PLAIN, 12);
    Font _mainFontSmall = _mainFont.deriveFont(15f);
    Font _mainFontMedium = _mainFont.deriveFont(20f);
    Font _mainFontLarge = _mainFont.deriveFont(25f);
    Font _mainFontMegaLarge = _mainFont.deriveFont(40f);
    Font _debugFont = new Font("Monospaced", Font.PLAIN, 40);

    Color _backCol = new Color(39, 41, 50);
    Color _frontCol = new Color(72, 61, 63);
    Color _red = new Color(255, 85, 64);
    Color _yellow = new Color(236, 192, 91);
    Color _green = new Color(114, 151, 117);
    Color _textCol = new Color(182, 249, 255);

    /**
     * Renders the scene
     *
     * @param graphics the graphics object to render into
     */
    void render(BetterGraphics graphics);

    /**
     * Signals a mouseclick to the scene
     *
     * @param x           the x position
     * @param y           the y position
     * @param width       the width of the scene
     * @param height      the height of the scene
     * @param mouseButton the mouse button pressed
     * @return whether the mouse event was consumed
     */
    boolean mouseClicked(int x, int y, int width, int height, int mouseButton);

    /**
     * Enables the current scene
     *
     * @param sceneManager the scene manager
     * @param inputMap
     * @param actionMap
     */
    void enable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap);

    /**
     * Disables the current scene
     *
     * @param sceneManager the scene manager
     * @param inputMap
     * @param actionMap
     */
    void disable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap);
}
