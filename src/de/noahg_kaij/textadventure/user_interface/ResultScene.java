package de.noahg_kaij.textadventure.user_interface;

import de.noahg_kaij.textadventure.gamelogic.GameConfiguration;
import de.noahg_kaij.textadventure.gamelogic.MatchResult;

import javax.swing.*;
import java.awt.*;

public final class ResultScene implements IScene
{
    private final MatchResult _matchResult;
    private final GameConfiguration _gameConfiguration;
    private SceneManager _sceneManager;

    public ResultScene(MatchResult matchResult, GameConfiguration gameConfiguration)
    {

        _matchResult = matchResult;
        _gameConfiguration = gameConfiguration;
    }

    @Override
    public void render(BetterGraphics graphics)
    {
        String actionStr;
        int reward;
        // TODO: better text!
        Color color;
        if(_matchResult == MatchResult.BothGave)
        {
            actionStr = "You Both Gave";
            reward = _gameConfiguration.getBothGiveReward();
            color = _green;
        }
        else if(_matchResult == MatchResult.OtherHeldYouGave)
        {
            actionStr = "Other Held, You Gave";
            reward = _gameConfiguration.getGivingPunishment();
            color = _red;
        }
        else if(_matchResult == MatchResult.OtherGaveYouHeld)
        {
            actionStr = "Other Gave, You Held";
            reward = _gameConfiguration.getTakingReward();
            color = _green;
        }
        else if(_matchResult == MatchResult.BothHeld)
        {
            actionStr = "You both tried taking";
            reward = _gameConfiguration.getBothHeldReward();
            color = _red;
        }
        else
        {
            actionStr = "?????";
            reward = 0;
            color = _frontCol;
        }

        graphics.color(color).fillRect(new RelativeSize(0.2f), new RelativeSize(0.2f),
                new RelativeSize(0.6f), new RelativeSize(0.6f));
        graphics.color(_textCol).font(_mainFontLarge).drawString(actionStr, new RelativeSize(0.5f), new RelativeSize(0.46f), Anchor.Center, Anchor.Center);
        graphics.color(_textCol).font(_mainFontLarge).drawString((reward >= 0 ? "+" : "") + reward + " Coins", new RelativeSize(0.5f), new RelativeSize(0.54f), Anchor.Center, Anchor.Center);
        graphics.color(_textCol).font(_mainFontSmall).drawString("(Click to Continue)", new RelativeSize(0.5f), new AdditionSize(new RelativeSize(0.2f), new RelativeSize(0.6f)), Anchor.Center, Anchor.Negative);

        // right.color(_yellow).drawString("Coins: " + _inventory.getCurrentCoins() + "/" + _inventory.getStartingCoins(), new RelativeSize(0.95f), new RelativeSize(0.01f), Anchor.Negative, Anchor.Positive);
    }

    @Override
    public boolean mouseClicked(int x, int y, int width, int height, int mouseButton)
    {
        _sceneManager.changeScene(new RoundStartScene());
        return true;
    }

    @Override
    public void enable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap)
    {
        _sceneManager = sceneManager;
    }

    @Override
    public void disable(SceneManager sceneManager, InputMap inputMap, ActionMap actionMap)
    {
        _sceneManager = sceneManager;
    }
}
