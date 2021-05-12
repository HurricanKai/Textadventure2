package de.noahg_kaij.textadventure.bots.complex;

/**
 * nice version of {@link BaseCopyPlayer}, first choice always give
 * @author noahg
 */
public class NiceCopyPlayer extends BaseCopyPlayer
{

    @Override
    protected boolean defaultChoice()
    {
        return true;
    }
}
