package de.noahg_kaij.textadventure.user_interface;

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
