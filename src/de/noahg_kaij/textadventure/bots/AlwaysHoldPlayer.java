package de.noahg_kaij.textadventure.bots;

import de.noahg_kaij.textadventure.gamelogic.IInventory;
import de.noahg_kaij.textadventure.gamelogic.IPlayer;
import de.noahg_kaij.textadventure.gamelogic.IRoundHistory;
import de.noahg_kaij.textadventure.gamelogic.MatchResult;

import java.util.HashMap;

/**
 * A simple bot that always holds
 *
 * @author Kai Jellinghaus
 */
public final class AlwaysHoldPlayer implements IPlayer
{
    /*@Override
    public String getDebugName()
    {
        return "always hold";
    }*/

    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory, IPlayer enemy)
    {
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
        put(MatchResult.BothHeld, new String[] {
                "Hast du es bemerkt?",
                "Ok, tut mir leid. Lass uns beide nett sein",
                null, null, null, null,
        });

        put(MatchResult.OtherGaveYouHeld, new String[] {
                "Oh, das tut mir aber leid… hehehe.",
                "Ups, da kam ich wohl auf den falschen Knopf ;)",
                "Du lernst es nie.",
                "Einmal meins, immer meins.",
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
