package de.noahg_kaij.textadventure.user_interface;

import javax.swing.*;
import java.awt.*;

/**
 * Implements the scene manager
 *
 * @author Kai Jellinghaus
 */
public final class SceneManager implements ISceneManager
{
    private final Component toRepaint;
    private final InputMap inputMap;
    private final ActionMap actionMap;
    private IScene _currentScene;

    public SceneManager(IScene startScene, Component toRepaint, InputMap inputMap, ActionMap actionMap)
    {
        _currentScene = startScene;
        this.toRepaint = toRepaint;
        this.inputMap = inputMap;
        this.actionMap = actionMap;
    }

    @Override
    public void changeScene(IScene scene)
    {
        _currentScene.disable(this, inputMap, actionMap);
        _currentScene = scene;
        _currentScene.enable(this, inputMap, actionMap);
        toRepaint.repaint();
    }

    @Override
    public IScene getCurrentScene()
    {
        return _currentScene;
    }

    @Override
    public void repaint()
    {
        toRepaint.repaint();
    }
}
