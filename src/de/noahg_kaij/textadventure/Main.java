package de.noahg_kaij.textadventure;

import de.noahg_kaij.textadventure.bots.complex.UnforgivingPlayer;
import de.noahg_kaij.textadventure.bots.simple.AlwaysGivePlayer;
import de.noahg_kaij.textadventure.bots.simple.AlwaysHoldPlayer;
import de.noahg_kaij.textadventure.gamelogic.Game;
import de.noahg_kaij.textadventure.gamelogic.GameConfiguration;
import de.noahg_kaij.textadventure.gamelogic.IPlayer;
import de.noahg_kaij.textadventure.user_interface.UIPlayer;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws Exception
    {
        var config = new GameConfiguration();

        var frame = new JFrame();
        var player = new UIPlayer(config);
        frame.add(player);
        frame.setSize(1000, 1000);
        frame.setVisible(true);

        var players = new IPlayer[] {
                new AlwaysGivePlayer(),
                new AlwaysHoldPlayer(),
                new UnforgivingPlayer(),
                player
        };
        var game = new Game(config, players);
        while (true)
        {
            game.playRound();
        }
    }
}
