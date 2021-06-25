package de.noahg_kaij.textadventure.user_interface;

import javax.swing.*;
import java.awt.*;

public final class GameStartScene implements IScene
{
    private int i = 0;
    private String[][] story;
    private SceneManager sceneManager;
    private Button[] _buttons;

    public GameStartScene()
    {
        story = new String[][]
                {
                        {
                                "Du scheinst neu in der Stadt zu sein.",
                                "Merkt man das?",
                                "Ja, woher weißt du das?"
                        },
                        {
                                "Naja, hier spielen alle Scral.",
                                "Scral?"
                        },
                        {
                                "Ja, ein ganz einfaches spiel."
                        },
                        {
                                "Soll ich es dir erklären?",
                                "Ja gerne. (Anleitung ansehen)",
                                "Nein danke."
                        },
                        {
                                "In Ordnung lass uns loslegen."
                        }
                };
        OnStoryChange();
    }

    @Override
    public void render(BetterGraphics graphics)
    {
        graphics.color(_textCol).font(_mainFontLarge).drawString(story[i][0], new RelativeSize(0.5f), new RelativeSize(0.3f), Anchor.Center, Anchor.Center);

        int g = 1;
        for(var b : _buttons) {
            b.draw(graphics.color(_frontCol));
            b.getContentGraphics(graphics).font(_mainFontLarge).color(_textCol).drawString(story[i][g], new RelativeSize(0.5f), new RelativeSize(0.5f), Anchor.Center, Anchor.Center);            b.getContentGraphics(graphics).font(_mainFontLarge).color(_textCol).drawString(story[i][g], new RelativeSize(0.5f), new RelativeSize(0.5f), Anchor.Center, Anchor.Center);
            g++;
        }
    }

    private void OnStoryChange()
    {
        switch (story[i].length)
        {
            case 1:
                _buttons = new Button[0];
                break;
            case 2:
                Button button = new Button(new RelativeSize(0.05f), new RelativeSize(0.6f), new RelativeSize(0.95f), new RelativeSize(0.8f));
                _buttons = new Button[] { button };
                break;
            case 3:
                Button button1 = new Button(new RelativeSize(0.05f), new RelativeSize(0.6f), new RelativeSize(0.4f), new RelativeSize(0.8f));
                Button button2 = new Button(new RelativeSize(0.55f), new RelativeSize(0.6f), new RelativeSize(0.8f), new RelativeSize(0.8f));
                _buttons = new Button[]{ button1, button2};
                break;
            default:
                throw new RuntimeException();
        }
    }

    @Override
    public boolean mouseClicked(int x, int y, int width, int height, int mouseButton)
    {
        if(i < story.length - 1)
        {
            if (_buttons.length == 0)
            {
                i++;
                OnStoryChange();
                sceneManager.repaint();
                return true;
            }
            int g = 0;
            for (var b : _buttons)
            {
                if (b.contains(x, y, width, height))
                {

                    if (i == 3) {
                        if (g == 0) {
                            var f = new TutorialFrame();
                            f.setVisible(true);
                            f.setTitle("Tutorial");
                        }
                    }
                    i++;
                    OnStoryChange();
                    sceneManager.repaint();
                    return true;
                }
                g++;
            }
        }
        else
        {
            sceneManager.changeScene(new RoundStartScene());
            return true;
        }
        return false;
    }

    @Override
    public void enable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap)
    {
        this.sceneManager = sceneManager;
    }

    @Override
    public void disable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap)
    {
        this.sceneManager = null;
    }
}
