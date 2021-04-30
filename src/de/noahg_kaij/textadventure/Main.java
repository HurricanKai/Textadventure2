package de.noahg_kaij.textadventure;

import de.noahg_kaij.textadventure.user_interface.AbsoluteSize;
import de.noahg_kaij.textadventure.user_interface.ISizeReference;
import de.noahg_kaij.textadventure.user_interface.RelativeSize;
import de.noahg_kaij.textadventure.user_interface.SimplePaintFrame;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        var v = new SimplePaintFrame((g) -> {
            g.color(Color.RED).fillRect(abs(5), abs(5), rel(.5f), rel(.3f));
        });
        v.setSize(300, 300);
        v.setVisible(true);
    }

    private static ISizeReference abs(int val)
    {
        return new AbsoluteSize(val);
    }

    private static ISizeReference rel(float factor)
    {
        return new RelativeSize(factor);
    }
}
