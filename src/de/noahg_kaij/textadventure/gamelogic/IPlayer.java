package de.noahg_kaij.textadventure.gamelogic;

/**
 * Represents a player capable of making one choice per round
 * @author Kai Jellinghaus
 */
public interface IPlayer
{
    /**
     * Lets the player make a choice, true = gives, false = holds
     * @param history the history of the current round
     * @param inventory the players inventory
     * @param enemy
     * @return The choice made. true = gives, false = holds
     */
    boolean makeChoice(IRoundHistory history, IInventory inventory, IPlayer enemy);

    /**
     * Called pre-round (before the first makeChoice of a round) and allows the player to perform various actions
     * @param enemy the player fought next
     */
    void preRound(IPlayer enemy);

    /**
     * Called post-round (after the last makeChoice of a round) and allows the player to perform various actions
     * @param enemy the player fought last
     */
    void postRound(IPlayer enemy, MatchResult matchResult);

    String getDebugName();
}
