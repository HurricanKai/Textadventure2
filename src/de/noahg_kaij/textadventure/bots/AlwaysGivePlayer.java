package de.noahg_kaij.textadventure.bots;

import de.noahg_kaij.textadventure.gamelogic.IInventory;
import de.noahg_kaij.textadventure.gamelogic.IPlayer;
import de.noahg_kaij.textadventure.gamelogic.IRoundHistory;
import de.noahg_kaij.textadventure.gamelogic.MatchResult;

import java.util.HashMap;
import java.util.HashSet;

/**
 * A simple bot, that always gives.
 *
 * @author Kai Jellinghaus
 */
public final class AlwaysGivePlayer implements IPlayer
{
    /*@Override
    public String getDebugName()
    {
        return "always give";
    }*/

    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory, IPlayer enemy)
    {
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
                "Und ich dachte schon ich bin die Einzige, die auch an andere denkt.",
                "Ich glaube wir könnten Freunde werden. :)",
                null, null, null, null, null,
        });

        put(MatchResult.OtherHeldYouGave, new String[] {
                "Vielleicht war es ja ein aus Versehen :/",
                "Ich denke in jedem steckt auch eine gute Seite ^^",
                null, null, null, null, null,
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
