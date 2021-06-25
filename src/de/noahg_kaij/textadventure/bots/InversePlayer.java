package de.noahg_kaij.textadventure.bots;

import de.noahg_kaij.textadventure.gamelogic.IInventory;
import de.noahg_kaij.textadventure.gamelogic.IPlayer;
import de.noahg_kaij.textadventure.gamelogic.IRoundHistory;
import de.noahg_kaij.textadventure.gamelogic.MatchResult;

import java.util.HashMap;

/**
 * a inverse player, just inverse others players last choice
 *
 * @author noahg
 */
public final class InversePlayer implements IPlayer
{
    /*@Override
    public String getDebugName()
    {
        return "inverse";
    }*/

    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory, IPlayer enemy)
    {
        if(history.getCurrentMatch() > 0)
        {
            return ! history.getMatchResult(history.getCurrentMatch() - 1).otherGave;
        }
        return false;
    }

    @Override
    public void preRound(IPlayer enemy)
    {

    }

    @Override
    public void postRound(IPlayer enemy, MatchResult matchResult)
    {

    }

    private static final HashMap<MatchResult, String[]> _story = new HashMap<MatchResult, String[]>()
    {{
        put(MatchResult.BothGave, new String[] {
                "Wenn du dein Geld gibst, dann kann ich meins ja behalten :)",
                null, null, null, null,
        });
        put(MatchResult.BothHeld, new String[] {
                "Das bringt doch so nichts.",
                "Ich muss irgendetwas ändern.",
                "So bekomme ich kein Geld…",
                null, null, null, null, null, null, null, null, null, null, null, null,
        });
        put(MatchResult.OtherHeldYouGave, new String[] {
                "Die anderen denken ich bin verrückt, aber das ist die Ultimative Taktik.",
                null, null, null, null,
        });
        put(MatchResult.OtherGaveYouHeld, new String[] {
                "HAHAHA ICH BIN EIN GENIE",
                "JAWOLL GLEICH NOCHMAL",
                null, null, null, null, null, null, null, null,
        });
    }};
    private int _storyIndex = 0;
    @Override
    public String getStorySegment(MatchResult matchResult)
    {
        _storyIndex += Math.random() * 5;
        _storyIndex %= _story.get(matchResult).length;
        return _story.get(matchResult)[_storyIndex];
    }
}
