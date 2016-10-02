package FunThingGeneratorModel;

import java.util.List;
import java.util.Random;

/**
 * Generate activity suggestions.
 */
public class Generator  {

    /**
     *
     * @param participants      the number of participants
     * @param maxMinutes        the maximum time
     * @param maxCost           the maximum cost
     * @param isOutside         is it outside?
     * @param categories        the possible categories
     * @return                  a random fun thing from the categories given
     * @throws NoMatchException if the list of categories is empty
     */
    public static IFunThing generate(int participants,
                              int maxMinutes,
                              int maxCost,
                              boolean isOutside,
                              List<Category> categories) throws NoMatchException {

        //if the list is empty (it should never be able to be empty)
        if (categories.isEmpty()) {
            throw new NoMatchException("YOU FAILED. ITS NOT EVEN POSSIBLE. HOW?????");
        }

        //make a random number to select a random category
        Random random = new Random();
        int randomInt = random.nextInt(categories.size());
        Category c = categories.get(randomInt);

        //create the appropriate fun thing
        switch (c) {
            case MOVIE :
                return new Movie(participants, maxMinutes, maxCost, isOutside);
            case TV :
                return new TV(participants, maxMinutes, maxCost, isOutside);
            case BOARDGAME :
                return new BoardGame(participants, maxMinutes, maxCost, isOutside);
            case RESTAURANT :
                return new Restaurant(participants, maxMinutes, maxCost, isOutside);
        }

        //you should never get here
        return null;
    }
}
