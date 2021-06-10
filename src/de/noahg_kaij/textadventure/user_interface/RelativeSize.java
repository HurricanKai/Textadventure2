package de.noahg_kaij.textadventure.user_interface;

/**
 * A relative implementation of {@link de.noahg_kaij.textadventure.user_interface.ISizeReference}
 *
 * @author Kai Jellinghaus
 */
public final class RelativeSize implements ISizeReference
{

    private final float _factor;

    public RelativeSize(float factor)
    {
        _factor = factor;
    }

    @Override
    public int getValue(int relativeTo)
    {
        return (int)(relativeTo * _factor);
    }

}
