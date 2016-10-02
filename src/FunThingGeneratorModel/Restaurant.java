package FunThingGeneratorModel;

import javafx.util.Pair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Query the Zomato API to get restaurants.
 */
public class Restaurant extends AbstractFunThing {

    Restaurant(int participants, int maxMinutes, int maxCost, boolean isOutside) throws NoMatchException {
        super(participants, maxMinutes, maxCost, isOutside);
    }

    public static void main(String[] args) {
        try {
            Restaurant foo = new Restaurant(0, 0, 0, false);
            foo.generate(0, 0, 0, false);
        } catch (NoMatchException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the latitude/longitude of the user
     * TODO: make this actually work
     *
     * @return A pair (latitude, longitude)
     */
    private Pair<Double, Double> getCoords() {
        return new Pair<>(42.338516, -71.092326);
    }

    /**
     * Make an API call to Zomato to get restaurants in the area.
     *
     * @return The JSON response
     */
    private JSONObject httpRequest() {
        Pair<Double, Double> coords = getCoords();

        String zomatoApiBaseUrl = "https://developers.zomato.com/api/v2.1/";
        String query = String.format("search?lat=%f&lon=%f&radius=%d", coords.getKey(), coords.getValue(), 1000);
        String url = zomatoApiBaseUrl + query;

        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            String key = settingsParser.getKey("zomato_api_key");
            conn.setRequestProperty("user-key", key);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(response);

            return json;


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    void generate(int participants, int maxMinutes, int maxCost, boolean isOutside) throws NoMatchException {
        JSONObject json = httpRequest();

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getInfoString() {
        return null;
    }
}
