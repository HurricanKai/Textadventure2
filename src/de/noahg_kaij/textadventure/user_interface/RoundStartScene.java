package de.noahg_kaij.textadventure.user_interface;

import javax.swing.*;

public final class RoundStartScene implements IScene
{
    private SceneManager _sceneManager;

    @Override
    public void render(BetterGraphics graphics)
    {
        graphics.font(_mainFontMegaLarge).color(_textCol).drawString("Waiting for Round to start ...", new RelativeSize(0.5f), new RelativeSize(0.5f), Anchor.Center, Anchor.Center);
    }

    @Override
    public boolean mouseClicked(int x, int y, int width, int height, int mouseButton)
    {
        return false;
    }

    @Override
    public void enable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap)
    {
        _sceneManager = sceneManager;
    }

    @Override
    public void disable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap)
    {
        _sceneManager = null;
    }
}
