package de.noahg_kaij.textadventure.bots;

/**
 * nice version of {@link BaseCopyPlayer}, first choice always give
 * @author noahg
 */
public final class NiceCopyPlayer extends BaseCopyPlayer
{
    @Override
    public String getDebugName()
    {
        return "nice copy";
    }

    @Override
    protected boolean defaultChoice()
    {
        return true;
    }
}
