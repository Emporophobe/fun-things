package FunThingGeneratorModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by Li on 10/1/2016.
 *
 * A movie Fun thing
 */
public class Movie extends AbstractFunThing{

    private static final String RANDOM_MOVIE_API = "https://random-movie.herokuapp.com/random";

    private String title;
    private String genre;
    private String plotSummary;
    private int runtime;
    private String urlToPoster;

    public Movie(int participants, int maxMinutes, int maxCost, boolean isOutside) throws NoMatchException {
        super(participants, maxMinutes, maxCost, isOutside);
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) throws IOException, JSONException, NoMatchException {
        Movie movie = new Movie(0, 90, 0, true);
        System.out.println(movie.getName());
        System.out.println(movie.getInfoString());
    }

    @Override
    void generate(int participants, int maxMinutes, int maxCost, boolean isOutside) {

        int counter = 0;

        while (counter < 50) {
            try {
                JSONObject json = readJsonFromUrl(RANDOM_MOVIE_API);

                String minutes = json.getString("Runtime");
                int tempRuntime = Integer.parseInt(minutes.substring(0, minutes.length() - 4));
                if (tempRuntime <= maxMinutes) {
                    title = json.getString("Title");
                    genre = json.getString("Genre");
                    plotSummary = json.getString("Plot");
                    runtime = tempRuntime;
                    urlToPoster = json.getString("Poster");
                    System.out.println("Counter: " + counter);
                    break;
                }
                else {
                    counter ++;
                }
            } catch (JSONException | IOException ex) {
                ex.printStackTrace();
            }
        }



    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String getInfoString() {
        return "Runtime: " + runtime + "\n" +
                "Genre: " + genre + "\n" +
                "Plot: " + plotSummary + "\n" +
                "Poster: " + urlToPoster;

    }


}
