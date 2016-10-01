package FunThingGeneratorModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Read the values in the settings file
 */
public class settingsParser {
    /**
     * Get the value in the settings file matching the given key
     *
     * @param key The key to search for
     * @return The value of the setting; "NO_VALUE" if no value, or empty string if exception occurred.
     */
    public static String getKey(String key) {
        try {
            File apiKeys = new File("settings.yaml");
            BufferedReader reader = new BufferedReader(new FileReader(apiKeys));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                if (words[0].equals(key + ":")) {
                    // add 2 for the colon and the space after
                    return line.substring(words[0].length() + 2);
                }
            }
            return "NO_VALUE";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}