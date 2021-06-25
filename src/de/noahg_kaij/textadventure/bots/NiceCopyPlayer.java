package de.noahg_kaij.textadventure.bots;

import de.noahg_kaij.textadventure.gamelogic.MatchResult;

import java.util.HashMap;

/**
 * nice version of {@link BaseCopyPlayer}, first choice always give
 *
 * @author noahg
 */
public final class NiceCopyPlayer extends BaseCopyPlayer
{
    /*@Override
    public String getDebugName()
    {
        return "nice copy";
    }*/

    @Override
    protected boolean defaultChoice()
    {
        return true;
    }

    private static final HashMap<MatchResult, String[]> _story = new HashMap<MatchResult, String[]>()
    {{
        put(MatchResult.BothGave, new String[] {
                null
        });
        put(MatchResult.BothHeld, new String[] {
                null
        });
        put(MatchResult.OtherHeldYouGave, new String[] {
                null
        });
        put(MatchResult.OtherGaveYouHeld, new String[] {
                null
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
