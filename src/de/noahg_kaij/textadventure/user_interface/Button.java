package de.noahg_kaij.textadventure.user_interface;

import java.awt.*;

public final class Button
{
    private final ISizeReference _x;
    private final ISizeReference _y;
    private final ISizeReference _width;
    private final ISizeReference _height;

    public Button(ISizeReference x, ISizeReference y, ISizeReference width, ISizeReference height)
    {
        _x = x;
        _y = y;
        _width = width;
        _height = height;
    }

    public void draw(BetterGraphics graphics)
    {
        graphics.fillRect(_x, _y, _width, _height);
    }

    public boolean contains(int x, int y, int relativeX, int relativeY)
    {
        var absKeepX = _x.getValue(relativeX);
        var absKeepWidth = _width.getValue((int) (relativeX * 0.5f));
        var absKeepY = _y.getValue(relativeY);
        var absKeepHeight = _height.getValue(relativeY);
        return x > absKeepX && x < (absKeepX + absKeepWidth) && y > absKeepY && y < (absKeepY + absKeepHeight);
    }

    public ISizeReference getX()
    {
        return _x;
    }

    public ISizeReference getY()
    {
        return _y;
    }

    public ISizeReference getWidth()
    {
        return _width;
    }

    public ISizeReference getHeight()
    {
        return _height;
    }
}
