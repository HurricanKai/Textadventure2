package de.noahg_kaij.textadventure.bots;

import de.noahg_kaij.textadventure.gamelogic.IInventory;
import de.noahg_kaij.textadventure.gamelogic.IPlayer;
import de.noahg_kaij.textadventure.gamelogic.IRoundHistory;

/**
 * A simple bot, that always gives.
 * @author Kai Jellinghaus
 */
public final class AlwaysGivePlayer implements IPlayer
{
    @Override
    public String getDebugName()
    {
        return "always give";
    }

    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory, IPlayer enemy)
    {
        return true;
    }
}
