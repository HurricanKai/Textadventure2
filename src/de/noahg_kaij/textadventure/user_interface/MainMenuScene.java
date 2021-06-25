package de.noahg_kaij.textadventure.user_interface;

import javax.swing.*;

public class MainMenuScene implements IScene
{
    private SceneManager _sceneManager;

    @Override
    public void render(BetterGraphics graphics)
    {
        graphics.color(_textCol).font(_mainFontMegaLarge).drawString("Scral", new RelativeSize(0.5f), new RelativeSize(0.5f), Anchor.Center, Anchor.Center);
        graphics.color(_textCol).font(_mainFontLarge).drawString("Welcome! Click anywhere to start.", new RelativeSize(0.5f), new RelativeSize(0.55f), Anchor.Center, Anchor.Center);
    }

    @Override
    public boolean mouseClicked(int x, int y, int width, int height, int mouseButton)
    {
        _sceneManager.changeScene(new GameStartScene());
        return true;
    }

    @Override
    public void enable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap)
    {
        _sceneManager = sceneManager;
    }

    @Override
    public void disable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap)
    {

    }
}
