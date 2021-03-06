package FunThingGeneratorModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Li on 10/1/2016.
 * <p>
 * A movie Fun thing
 */
public class Movie extends AbstractFunThing {

    private String title;
    private String genre;
    private String plotSummary;
    private int runtime;
    private String urlToPoster;

    /**
     * Constructs a valid Movie object
     *
     * @param participants number of participants
     * @param maxMinutes   max number of minutes
     * @param maxCost      max cost
     * @throws NoMatchException if no valid match is found
     */
    Movie(int participants, int maxMinutes, int maxCost, int maxDistance) throws NoMatchException {
        super(participants, maxMinutes, maxCost, maxDistance);
    }

    /**
     * Populates this Movie with information pertaining to a movie
     * that is within the specified time limit
     *
     * @param participants the number of participants
     * @param maxMinutes   the maximum amount of time
     * @param maxCost      the maximum cost
     * @throws NoMatchException if there is no match after 50 tries
     */
    @Override
    void generate(int participants, int maxMinutes, int maxCost, int maxDistance) throws NoMatchException {

        //keep track of how many tries
        int counter = 0;

        while (counter < 50) {
            try {
                //get a random movie
                String RANDOM_MOVIE_API = "https://random-movie.herokuapp.com/random";
                JSONObject json = JsonUtils.readJsonFromUrl(RANDOM_MOVIE_API);

                //check if the runtime is short enough
                String minutes = json.getString("Runtime");
                int tempRuntime = Integer.parseInt(minutes.substring(0, minutes.length() - 4));

                //if the runtime is short enough, populate this Movie
                //with the information
                if (tempRuntime <= maxMinutes) {
                    title = json.getString("Title");
                    genre = json.getString("Genre");
                    plotSummary = json.getString("Plot");
                    runtime = tempRuntime;
                    urlToPoster = json.getString("Poster");
                    //System.out.println("Counter: " + counter);
                    break;
                }

                //otherwise, run again and increment the counter
                else {
                    counter++;
                }
            } catch (JSONException | IOException ex) {
                ex.printStackTrace();
            }
        }

        //if no match is found within 50 tries
        if (counter >= 50) {
            throw new NoMatchException("No movie found");
        }
    }

    /**
     * returns the name of the movie
     *
     * @return the name of the movie
     */
    @Override
    public String getName() {
        return title;
    }

    /**
     * returns some more info about the movie
     *
     * @return the runtime, genre, plot, and url to the poster of the movie
     */
    @Override
    public String getInfoString() {
        return "Runtime: " + runtime + " minutes\n" +
                "Genre: " + genre + "\n" +
                "Plot: " + plotSummary + "\n" +
                "Poster: " + urlToPoster;

    }

    @Override
    public String getImageSource() {
        return urlToPoster;
    }
}
