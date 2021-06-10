package de.noahg_kaij.textadventure.bots;

import de.noahg_kaij.textadventure.gamelogic.IInventory;
import de.noahg_kaij.textadventure.gamelogic.IPlayer;
import de.noahg_kaij.textadventure.gamelogic.IRoundHistory;

/**
 * a swap player, just inverses his last choice
 * @author noahg
 */
public class SwapPlayer implements IPlayer
{
    @Override
    public String getDebugName()
    {
        return "swap";
    }

    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory, IPlayer enemy)
    {
        if(history.getCurrentMatch() > 0)
        {
            return !history.getMatchResult(history.getCurrentMatch() - 1).youGave;
        }
        return true;
    }
}
