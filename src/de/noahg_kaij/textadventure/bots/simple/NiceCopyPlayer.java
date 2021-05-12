package de.noahg_kaij.textadventure.bots.simple;

import de.noahg_kaij.textadventure.bots.simple.BaseCopyPlayer;

/**
 * nice version of {@link BaseCopyPlayer}, first choice always give
 * @author noahg
 */
public final class NiceCopyPlayer extends BaseCopyPlayer
{
    @Override
    protected boolean defaultChoice()
    {
        return true;
    }
}
