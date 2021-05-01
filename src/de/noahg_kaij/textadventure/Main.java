package de.noahg_kaij.textadventure;

import de.noahg_kaij.textadventure.user_interface.UIPlayer;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        var frame = new JFrame();
        var player = new UIPlayer();
        frame.add(player);
        frame.setSize(1000, 1000);
        frame.setVisible(true);

        while(true)
        {
            System.out.println(player.makeChoice(null, null));
        }
    }
}
