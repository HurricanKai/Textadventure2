package de.noahg_kaij.textadventure.user_interface;

import de.noahg_kaij.textadventure.gamelogic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

// !!! NOTE: THIS SHOULD BE THE ONLY PLACE THE USER_INTERFACE PACKAGE INTERACTS WITH THE GAMELOGIC PACKAGE !!!
/**
 * An implementation of {@link de.noahg_kaij.textadventure.gamelogic.IPlayer} using UI displayed to the user.
 * This class only serves as the in-game UI. The menu, game mode selection, rule config, etc. are different, and do not interact with {@link de.noahg_kaij.textadventure.gamelogic} directly.
 * @author Kai Jellinghaus
 */
public final class UIPlayer extends JComponent implements IPlayer
{
    private static final Font _mainFont = new Font("Arial", Font.PLAIN, 12);
    private static final Font _mainFontSmall = _mainFont.deriveFont(15f);
    private static final Font _mainFontLarge = _mainFont.deriveFont(25f);
    private static final Font _mainFontMegaLarge = _mainFont.deriveFont(40f);

    private static final Color _backCol = new Color(39, 41, 50);
    private static final Color _frontCol = new Color(72, 61, 63);
    private static final Color _red = new Color(255, 85, 64);
    private static final Color _yellow = new Color(236, 192, 91);
    private static final Color _green = new Color(114, 151, 117);
    private static final Color _textCol = _frontCol;

    private static final ISizeReference _giveButtonX = new RelativeSize(0.1f);
    private static final ISizeReference _giveButtonY = new RelativeSize(0.05f);
    private static final ISizeReference _giveButtonWidth = new RelativeSize(0.8f);
    private static final ISizeReference _giveButtonHeight = new RelativeSize(0.35f);

    private static final ISizeReference _keepButtonX = new RelativeSize(0.1f);
    private static final ISizeReference _keepButtonY = new RelativeSize(0.55f);
    private static final ISizeReference _keepButtonWidth = new RelativeSize(0.8f);
    private static final ISizeReference _keepButtonHeight = new RelativeSize(0.35f);

    private static final ISizeReference _resultButtonX = new RelativeSize(0.2f);
    private static final ISizeReference _resultButtonY = new RelativeSize(0.2f);
    private static final ISizeReference _resultButtonWidth = new RelativeSize(0.6f);
    private static final ISizeReference _resultButtonHeight = new RelativeSize(0.6f);

    private final GameConfiguration _gameConfiguration;

    private int _currentState = 0;
    private IRoundHistory _history;
    private IInventory _inventory;
    private boolean _hasMadeDecision = false;
    private boolean _decision = false;

