package de.noahg_kaij.textadventure.bots;

import de.noahg_kaij.textadventure.gamelogic.IInventory;
import de.noahg_kaij.textadventure.gamelogic.IPlayer;
import de.noahg_kaij.textadventure.gamelogic.IRoundHistory;
import de.noahg_kaij.textadventure.gamelogic.MatchResult;

import java.util.HashMap;

/**
 * a swap player, just inverses his last choice
 *
 * @author noahg
 */
public final class SwapPlayer implements IPlayer
{
    /*@Override
    public String getDebugName()
    {
        return "swap";
    }*/

    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory, IPlayer enemy)
    {
        if(history.getCurrentMatch() > 0)
        {
            return ! history.getMatchResult(history.getCurrentMatch() - 1).youGave;
        }
        return true;
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
                "Mal so… Mal so… la la la la laaaa",
                null, null, null, null,
        });
        put(MatchResult.BothHeld, new String[] {
                "La la la dadidum la la la… oh. Dich hätte ich fast vergessen.",
                null, null, null, null,
        });
        put(MatchResult.OtherHeldYouGave, new String[] {
                "Halten, Geben, Ha… äh ah hallo. Du bist ja auch noch da",
                null, null, null, null,
        });
        put(MatchResult.OtherGaveYouHeld, new String[] {
                "-Ui, ich hab gewonnen?",
                null, null, null, null,
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
