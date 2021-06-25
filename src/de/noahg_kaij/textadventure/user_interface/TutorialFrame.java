package de.noahg_kaij.textadventure.user_interface;

import javax.swing.*;
import java.awt.*;

public final class TutorialFrame extends JFrame
{
    public TutorialFrame() {
        var v = new TextArea();
        v.setText("Das spiel ist simpel. In jeder runde kann man geben oder halten.\n" +
                "Das resultat ergibt sich dann wie folgt:\n" +
                "    beide geben: beide bekommen zwei münzen\n" +
                "    beide halten: beide bekommen nichts\n" +
                "    man hält und der gegner gibt: man bekommt drei münzen, der gegner verliert eine.\n" +
                "    man gibt und der gegner hält: man verliert eine münze, der gegner bekommt drei\n" +
                "\n" +
                "Die gegner haben alle namen, und rechts kann man sich notizen machen.\n" +
                "(Tipp: sie verhalten sich immer ähnlich)\n");
        v.setEditable(false);
        add(v);
        this.setSize(500, 200);
    }
}
