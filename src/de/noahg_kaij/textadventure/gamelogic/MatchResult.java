package de.noahg_kaij.textadventure.gamelogic;

/**
 * Represents the possible results of a Round
 * @author Kai Jellinghaus
 */
public enum MatchResult
{
    /**
     * Represents a match not yet played
     */
    None,
    /**
     * Reached when both players give
     */
    BothGave,
    /**
     * Reached when both players held
     */
    BothHeld,
    /**
     * Reached when the other player held and the current player gave
     */
    OtherHeldYouGave,
    /**
     * Reached when the other player gave and you held
     */
    OtherGaveYouHeld
}
