package de.noahg_kaij.textadventure.gamelogic;

public final class GameConfiguration
{
    private int _startingMoney = 0;
    private int _matchesPerRound = 5;
    private int _bothGiveReward = 2;
    private int _takingReward = 3;
    private int _givingPunishment = -1;
    private int _bothTookReward = 0;

    /**
     * @return The amount of money each player starts with
     */
    public int getStartingMoney()
    {
        return _startingMoney;
    }

    /**
     * @param startingMoney The amount of money each player starts with
     */
    public void setStartingMoney(int startingMoney)
    {
        this._startingMoney = startingMoney;
    }

    /**
     * @return The count of matches played each round
     */
    public int getMatchesPerRound()
    {
        return _matchesPerRound;
    }

    /**
     * @param matchesPerRound The count of matches played each round
     */
    public void setMatchesPerRound(int matchesPerRound)
    {
        this._matchesPerRound = matchesPerRound;
    }

    /**
     * @return The reward given to both players when both gave
     */
    public int getBothGiveReward()
    {
        return _bothGiveReward;
    }

    /**
     * @param bothGiveReward The reward given to both players when both gave
     */
    public void setBothGiveReward(int bothGiveReward)
    {
        this._bothGiveReward = bothGiveReward;
    }

    /**
     * @return The reward given to the player that took when the other gave
     */
    public int getTakingReward()
    {
        return _takingReward;
    }

    /**
     * @param takingReward The reward given to the player that took when the other gave
     */
    public void setTakingReward(int takingReward)
    {
        this._takingReward = takingReward;
    }

    /**
     * @return The punishment given to the player that gave when the other took
     */
    public int getGivingPunishment()
    {
        return _givingPunishment;
    }

    /**
     * @param givingPunishment The punishment given to the player that gave when the other took
     */
    public void setGivingPunishment(int givingPunishment)
    {
        this._givingPunishment = givingPunishment;
    }

    /**
     * @return The reward given to both players when both took
     */
    public int getBothTookReward()
    {
        return _bothTookReward;
    }

    /**
     * @param bothTookReward The reward given to both players when both took
     */
    public void setBothTookReward(int bothTookReward)
    {
        this._bothTookReward = bothTookReward;
    }
}