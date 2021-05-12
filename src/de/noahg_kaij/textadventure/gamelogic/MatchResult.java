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
    None(false, false),
    /**
     * Reached when both players gave
     */
    BothGave(true, true),
    /**
     * Reached when both players held
     */
    BothHeld(false, false),
    /**
     * Reached when the other player held and the current player gave
     */
    OtherHeldYouGave(false, true),
    /**
     * Reached when the other player gave and you held
     */
    OtherGaveYouHeld(true, false);

    public final boolean otherGave;
    public final boolean youGave;

    MatchResult(boolean otherGave, boolean youGave)
    {
        this.otherGave = otherGave;
        this.youGave = youGave;
    }
}
