package de.petermeissner.logan.misc;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Class for storing user preferences
 */
public class PreferencesHandler {

    private static final Logger log = LoggerFactory.getLogger(PreferencesHandler.class);


    /**
     * Store preferences on disk
     */
    public static void store(Preferences p) throws IOException {
        log.info("Storing preferences - start");

        JSONObject jo = new JSONObject(p);

        try (FileWriter writer = new FileWriter("settings.json")) {
            writer.write(jo.toString(2));
        }

        log.info("Storing preferences - done");
    }


    /**
     * Lods a set of preferences from disk
     *
     * @param filePath file path as string
     * @return a Prefernce Object
     * @throws IOException
     */
    public static Preferences load(String filePath) throws IOException {
        log.info("Loading preferences - start");

        // check if file exists
        if ( Files.notExists(Path.of(filePath)) ) {
            Preferences p = new Preferences();
            PreferencesHandler.store(p);
        }

        // read in preferences
        String settingsContent = Util.readTextFile(filePath);

        // set up preference object
        Preferences p = fromJSONString(settingsContent);

        // return
        log.info("Loading preferences - done");
        return p;
    }

    /**
     * Load preferences
     */
    public static Preferences load() throws IOException {
        return load("settings.json");
    }

    public static String toJSONString(Preferences p) {
        JSONObject jo = new JSONObject(p);
        return jo.toString(2);
    }

    public static Preferences fromJSONString(String s) {
        JSONObject jo = new JSONObject(s);

        Preferences p = new Preferences();
        JSONArray ds = jo.getJSONArray("directories");
        String[] da = new String[ds.length()];
        int i = 0;
        for (Object d : ds) {
            da[i] = d.toString();
            i++;
        }
        p.directories = da;
        p.regex = (String) jo.get("regex");

        return p;
    }
}
