package FunThingGeneratorModel;

import java.util.List;
import java.util.Random;

/**
 * Generate activity suggestions.
 */
public class Generator {

    /**
     * @param participants the number of participants
     * @param maxMinutes   the maximum time (in minutes)
     * @param maxCost      the maximum cost (in arbitrary dollar sign amounts)
     * @param isOutside    is it outside?
     * @param maxDistance  how far to go? (in km)
     * @param categories   the possible categories
     * @return a random fun thing from the categories given
     * @throws NoMatchException if the list of categories is empty
     */
    public static IFunThing generate(int participants,
                                     int maxMinutes,
                                     int maxCost,
                                     boolean isOutside,
                                     int maxDistance,
                                     List<Category> categories) throws NoMatchException {

        //if the list is empty (it should never be able to be empty)
        if (categories.isEmpty()) {
            throw new NoMatchException("YOU FAILED. ITS NOT EVEN POSSIBLE. HOW?????");
        }

        //make a random number to select a random category
        Random random = new Random();

        while (!categories.isEmpty()) {
            int randomInt = random.nextInt(categories.size());
            Category c = categories.get(randomInt);
            categories.remove(randomInt);
            try {
                //create the appropriate fun thing
                switch (c) {
                    case MOVIE:
                        return new Movie(participants, maxMinutes, maxCost, maxDistance);
                    case TV:
                        return new TV(participants, maxMinutes, maxCost, maxDistance);
                    case BOARDGAME:
                        return new BoardGame(participants, maxMinutes, maxCost, maxDistance);
                    case RESTAURANT:
                        return new Restaurant(participants, maxMinutes, maxCost, maxDistance);
                    case VIDEOGAME:
                        return new VideoGame(participants, maxMinutes, maxCost, maxDistance);
                    case RECIPE:
                        return new Recipe(participants, maxMinutes, maxCost, maxDistance);
                    case OUTSIDE:
                        return new Outside(participants, maxMinutes, maxCost, maxDistance);
                    default:
                        //you should never get here
                        return null;
                }
            } catch (NoMatchException ignored) {
                // Catch if the category we tried couldn't find anything. If so, continue the loop since there are other
                // potential categories
            }
        }
        // If we're here then all the categories have returned nothing.
        throw new NoMatchException("No matches for given parameters!");
    }
}
