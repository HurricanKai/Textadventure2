package de.noahg_kaij.textadventure.bots.simple;

import de.noahg_kaij.textadventure.bots.simple.BaseCopyPlayer;

/**
 * evil version of {@link BaseCopyPlayer}, first choice always hold
 * @author noahg
 */
public final class EvilCopyPlayer extends BaseCopyPlayer
{

    @Override
    protected boolean defaultChoice()
    {
        return false;
    }
}
