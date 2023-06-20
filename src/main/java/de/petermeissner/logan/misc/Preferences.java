package de.petermeissner.logan.misc;

/**
 *  Class for storing user preferences
 */
public class Preferences {
    public String[] getDirectories() {
        return directories;
    }

    public String getRegex() {
        return regex;
    }

    public Preferences() {
        directories = new String[]{"."};
        regex = ".*";
    }

    public String[] directories;
    public String regex;

}
