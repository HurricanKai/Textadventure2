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
    BothGive,
    /**
     * Reached when both players took
     */
    BothTook,
    /**
     * Reached when the other player took and the current player gave
     */
    OtherTookYouGave,
    /**
     * Reached when the other player gave and you took
     */
    OtherGaveYouTook
}
