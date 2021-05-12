package de.noahg_kaij.textadventure.bots.complex;

/**
 * evil version of {@link BaseCopyPlayer}, first choice always hold
 * @author noahg
 */
public class EvilCopyPlayer extends BaseCopyPlayer
{

    @Override
    protected boolean defaultChoice()
    {
        return false;
    }
}
