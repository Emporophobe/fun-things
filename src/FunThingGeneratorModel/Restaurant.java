package FunThingGeneratorModel;

import javafx.util.Pair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Query the Zomato API to get restaurants.
 */
public class Restaurant extends AbstractFunThing {

    private JSONObject chosenRestaurant;

    Restaurant(int participants, int maxMinutes, int maxCost, boolean isOutside) throws NoMatchException {
        super(participants, maxMinutes, maxCost);
    }

//    public static void main(String[] args) {
//        try {
//            Restaurant foo = new Restaurant(0, 0, 100, false);
//            //foo.generate(0, 0, 0, false);
//            System.out.println(foo.getName());
//            System.out.println(foo.getInfoString());
//        } catch (NoMatchException e) {
//            e.printStackTrace();
//        }
//    }

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
        String query = String.format("search?count=100&lat=%f&lon=%f&radius=%d", coords.getKey(), coords.getValue(), 1000);
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

            JSONObject json = null;
            try {
                json = new JSONObject(response.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return json;


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    void generate(int participants, int maxMinutes, int maxCost) throws NoMatchException {
        JSONObject json = httpRequest();
        try {
            JSONArray restaurants = json.getJSONArray("restaurants");
            List<JSONObject> matches = new ArrayList<>();
            for (int i = 0; i < restaurants.length(); i++) {
                JSONObject restaurant = (JSONObject) restaurants.get(i);
                JSONObject rest = (JSONObject) restaurant.get("restaurant");
                if (rest.getInt("average_cost_for_two") / 2 <= maxCost) {
                    matches.add(rest);
                }
            }
            if (matches.size() > 0) {
                chosenRestaurant = matches.get(new Random().nextInt(matches.size()));
            } else {
                throw new NoMatchException("No matching restaurants");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        try {
            return chosenRestaurant.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
            return "NO NAME";
        }
    }

    @Override
    public String getInfoString() {
        try {
            String sb = chosenRestaurant.get("cuisines") +
                    "\n\n" +
                    ((JSONObject) chosenRestaurant.get("location")).get("address");

            return sb;
        } catch (JSONException e) {
            e.printStackTrace();
            return "NO INFO";
        }
    }
}
