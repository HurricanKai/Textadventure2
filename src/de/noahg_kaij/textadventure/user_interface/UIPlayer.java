package de.noahg_kaij.textadventure.user_interface;

import de.noahg_kaij.textadventure.gamelogic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.HashMap;
import java.util.Map;

// !!! NOTE: THIS SHOULD BE THE ONLY PLACE THE USER_INTERFACE PACKAGE INTERACTS WITH THE GAMELOGIC PACKAGE !!!
/**
 * An implementation of {@link de.noahg_kaij.textadventure.gamelogic.IPlayer} using UI displayed to the user.
 * This class only serves as the in-game UI. The menu, game mode selection, rule config, etc. are different, and do not interact with {@link de.noahg_kaij.textadventure.gamelogic} directly.
 * @author Kai Jellinghaus
 * @author noahg
 */
public final class UIPlayer extends JComponent implements IPlayer
{
    /**
     * private nested class keeping track of player-related data.
     * @author Kai Jellinghaus
     */
    private final class PlayerData
    {

    }

    private final GameConfiguration _gameConfiguration;
    private final SceneManager _sceneManager;

    private IRoundHistory _history;
    private IInventory _inventory;
    private IPlayer _enemy;
    private PlayerData _enemyData;
    private Map<IPlayer, PlayerData> _playerData = new HashMap<>();

    /**
     * Initializes a new UIPlayer with the given configuration
     * @param gameConfiguration The configuration to use
     */
    public UIPlayer(GameConfiguration gameConfiguration)
    {
        _gameConfiguration = gameConfiguration;
        _sceneManager = new SceneManager(new StartScene(), this);

        this.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);
                UIPlayer.this.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e)
            {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e)
            {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                super.mouseMoved(e);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        var betterGraphics = new BetterGraphics(g);

        betterGraphics.color(IScene._backCol).fillRect(new AbsoluteSize(0), new AbsoluteSize(0), new RelativeSize(1.0f), new RelativeSize(1.0f));
        var bounds = this.getBounds();
        betterGraphics = betterGraphics.translate(new AbsoluteSize(bounds.x), new AbsoluteSize(bounds.y)).clip(new AbsoluteSize(bounds.width), new AbsoluteSize(bounds.height));

        _sceneManager.getCurrentScene().render(betterGraphics);

        var debugName = "NULL";
        if (_enemy != null)
            debugName = _enemy.getDebugName();
        // right.font(IScene._debugFont).color(Color.pink).drawString(debugName, new RelativeSize(0.99f), new RelativeSize(0.1f), Anchor.Negative, Anchor.Center);
    }

    void mouseClicked(MouseEvent e)
    {
        if (_sceneManager.getCurrentScene().mouseClicked(e.getX(), e.getY(), this.getWidth(), this.getHeight(), e.getButton()))
            e.consume();
    }

    @Override
    public void preRound(IPlayer enemy)
    {
        if (!_playerData.containsKey(enemy))
            _playerData.put(enemy, new PlayerData());
    }

    @Override
    public void postRound(IPlayer enemy, MatchResult matchResult)
    {
        _sceneManager.changeScene(new ResultScene(matchResult, _gameConfiguration));
    }

    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory, IPlayer enemy)
    {
        while(!(_sceneManager.getCurrentScene() instanceof StartScene))
        {
            Thread.onSpinWait();
        }

        var decisionScene = new DecisionScene();
        _sceneManager.changeScene(new SplitScene(decisionScene, null));
        _history = history;
        _inventory = inventory;
        _enemy = enemy;
        _enemyData = _playerData.get(enemy);
        repaint();

        while (!decisionScene.hasDecision())
        {
            Thread.onSpinWait();
        }

        return decisionScene.getDecision();
    }

    @Override
    public String getDebugName()
    {
        return "REAL PLAYER";
    }
}
