package de.noahg_kaij.textadventure.user_interface;

import java.awt.*;

/**
 * Implements the scene manager
 * @author Kai Jellinghaus
 */
public final class SceneManager implements ISceneManager
{
    private IScene _currentScene;
    private final Component toRepaint;

    public SceneManager(IScene startScene, Component toRepaint)
    {
        _currentScene = startScene;
        this.toRepaint = toRepaint;
    }

    @Override
    public void changeScene(IScene scene)
    {
        _currentScene.disable(this);
        _currentScene = scene;
        _currentScene.enable(this);
        toRepaint.repaint();
    }

    @Override
    public IScene getCurrentScene()
    {
        return _currentScene;
    }
}
