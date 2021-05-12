package de.noahg_kaij.textadventure.bots.simple;

import de.noahg_kaij.textadventure.gamelogic.IInventory;
import de.noahg_kaij.textadventure.gamelogic.IPlayer;
import de.noahg_kaij.textadventure.gamelogic.IRoundHistory;
import de.noahg_kaij.textadventure.gamelogic.MatchResult;

/**
 * An unforgiving player, always trying to cooperate, until betrayed once.
 * @author Kai Jellinghaus
 */
public final class UnforgivingPlayer implements IPlayer
{
    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory)
    {
        boolean hasBeenBetrayed = false;
        for (int i = 0; i < history.getCurrentMatch(); i++)
        {
            if (history.getMatchResult(i) == MatchResult.OtherHeldYouGave || history.getMatchResult(i) == MatchResult.BothHeld)
            {
                hasBeenBetrayed = true;
                break;
            }
        }
        return !hasBeenBetrayed;
    }
}