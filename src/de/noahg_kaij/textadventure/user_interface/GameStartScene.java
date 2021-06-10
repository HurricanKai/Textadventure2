package de.noahg_kaij.textadventure.user_interface;

import javax.swing.*;
import java.awt.*;

public final class GameStartScene implements IScene
{
    private int i = 0;
    private String[][] story;
    private SceneManager sceneManager;

    public GameStartScene()
    {
        story = new String[][]
                {
                        {
                                "Hey, ich bin AlwaysGive. Du scheinst neu in der Stadt zu sein.",
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
                                "Nein danke, ich weiß, wie es geht. (ohne Anleitung vortfahren)"
                        },
                        {
                                "In Ordnung lass uns loslegen."
                        }
                };
    }

    @Override
    public void render(BetterGraphics graphics)
    {
        graphics.color(_textCol).font(_mainFontLarge).drawString(story[i][0], new RelativeSize(0.5f), new RelativeSize(0.3f), Anchor.Center, Anchor.Center);

        BetterGraphics innerGraphics = graphics.translate(new RelativeSize(0.05f), new RelativeSize(0.4f));
        innerGraphics = innerGraphics.clip(new RelativeSize(0.95f), new RelativeSize(0.8f));
        switch (story[i].length)
        {
            case 2: Button button = new Button(new RelativeSize(0), new RelativeSize(0.2f), new RelativeSize(1), new RelativeSize(0.5f));
                    button.draw(innerGraphics.color(_frontCol));
                    button.getContentGraphics(innerGraphics).font(_mainFontLarge).color(_textCol).drawString(story[i][1], new RelativeSize(0.5f), new RelativeSize(0.5f), Anchor.Center, Anchor.Center);
                break;
            case 3: Button button1 = new Button(new RelativeSize(0), new RelativeSize(0.2f), new RelativeSize(0.4f), new RelativeSize(0.5f));
                button1.draw(innerGraphics.color(_frontCol));
                button1.getContentGraphics(innerGraphics).font(_mainFontLarge).color(_textCol).drawString(story[i][1], new RelativeSize(0.5f), new RelativeSize(0.5f), Anchor.Center, Anchor.Center);

                Button button2 = new Button(new RelativeSize(0.6f), new RelativeSize(0.2f), new RelativeSize(1f), new RelativeSize(0.5f));
                button2.draw(innerGraphics.color(_frontCol));
                button2.getContentGraphics(innerGraphics).font(_mainFontLarge).color(_textCol).drawString(story[i][2], new RelativeSize(0.5f), new RelativeSize(0.5f), Anchor.Center, Anchor.Center);
            default:
                break;
        }
    }

    @Override
    public boolean mouseClicked(int x, int y, int width, int height, int mouseButton)
    {
        if(i < story.length - 1)
        {
            i++;
            sceneManager.repaint();
            return true;
        }
        else
        {
            sceneManager.changeScene(new RoundStartScene());
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
