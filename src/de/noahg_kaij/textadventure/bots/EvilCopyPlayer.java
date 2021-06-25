package de.noahg_kaij.textadventure.bots;

import de.noahg_kaij.textadventure.gamelogic.MatchResult;

import java.util.HashMap;

/**
 * evil version of {@link BaseCopyPlayer}, first choice always hold
 *
 * @author noahg
 */
public final class EvilCopyPlayer extends BaseCopyPlayer
{
    /*@Override
    public String getDebugName()
    {
        return "evil copy";
    }*/

    @Override
    protected boolean defaultChoice()
    {
        return false;
    }

    private static final HashMap<MatchResult, String[]> _story = new HashMap<MatchResult, String[]>()
    {{
        put(MatchResult.BothGave, new String[] {
                "Hm, du scheinst ja wirklich ganz nett zu sein.",
                "Zweimal hintereinander so nett. Ich mag dich :)",
                null, null, null, null, null, null, null, null,
        });
        put(MatchResult.BothHeld, new String[] {
                "Und zu so jemandem soll ich freundlich sein?",
                "Ich mache nicht den ersten Schritt.",
                null, null, null, null, null, null, null, null,
        });
        put(MatchResult.OtherHeldYouGave, new String[] {
                "Wie du mir, so ich dir.",
                "Wie sagt man so schön, wer andern eine Grube gräbt…",
                "Pah… so schnell änderst du dich also?",
                null, null, null, null, null, null, null, null, null, null, null, null,
        });
        put(MatchResult.OtherGaveYouHeld, new String[] {
                "Du scheinst ja doch nicht so doof zu sein.",
                "Hätte ich das gewusst…",
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
