package FunThingGeneratorModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;

/**
 * A TV Show fun thing
 * <p>
 * Created by Li on 10/1/2016.
 */
public class TV extends AbstractFunThing {

    private String name;
    private String genres;
    private int runtime;
    private String summary;

    /**
     * @param participants the number of participants
     * @param maxMinutes   the max amount of time
     * @param maxCost      the max cost
     * @throws NoMatchException if no suitable tv show is found
     */
    TV(int participants, int maxMinutes, int maxCost) throws NoMatchException {
        super(participants, maxMinutes, maxCost);
    }

    public static void main(String[] args) throws NoMatchException {
        TV tv = new TV(0, 90, 0);
        System.out.println(tv.getName());
        System.out.println(tv.getInfoString());
    }

    /**
     * Populates this TV object with the information of a valid TV show
     *
     * @param participants the number of participants
     * @param maxMinutes   the max amount of time
     * @param maxCost      the max cost
     * @throws NoMatchException if no suitable tv show is found
     */
    @Override
    void generate(int participants, int maxMinutes, int maxCost) throws NoMatchException {


        //keep track of how many tries
        int counter = 0;

        while (counter < 50) {

            //get a random show ID
            Random random = new Random();
            int randInt = random.nextInt(21668) + 1;
            //System.out.println(randInt);

            try {
                //get a random tv show
                String RANDOM_TV_API_BASE = "http://api.tvmaze.com/shows/";
                JSONObject json = JsonUtils.readJsonFromUrl(RANDOM_TV_API_BASE + randInt);
                //check if the runtime is short enough
                int tempRuntime = json.getInt("runtime");

                //if the runtime is short enough, populate this TV
                //with the information
                if (tempRuntime <= maxMinutes) {
                    name = json.getString("name");

                    JSONArray genresArray = json.getJSONArray("genres");
                    String genresString = "";
                    for (int i = 0; i < genresArray.length(); i++) {
                        if (i == 0) {
                            genresString += genresArray.get(i);
                        } else {
                            genresString += ", " + genresArray.get(i);

                        }
                    }
                    genres = genresString;

                    summary = json.getString("summary");
                    runtime = tempRuntime;

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
        if (counter >= 50)

        {
            throw new NoMatchException("No TV Show found");
        }

    }

    /**
     * To access the title of the TV show
     *
     * @return the TV show's name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * To access the information of this TV show
     *
     * @return the genres, runtime, and summary of this tv show
     */
    @Override
    public String getInfoString() {
        return genres + "\n" +
                runtime + " minutes\n" +
                summary;
    }

    @Override
    public String getImageSource() {
        return "http://www.publicdomainpictures.net/pictures/70000/velka/tv-isolated-background-clipart.jpg";
    }
}
