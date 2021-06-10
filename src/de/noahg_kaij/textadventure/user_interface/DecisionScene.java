package de.noahg_kaij.textadventure.user_interface;

import javax.swing.*;

public final class DecisionScene implements IScene
{
    private final Button _giveButton = new Button(new RelativeSize(0.1f), new RelativeSize(0.05f),
            new RelativeSize(0.8f), new RelativeSize(0.35f));
    private final Button _keepButton = new Button(new RelativeSize(0.1f), new RelativeSize(0.65f),
            new RelativeSize(0.8f), new RelativeSize(0.95f));
    private SceneManager _sceneManager;

    private boolean _decision;
    private boolean _hasDecision;

    public boolean getDecision()
    {
        return _decision;
    }

    public boolean hasDecision()
    {
        return _hasDecision;
    }

    @Override
    public void render(BetterGraphics graphics)
    {
        _giveButton.draw(graphics.color(_frontCol));
        _giveButton.getContentGraphics(graphics).color(_textCol).font(_mainFontLarge).drawString("Give Coin", new RelativeSize(0.5f), new RelativeSize(0.5f), Anchor.Center, Anchor.Center);

        _keepButton.draw(graphics.color(_frontCol));
        _keepButton.getContentGraphics(graphics).color(_textCol).font(_mainFontLarge).drawString("Hold Coin", new RelativeSize(0.5f), new RelativeSize(0.5f), Anchor.Center, Anchor.Center);
    }

    @Override
    public boolean mouseClicked(int x, int y, int width, int height, int mouseButton)
    {
        if(_giveButton.contains(x, y, width, height))
        {
            _decision = true;
            _hasDecision = true;
            return true;
        }

        if(_keepButton.contains(x, y, width, height))
        {
            _decision = false;
            _hasDecision = true;
            return true;
        }

        return false;
    }

    /**
     * Enables the current scene
     *
     * @param sceneManager the scene manager
     * @param inputMap
     * @param actionMap
     */
    @Override
    public void enable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap)
    {
        _sceneManager = sceneManager;
    }

    /**
     * Disables the current scene
     *
     * @param sceneManager the scene manager
     * @param inputMap
     * @param actionMap
     */
    @Override
    public void disable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap)
    {
        _sceneManager = null;
    }
}
