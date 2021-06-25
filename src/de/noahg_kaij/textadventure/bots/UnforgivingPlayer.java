package de.noahg_kaij.textadventure.bots;

import de.noahg_kaij.textadventure.gamelogic.IInventory;
import de.noahg_kaij.textadventure.gamelogic.IPlayer;
import de.noahg_kaij.textadventure.gamelogic.IRoundHistory;
import de.noahg_kaij.textadventure.gamelogic.MatchResult;

import java.util.HashMap;

/**
 * An unforgiving player, always trying to cooperate, until betrayed once.
 *
 * @author Kai Jellinghaus
 */
public final class UnforgivingPlayer implements IPlayer
{

    /*@Override
    public String getDebugName()
    {
        return "unforgiving";
    }*/

    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory, IPlayer enemy)
    {
        boolean hasBeenBetrayed = false;
        for(int i = 0; i < history.getCurrentMatch(); i++)
        {
            if(history.getMatchResult(i) == MatchResult.OtherHeldYouGave || history.getMatchResult(i) == MatchResult.BothHeld)
            {
                hasBeenBetrayed = true;
                break;
            }
        }
        return ! hasBeenBetrayed;
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
                "Du bist wohl auch ein Mann der Gerechtigkeit.",
                "Du gefällst mir!",
                null, null, null, null, null, null, null, null,

        });
        put(MatchResult.BothHeld, new String[] {
                "Der Kampf zwischen Gut und Böse schreitet voran!",
                null, null, null, null,
        });
        put(MatchResult.OtherHeldYouGave, new String[] {
                "Du hast das Gesetz gebrochen!",
                "Ein Unmensch!",
                "Ich werde dich Richten!",
                null, null, null, null, null, null, null, null, null, null, null, null,
        });
        put(MatchResult.OtherGaveYouHeld, new String[] {
                "Glaub nicht ich würde auf dich hineinfallen!",
                "Es wird keine Gnade geben!",
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
