package de.petermeissner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 */
public class util {

    /**
     * Simple convenience function to check string for regex match
     *
     * @param string String to check - haystack.
     * @param pattern Pattern to search for - needle.
     * @return True for a match and false for a non match
     */
    public static boolean strMatches(String string, String pattern){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(string);
        return m.matches();
    }

    /**
     * Checks and potentially handles object that might be NULL.
     *
     * @param obj Object to be checked
     * @param objClass (optional)
     * @param message (optional) a message to log in case of NullPointerException
     * @param defaultObj (optional) a default instance of the object to check
     *
     * @param <T> type of obj
     *
     * @return returns the object if not NULL, the default provided, or logs message and throws NullPointerException
     */
    public static <T> T checkNull(T obj, String objClass, String message, T defaultObj) {
        if (obj == null) {

            // logging
            Logger logger = LoggerFactory.getLogger(objClass);
            StringJoiner strJoin = new StringJoiner(" - ");
            String e = strJoin.add("CheckNull() found object to be NULL, using default").add(message).toString();
            logger.error(e);

            // exception
            return checkNull(defaultObj, objClass, "Default provided was NULL too.");
        } else {
            return obj;
        }
    }
    public static <T> T checkNull(T obj, String objClass, String message) {
        if (obj == null) {

            // logging
            Logger logger = LoggerFactory.getLogger(objClass);
            StringJoiner strJoin = new StringJoiner(" - ");
            String e = strJoin.add("CheckNull() found object to be NULL").add(message).toString();
            logger.error(e);

            // exception
            throw new NullPointerException();
        } else {
            return obj;
        }
    }

    /**
     * See: {@link #checkNull(Object, String, String)} for documentation
     */
    public static <T> T checkNull(T obj) {
        return checkNull(obj, "--", "");
    }


    /**
     * See: {@link #checkNull(Object, String, String)} for documentation
     */
    public static <T> T checkNull(T obj, String objClass) {
        return checkNull(obj, objClass, "");
    }






    /**
     * Function to format a string
     *
     * @param s string to be formatted
     * @param bold string should be bold?
     * @param cursive string should be cursive?
     *
     * @return a formatted string
     */
    public static String formatMe(String s, boolean bold, boolean cursive){
        String res = s;

        // handle bold option
        if (bold) {
            res = "BOLD" + res + "BOLD";
        }

        // handle cursive option
        if (cursive) {
            res = "CURSIVE" + res + "CURSIVE";
        }

        // return
        return res;
    }


    /**
     * See: {@link #formatMe(String, boolean, boolean)} for documentation
     */
    public static String formatMe(){
        return formatMe("", false, false);
    }

    /**
     * See: {@link #formatMe(String, boolean, boolean)} for documentation
     */
    public static String formatMe(String s){
        return formatMe(s, false, false);
    }
}
