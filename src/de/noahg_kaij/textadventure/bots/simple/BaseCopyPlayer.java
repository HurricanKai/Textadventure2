package de.noahg_kaij.textadventure.bots.simple;

import de.noahg_kaij.textadventure.gamelogic.IInventory;
import de.noahg_kaij.textadventure.gamelogic.IPlayer;
import de.noahg_kaij.textadventure.gamelogic.IRoundHistory;

/**
 * a copy player, just copies others players last choice
 * @author noahg
 */
public abstract class BaseCopyPlayer implements IPlayer
{

    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory, IPlayer enemy)
    {
        if (history.getCurrentMatch() > 0)
        {
            return  history.getMatchResult(history.getCurrentMatch() - 1).otherGave;
        }
        return defaultChoice();
    }

    protected abstract boolean defaultChoice();
}
