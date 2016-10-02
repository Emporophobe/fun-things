package FunThingGeneratorModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;

class Recipe extends AbstractFunThing {

    private String title;
    private String pictureUrl;
    private String sourceUrl;

    /**
     * Constructs a valid Recipe object
     *
     * @param participants number of participants
     * @param maxMinutes   max number of minutes
     * @param maxCost      max cost
     * @throws NoMatchException if no valid match is found
     */
    Recipe(int participants, int maxMinutes, int maxCost) throws NoMatchException {
        super(participants, maxMinutes, maxCost);
    }

    /**
     * Populates this Recipe with information pertaining to a recipe
     * that is within the specified time limit
     *
     * @param participants the number of participants
     * @param maxMinutes   the maximum amount of time
     * @param maxCost      the maximum cost
     * @throws NoMatchException if there is no match after 50 tries
     */
    @Override
    void generate(int participants, int maxMinutes, int maxCost) throws NoMatchException {
        try {
            //get a random recipe
            String RANDOM_RECIPE_API = "http://food2fork.com/api/search?key=04c93ab22c6796462728f3688afd0417";
            JSONObject json = JsonUtils.readJsonFromUrl(RANDOM_RECIPE_API);

            JSONArray recipes = json.getJSONArray("recipes");
            int index = new Random().nextInt(30);
            JSONObject recipe = recipes.getJSONObject(index);
            this.title = recipe.getString("title");
            this.pictureUrl = recipe.getString("image_url");
            this.sourceUrl = recipe.getString("source_url");
        } catch (JSONException | IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * returns the name of the recipe
     *
     * @return the name of the recipe
     */
    @Override
    public String getName() {
        return title;
    }

    /**
     * returns some more info about the recipe
     *
     * @return the title and source url of the recipe
     */
    @Override
    public String getInfoString() {
        return "Title: " + this.title + "\n"
                + "Source: " + this.sourceUrl;
    }

    @Override
    public String getImageSource() {
        return pictureUrl;
    }
}
