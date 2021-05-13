package de.noahg_kaij.textadventure.user_interface;

/**
 * A class representing a Button
 * @author Kai Jellinghaus
 * @author noahg
 */
public final class Button
{
    private final ISizeReference _x;
    private final ISizeReference _y;
    private final ISizeReference _width;
    private final ISizeReference _height;

    /**
     * Creates a new Button
     * @param x the x-axis offset
     * @param y the y-axis offset
     * @param width the x-axis size
     * @param height the y-axis size
     */
    public Button(ISizeReference x, ISizeReference y, ISizeReference width, ISizeReference height)
    {
        _x = x;
        _y = y;
        _width = width;
        _height = height;
    }

    /**
     * Draws the Button
     * @param graphics the graphics instance to draw to
     */
    public void draw(BetterGraphics graphics)
    {
        graphics.fillRect(_x, _y, _width, _height);
    }

    public boolean contains(int x, int y, int relativeX, int relativeY)
    {
        var absKeepX = _x.getValue(relativeX);
        var absKeepWidth = _width.getValue(relativeX);
        var absKeepY = _y.getValue(relativeY);
        var absKeepHeight = _height.getValue(relativeY);
        return x > absKeepX && x < (absKeepX + absKeepWidth) && y > absKeepY && y < (absKeepY + absKeepHeight);
    }

    /**
     * returns a graphic instance inside the button
     * @param g used graphic instance
     * @return g modified graphic instance
     */
    public BetterGraphics getContentGraphics(BetterGraphics g)
    {
        return g.translate(_x, _y).clip(_width, _height);
    }

    /**
     * Gets the X-Axis offset
     * @return The X-Axis offset
     */
    public ISizeReference getX()
    {
        return _x;
    }

    /**
     * Gets the Y-Axis offset
     * @return The Y-Axis offset
     */
    public ISizeReference getY()
    {
        return _y;
    }

    /**
     * Gets the X-Axis Size
     * @return The X-Axis Size
     */
    public ISizeReference getWidth()
    {
        return _width;
    }

    /**
     * Gets the Y-Axis Size
     * @return The Y-Axis Size
     */
    public ISizeReference getHeight()
    {
        return _height;
    }
}
