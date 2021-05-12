package de.noahg_kaij.textadventure.bots.complex;

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
    public boolean makeChoice(IRoundHistory history, IInventory inventory)
    {
        if (history.getCurrentMatch() > 0)
        {
            switch (history.getMatchResult(history.getCurrentMatch() - 1))
            {
                case BothHeld:
                case OtherHeldYouGave:
                    return false;

                case BothGave:
                case OtherGaveYouHeld:
                    return true;
            }
        }
        return defaultChoice();
    }

    protected abstract boolean defaultChoice();
}
