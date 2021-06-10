package de.noahg_kaij.textadventure.user_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class PlayerDataScene implements IScene
{
    private static final Color _selectedText = Color.YELLOW;

    private final PlayerData playerData;

    public PlayerDataScene(PlayerData playerData)
    {
        this.playerData = playerData;
    }

    @Override
    public void render(BetterGraphics graphics)
    {
        graphics.color(_textCol).font(_mainFontMegaLarge).drawString(playerData.getName(), new RelativeSize(0.5f), new RelativeSize(0.1f), Anchor.Center, Anchor.Center);

        var notebook = graphics.translate(new RelativeSize(0.1f), new RelativeSize(0.1f))
                .clip(new RelativeSize(0.9f), new RelativeSize(0.9f));

        notebook.color(_frontCol).fillRect(new RelativeSize(0.0f), new RelativeSize(0.0f), new RelativeSize(1.0f), new RelativeSize(1.0f));

        var absh = notebook.getAbsoluteHeight();
        var fm = notebook.getFontMetrics(_mainFontLarge);
        var h = fm.getHeight();
        var notes = playerData.getNotes();

        for(int i = 0; i < notes.size() && (i + 1) * h < absh; i++)
        {
            if(fm.stringWidth(notes.get(i)) > notebook.getAbsoluteWidth() * 2)
                notes.set(i, "");

            BetterGraphics g;
            if(i == playerData.getNoteLineSelected())
                g = notebook.color(_selectedText);
            else
                g = notebook.color(_textCol);
            g.drawLine(new RelativeSize(0), new AbsoluteSize((i + 1) * h), new RelativeSize(1.0f), new AbsoluteSize((i + 1) * h));
            g.drawString(notes.get(i), new RelativeSize(0.5f), new AbsoluteSize((i + 1) * h), Anchor.Center, Anchor.Center);
        }
    }

    @Override
    public boolean mouseClicked(int x, int y, int width, int height, int mouseButton)
    {
        return false;
    }

    @Override
    public void enable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap)
    {
        for(int i = 0; i < 128; i++)
        {
            if(Character.isLetterOrDigit(i) || Character.isSpaceChar(i))
            {
                var c = (char)i;
                inputMap.put(KeyStroke.getKeyStroke(c), "INPUT_" + c);
                actionMap.put("INPUT_" + c, new AbstractAction()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        playerData.getNotes().set(playerData.getNoteLineSelected(), playerData.getNotes().get(playerData.getNoteLineSelected()) + c);
                        sceneManager.repaint();
                    }
                });
            }
        }

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UP");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DOWN");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "ENTER");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "BACKSPACE");
        actionMap.put("UP", new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(playerData.getNoteLineSelected() > 0)
                    playerData.setNoteLineSelected(playerData.getNoteLineSelected() - 1);
                sceneManager.repaint();
            }
        });

        actionMap.put("DOWN", new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(playerData.getNoteLineSelected() < playerData.getNotes().size() - 1)
                    playerData.setNoteLineSelected(playerData.getNoteLineSelected() + 1);
                sceneManager.repaint();
            }
        });

        actionMap.put("ENTER", new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                playerData.setNoteLineSelected(playerData.getNoteLineSelected() + 1);
                playerData.getNotes().add(playerData.getNoteLineSelected(), "AAA");
                sceneManager.repaint();
            }
        });

        actionMap.put("BACKSPACE", new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                var x = playerData.getNotes().get(playerData.getNoteLineSelected());
                if(x.length() == 0)
                    return;
                playerData.getNotes().set(playerData.getNoteLineSelected(), x.substring(0, x.length() - 1));
                sceneManager.repaint();
            }
        });
    }

    @Override
    public void disable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap)
    {
        inputMap.remove(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0));
        inputMap.remove(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0));
        inputMap.remove(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
        inputMap.remove(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0));

        for(int i = 0; i < 128; i++)
        {
            if(Character.isLetterOrDigit(i) || Character.isSpaceChar(i))
            {
                var c = (char)i;
                inputMap.remove(KeyStroke.getKeyStroke(c));
            }
        }
    }
}
