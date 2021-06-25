package de.noahg_kaij.textadventure.gamelogic;

public final class NameGen
{
    private static final String[] _names = new String[] {
            "Klara Zufall",
            "Ben Dover",
            "Reiner Zufall",
            "Peter",
            "Hans",
            "Johanna",
            "Markus",
            "Merlin",
            "Thomas",
            "Steffan",
            "Luisa",
            "Hannah",
            "Karl"
    };
    private static int _i = 0;

    public static String getName() {
        return _names[_i++];
    }
}
