package de.noahg_kaij.textadventure.bots;

import de.noahg_kaij.textadventure.gamelogic.IInventory;
import de.noahg_kaij.textadventure.gamelogic.IPlayer;
import de.noahg_kaij.textadventure.gamelogic.IRoundHistory;
import de.noahg_kaij.textadventure.gamelogic.MatchResult;

/**
 * a copy player, just copies others players last choice
 *
 * @author noahg
 */
public abstract class BaseCopyPlayer implements IPlayer
{

    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory, IPlayer enemy)
    {
        if(history.getCurrentMatch() > 0)
        {
            return history.getMatchResult(history.getCurrentMatch() - 1).otherGave;
        }
        return defaultChoice();
    }

    protected abstract boolean defaultChoice();

    @Override
    public void preRound(IPlayer enemy)
    {

    }

    @Override
    public void postRound(IPlayer enemy, MatchResult matchResult)
    {

    }
}