    public UIPlayer(GameConfiguration gameConfiguration)
    {
        _gameConfiguration = gameConfiguration;
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
        betterGraphics.color(_backCol).fillRect(new AbsoluteSize(0), new AbsoluteSize(0), new RelativeSize(1.0f), new RelativeSize(1.0f));
        var bounds = this.getBounds();
        betterGraphics = betterGraphics.translate(new AbsoluteSize(bounds.x), new AbsoluteSize(bounds.y)).clip(new AbsoluteSize(bounds.width), new AbsoluteSize(bounds.height));
        var left = betterGraphics.clip(new RelativeSize(0.5f), new RelativeSize(1.0f));
        var right = betterGraphics.translate(new RelativeSize(0.5f), new AbsoluteSize(0));

        if (_currentState == 0) // waiting
        {
            betterGraphics.font(_mainFontMegaLarge).color(_textCol).drawString("Waiting for Round to start ...", new RelativeSize(0.5f), new RelativeSize(0.5f), Anchor.Center, Anchor.Center);
        }
        else if (_currentState == 1) // needs to make a decision
        {
            left.color(_frontCol).fillRect(_giveButtonX, _giveButtonY, _giveButtonWidth, _giveButtonHeight);
            left.color(_frontCol).fillRect(_keepButtonX, _keepButtonY, _keepButtonWidth, _keepButtonHeight);

            right.color(_yellow).drawString("Coins: " + _inventory.getCurrentCoins() + "/" + _inventory.getStartingCoins(), new RelativeSize(0.95f), new RelativeSize(0.01f), Anchor.Negative, Anchor.Positive);
        }
        else if (_currentState == 2)
        {
            // TODO: on the last round, this will happen, since _history has already been overriden and the last match will never display

            var currentIndex = _history.getCurrentMatch();
            if (currentIndex == 0)
            {
                left.drawString("THIS SHOULD NOT HAVE HAPPENED", new RelativeSize(0.5f), new RelativeSize(0.5f), Anchor.Center, Anchor.Center);
                return;
            }

            var result = _history.getMatchResult(_history.getCurrentMatch() - 1);
            String actionStr;
            int reward;
            // TODO: better text!
            Color color;
            if (result == MatchResult.BothGive)
            {
                actionStr = "You Both Gave";
                reward = _gameConfiguration.getBothGiveReward();
                color = _green;
            }
            else if (result == MatchResult.OtherHeldYouGave)
            {
                actionStr = "Other Held, You Gave";
                reward = _gameConfiguration.getGivingPunishment();
                color = _red;
            }
            else if (result == MatchResult.OtherGaveYouHeld)
            {
                actionStr = "Other Gave, You Held";
                reward = _gameConfiguration.getTakingReward();
                color = _green;
            }
            else if (result == MatchResult.BothHeld)
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


            left.color(color).fillRect(_resultButtonX, _resultButtonY, _resultButtonWidth, _resultButtonHeight);
            left.color(_textCol).font(_mainFontLarge).drawString(actionStr, new RelativeSize(0.5f), new RelativeSize(0.46f), Anchor.Center, Anchor.Center);
            left.color(_textCol).font(_mainFontLarge).drawString((reward >= 0 ? "+" : "") + reward + " Coins", new RelativeSize(0.5f), new RelativeSize(0.54f), Anchor.Center, Anchor.Center);
            left.color(_textCol).font(_mainFontSmall).drawString("(Press to Continue)", new RelativeSize(0.5f), new AdditionSize(_resultButtonY, _resultButtonHeight), Anchor.Center, Anchor.Negative);

            right.color(_yellow).drawString("Coins: " + _inventory.getCurrentCoins() + "/" + _inventory.getStartingCoins(), new RelativeSize(0.95f), new RelativeSize(0.01f), Anchor.Negative, Anchor.Positive);
        }
    }

    void mouseClicked(MouseEvent e)
    {
        var button = e.getButton();
        if (button == MouseEvent.BUTTON1)
        {
            var x = e.getX();
            var y = e.getY();

            if (_currentState == 1)
            {
                // keep button
                {
                    var absKeepX = _keepButtonX.getValue(this.getWidth());
                    var absKeepWidth = _keepButtonWidth.getValue((int) (this.getWidth() * 0.5f));
                    var absKeepY = _keepButtonY.getValue(this.getHeight());
                    var absKeepHeight = _keepButtonHeight.getValue(this.getHeight());
                    if (x > absKeepX && x < (absKeepX + absKeepWidth) && y > absKeepY && y < (absKeepY + absKeepHeight))
                    {
                        _decision = false;
                        _hasMadeDecision = true;
                        e.consume();
                        return;
                    }
                }

                // give
                {
                    var absGiveX = _giveButtonX.getValue(this.getWidth());
                    var absGiveWidth = _giveButtonWidth.getValue(this.getWidth());
                    var absGiveY = _giveButtonY.getValue(this.getHeight());
                    var absGiveHeight = _giveButtonHeight.getValue(this.getHeight());
                    if (x > absGiveX && x < (absGiveX + absGiveWidth) && y > absGiveY && y < (absGiveY + absGiveHeight))
                    {
                        _decision = true;
                        _hasMadeDecision = true;
                        e.consume();
                        return;
                    }
                }
            }
            else if (_currentState == 2)
            {
                var absX = _resultButtonX.getValue(this.getWidth());
                var absY = _resultButtonY.getValue(this.getHeight());
                var absWidth = _resultButtonWidth.getValue(this.getWidth());
                var absHeight = _resultButtonHeight.getValue(this.getHeight());
                if (x > absX && x < (absX + absWidth) && y > absY && y < (absY + absHeight))
                {
                    _currentState = 0;
                    repaint();
                    e.consume();
                    return;
                }
            }
        }
    }

    @Override
    public boolean makeChoice(IRoundHistory history, IInventory inventory)
    {
        while(_currentState != 0)
        {
            Thread.onSpinWait();
        }

        _currentState = 1;
        _history = history;
        _inventory = inventory;
        repaint();

        _hasMadeDecision = false;

        while (!_hasMadeDecision)
        {
            Thread.onSpinWait();
        }

        _currentState = 2;
        repaint();

        return _decision;
    }
}
