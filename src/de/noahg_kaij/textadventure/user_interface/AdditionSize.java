package de.noahg_kaij.textadventure.user_interface;

/**
 * Represents a size reference which is the sum of two other size references
 */
public final class AdditionSize implements ISizeReference
{
    private final ISizeReference _a;
    private final ISizeReference _b;

    public AdditionSize(ISizeReference a, ISizeReference b)
    {
        _a = a;
        _b = b;
    }

    @Override
    public int getValue(int relativeTo)
    {
        return _a.getValue(relativeTo) + _b.getValue(relativeTo);
    }
}
