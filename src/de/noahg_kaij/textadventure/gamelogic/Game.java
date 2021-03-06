package de.noahg_kaij.textadventure.gamelogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A class representing a Game, player over multiple matches, with each match containing multiple rounds
 *
 * @author Kai Jellinghaus
 */
public final class Game
{
    private final GameConfiguration _configuration;
    private final IPlayer[] _players;
    private final InventoryImpl[] _inventories;
    private final HistoryImpl[] _histories;
    private final ArrayList<Integer> _playerIndices;
    private final Random _random;

    /**
     * Creates a new Game instance when with a given configuration and the players to participate
     * Player number must be even
     *
     * @param configuration The configuration to use
     * @param players       The players to participate in this game, length must be even
     * @throws Exception when the player count isn't even
     */
    public Game(GameConfiguration configuration, IPlayer[] players) throws Exception
    {
        if(players.length % 2 != 0)
            throw new Exception("Player Count has to be even");

        _configuration = configuration;
        _players = players;
        _inventories = new InventoryImpl[players.length];
        _playerIndices = new ArrayList<>(players.length);
        _histories = new HistoryImpl[players.length];
        for(int i = 0; i < _inventories.length; i++)
        {
            _playerIndices.add(i);
            _histories[i] = new HistoryImpl(_configuration.getMatchesPerRound());
            _inventories[i] = new InventoryImpl(_configuration.getStartingMoney());
        }
        _random = new Random();
    }

    public void playRound()
    {
        var v = _playerIndices;
        Collections.shuffle(v, _random);
        for(HistoryImpl history : _histories) history.reset();

        for(int i = 0; i < _configuration.getMatchesPerRound(); i++)
        {
            for(int j = 0; j < _players.length; j += 2)
            {
                var playerIndex1 = _playerIndices.get(j);
                var player1 = _players[playerIndex1];
                var history1 = _histories[playerIndex1];
                var inventory1 = _inventories[playerIndex1];
                var playerIndex2 = _playerIndices.get(j + 1);
                var player2 = _players[playerIndex2];
                var history2 = _histories[playerIndex2];
                var inventory2 = _inventories[playerIndex2];

                player1.preRound(player2);
                player2.preRound(player1);
                var choice1 = player1.makeChoice(history1, inventory1, player2);
                var choice2 = player2.makeChoice(history2, inventory2, player1);
                if(choice1 && choice2)
                {
                    inventory1._currentCoins += _configuration.getBothGiveReward();
                    history1.nextMatch(MatchResult.BothGave);
                    player1.postRound(player2, MatchResult.BothGave);
                    inventory2._currentCoins += _configuration.getBothGiveReward();
                    history2.nextMatch(MatchResult.BothGave);
                    player2.postRound(player1, MatchResult.BothGave);
                    // System.out.printf("%d%n played against %d%n and both gave\n", playerIndex1, playerIndex2);
                }
                else if(choice1)
                {
                    inventory1._currentCoins += _configuration.getGivingPunishment();
                    history1.nextMatch(MatchResult.OtherHeldYouGave);
                    player1.postRound(player2, MatchResult.OtherHeldYouGave);
                    inventory2._currentCoins += _configuration.getTakingReward();
                    history2.nextMatch(MatchResult.OtherGaveYouHeld);
                    player2.postRound(player1, MatchResult.OtherGaveYouHeld);
                    // System.out.printf("%d%n played against %d%n and player 1 got cheated on\n", playerIndex1, playerIndex2);
                }
                else if(choice2)
                {
                    inventory1._currentCoins += _configuration.getTakingReward();
                    history1.nextMatch(MatchResult.OtherGaveYouHeld);
                    player1.postRound(player2, MatchResult.OtherGaveYouHeld);
                    inventory2._currentCoins += _configuration.getGivingPunishment();
                    history2.nextMatch(MatchResult.OtherHeldYouGave);
                    player2.postRound(player1, MatchResult.OtherHeldYouGave);
                    // System.out.printf("%d%n played against %d%n and player 1 cheated on player 2\n", playerIndex1, playerIndex2);
                }
                else
                {
                    inventory1._currentCoins += _configuration.getBothHeldReward();
                    history1.nextMatch(MatchResult.BothHeld);
                    player1.postRound(player2, MatchResult.BothHeld);
                    inventory1._currentCoins += _configuration.getBothHeldReward();
                    history2.nextMatch(MatchResult.BothHeld);
                    player2.postRound(player1, MatchResult.BothHeld);
                    // System.out.printf("%d%n played against %d%n and they both tried cheating\n", playerIndex1, playerIndex2);
                }
            }
        }
    }

    private final class InventoryImpl implements IInventory
    {
        private final int _startingCoins;
        private int _currentCoins;

        private InventoryImpl(int startingCoins)
        {
            _startingCoins = startingCoins;
            _currentCoins = _startingCoins;
        }

        @Override
        public int getCurrentCoins()
        {
            return _currentCoins;
        }

        @Override
        public int getStartingCoins()
        {
            return _startingCoins;
        }
    }

    private final class HistoryImpl implements IRoundHistory
    {
        private final int _maxMatch;
        private final MatchResult[] _results;
        private int _currentMatch = 0;
        private MatchResult _lastRoundLastMatch;

        private HistoryImpl(int maxMatch)
        {
            _maxMatch = maxMatch;
            _results = new MatchResult[maxMatch];
        }

        @Override
        public int getCurrentMatch()
        {
            return _currentMatch;
        }

        @Override
        public int getMaxMatch()
        {
            return _maxMatch;
        }

        @Override
        public MatchResult getMatchResult(int index)
        {
            return _results[index];
        }

        @Override
        public MatchResult getLastRoundLastMatch()
        {
            return _lastRoundLastMatch;
        }

        public void reset()
        {
            _currentMatch = 0;
            _lastRoundLastMatch = _results[_maxMatch - 1];
            for(int i = 0; i < _maxMatch; i++)
                _results[i] = MatchResult.None;
        }

        public void nextMatch(MatchResult result)
        {
            _results[_currentMatch] = result;
            _currentMatch++;
        }
    }
}
