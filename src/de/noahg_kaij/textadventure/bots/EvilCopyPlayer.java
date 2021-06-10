package de.noahg_kaij.textadventure.bots;

/**
 * evil version of {@link BaseCopyPlayer}, first choice always hold
 *
 * @author noahg
 */
public final class EvilCopyPlayer extends BaseCopyPlayer
{
    @Override
    public String getDebugName()
    {
        return "evil copy";
    }

    @Override
    protected boolean defaultChoice()
    {
        return false;
    }
}
