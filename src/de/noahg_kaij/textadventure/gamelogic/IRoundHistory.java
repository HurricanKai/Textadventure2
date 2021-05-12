package de.noahg_kaij.textadventure.gamelogic;

/**
 * Represents the Round history
 * @author Kai Jellinghaus
 */
public interface IRoundHistory
{
    /**
     * @return the current match index (starting at 0, up to {@link #getMaxMatch()})
     */
    int getCurrentMatch();

    /**
     * @return the maximum match index (zero-based)
     */
    int getMaxMatch();

    /**
     * Retrieves the match result of the match indicated by {@param index}
     * @param index the index of the match to retrieve
     * @return the match result
     * @throws IndexOutOfBoundsException when {@param index} is less then 0 or larger or equal {@link #getMaxMatch()}
     */
    MatchResult getMatchResult(int index);

    /**
     * Retrieves the last rounds last match result
     * @return The retrieved result
     */
    MatchResult getLastRoundLastMatch();
}
