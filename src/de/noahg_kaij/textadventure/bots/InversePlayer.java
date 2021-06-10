package de.noahg_kaij.textadventure.bots;

import de.noahg_kaij.textadventure.gamelogic.IInventory;
import de.noahg_kaij.textadventure.gamelogic.IPlayer;
import de.noahg_kaij.textadventure.gamelogic.IRoundHistory;
import de.noahg_kaij.textadventure.gamelogic.MatchResult;

/**
 * a inverse player, just inverse others players last choice
 * @author noahg
 */
public final class InversePlayer implements IPlayer
{
    @Override
    public String getDebugName()
    {
        return "inverse";
    }

    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory, IPlayer enemy)
    {
        if (history.getCurrentMatch() > 0)
        {
            return  !history.getMatchResult(history.getCurrentMatch() - 1).otherGave;
        }
        return false;
    }

    @Override
    public void preRound(IPlayer enemy)
    {

    }

    @Override
    public void postRound(IPlayer enemy, MatchResult matchResult)
    {

    }
}
