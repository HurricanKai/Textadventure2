package de.noahg_kaij.textadventure.bots.simple;

import de.noahg_kaij.textadventure.gamelogic.IInventory;
import de.noahg_kaij.textadventure.gamelogic.IPlayer;
import de.noahg_kaij.textadventure.gamelogic.IRoundHistory;

/**
 * A simple bot that always holds
 * @author Kai Jellinghaus
 */
public final class AlwaysHoldPlayer implements IPlayer
{
    @Override
    public String getDebugName()
    {
        return "always hold";
    }

    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory, IPlayer enemy)
    {
        return false;
    }
}
