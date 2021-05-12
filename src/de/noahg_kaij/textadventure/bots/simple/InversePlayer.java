package de.noahg_kaij.textadventure.bots.simple;

import de.noahg_kaij.textadventure.gamelogic.IInventory;
import de.noahg_kaij.textadventure.gamelogic.IPlayer;
import de.noahg_kaij.textadventure.gamelogic.IRoundHistory;

/**
 * a inverse player, just inverse others players last choice
 * @author noahg
 */
public final class InversePlayer implements IPlayer
{
    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory)
    {
        if (history.getCurrentMatch() > 0)
        {
            return  !history.getMatchResult(history.getCurrentMatch() - 1).otherGave;
        }
        return false;
    }
}
