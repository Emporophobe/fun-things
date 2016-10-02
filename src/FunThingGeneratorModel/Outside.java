package FunThingGeneratorModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Li on 10/2/2016.
 */
public class Outside extends AbstractFunThing{

    private static String API_URL_BASE = "http://terminal2.expedia.com:80/x/activities/search?location=Boston&startDate=";

    private String title;
    private String price;
    private String duration;
    private String imageUrl;

    /**
     * Create an abstract fun thing with the given preferences and generate
     * a random object that meets these parameters
     *
     * @param participants the number of people that wish to do the fun thing
     * @param maxMinutes   the longest you wish to do the fun thing for
     * @param maxCost      the most you are willing to pay for the fun thing
     * @param maxDistance
     * @throws NoMatchException if there is no fun thing that matches your requirements :(
     */
    Outside(int participants, int maxMinutes, int maxCost, int maxDistance) throws NoMatchException {
        super(participants, maxMinutes, maxCost, maxDistance);
    }

    private JSONObject httpRequest() {

        Date today = new Date();
        String todayString = new SimpleDateFormat("yyyy-MM-dd").format(today);

        String query = todayString + "&endDate=" + todayString;
        String url = API_URL_BASE + query;

        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            String key = settingsParser.getValue("expedia_api_key");
            conn.setRequestProperty("Authorization", "expedia-apikey key=" + key);

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
    void generate(int participants, int maxMinutes, int maxCost, int maxDistance) throws NoMatchException {
        try {
            JSONObject json = httpRequest();
            JSONArray jsonArray = json.getJSONArray("activities");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject activity = (JSONObject) jsonArray.get(i);
                String price = activity.getString("fromPrice");
                String duration = activity.getString("duration");
                String coords = activity.getString("latLng");

                if (Integer.parseInt(price.substring(1)) <= maxCost * 25 ) {
                    this.duration = duration;
                    this.title = activity.getString("title");
                    this.price = price;
                    try {
                        this.imageUrl = activity.getString("imageURL");
                    }
                    catch(Exception e) {
                        this.imageUrl = "http://res.freestockphotos.biz/pictures/16/16836-illustration-of-a-compass-pv.png";
                    }

                    return;
                }

                throw new NoMatchException("No Matches Found");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return this.title;
    }

    @Override
    public String getInfoString() {
        return this.price + "\n" +
                this.duration;
    }

    @Override
    public String getImageSource() {
        return this.imageUrl;
    }

    public static void main(String[] args) throws NoMatchException {
        Outside outside = new Outside(2, 60, 100, 0);
        System.out.println(outside.getName());
        System.out.println(outside.getInfoString());
    }

}
