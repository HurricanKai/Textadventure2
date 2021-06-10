package de.noahg_kaij.textadventure.gamelogic;

/**
 * Represents the inventory of one player
 *
 * @author Kai Jellinghaus
 */
public interface IInventory
{
    /**
     * @return the current number of coins
     */
    int getCurrentCoins();

    /**
     * @return the initial amount of coins
     */
    int getStartingCoins();
}
