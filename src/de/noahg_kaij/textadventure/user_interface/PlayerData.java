package de.noahg_kaij.textadventure.user_interface;

import de.noahg_kaij.textadventure.gamelogic.IPlayer;

import java.util.ArrayList;

/**
 * Represents a collection of player data
 *
 * @author Kai Jellinghaus
 */
public final class PlayerData
{
    private final IPlayer _player;
    private final ArrayList<String> _notes;
    private int _noteLineSelected = 0;

    public PlayerData(IPlayer player)
    {
        _player = player;
        _notes = new ArrayList<>();
        _notes.add("TEST");
        _notes.add("TEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEST");
    }

    public String getName()
    {
        return _player.getDebugName();
    }

    public ArrayList<String> getNotes()
    {
        return _notes;
    }

    public int getNoteLineSelected()
    {
        return _noteLineSelected;
    }

    public void setNoteLineSelected(int _noteLineSelected)
    {
        this._noteLineSelected = _noteLineSelected;
    }
}
