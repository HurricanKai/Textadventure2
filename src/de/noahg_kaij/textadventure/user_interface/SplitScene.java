package de.noahg_kaij.textadventure.user_interface;

import javax.swing.*;

public final class SplitScene implements IScene
{
    private IScene left;
    private IScene right;
    private ISceneManager _sceneManager;

    public SplitScene(IScene left, IScene right)
    {
        this.left = left;
        this.right = right;
    }

    public IScene getLeft()
    {
        return left;
    }

    public void setLeft(IScene left)
    {
        this.left = left;
    }

    public IScene getRight()
    {
        return right;
    }

    public void setRight(IScene right)
    {
        this.right = right;
    }

    /**
     * render the graphics
     * @param graphics the graphics object to render into
     */
    @Override
    public void render(BetterGraphics graphics)
    {
        if(this.left != null)
        {
            var left = graphics.clip(new RelativeSize(0.5f), new RelativeSize(1.0f));
            this.left.render(left);
        }

        if(this.right != null)
        {
            var right = graphics.translate(new RelativeSize(0.5f), new AbsoluteSize(0));
            this.right.render(right);
        }
    }

    @Override
    public boolean mouseClicked(int x, int y, int width, int height, int mouseButton)
    {
        var halfWidth = width / 2;
        if(x <= width && x >= 0 && y <= height && y >= 0)
        {
            if(x <= halfWidth)
            {
                if(left != null)
                    return left.mouseClicked(x, y, halfWidth, height, mouseButton);
            }
            else
            {
                if(right != null)
                    return right.mouseClicked(x + halfWidth, y, halfWidth, height, mouseButton);
            }
        }
        return false;
    }

    @Override
    public void enable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap)
    {
        _sceneManager = sceneManager;
        if(left != null)
            left.enable(sceneManager, inputMap, actionMap);
        if(right != null)
            right.enable(sceneManager, inputMap, actionMap);
    }

    @Override
    public void disable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap)
    {
        _sceneManager = null;
        if(left != null)
            left.disable(sceneManager, inputMap, actionMap);
        if(right != null)
            right.disable(sceneManager, inputMap, actionMap);
    }
}
