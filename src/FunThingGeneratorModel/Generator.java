package FunThingGeneratorModel;

import java.util.List;
import java.util.Random;

/**
 * Generate activity suggestions.
 */
public class Generator  {
    public static IFunThing generate(int participants,
                              int maxMinutes,
                              int maxCost,
                              boolean isOutside,
                              List<Category> categories) throws NoMatchException {

        if (categories.isEmpty()) {
            throw new NoMatchException("YOU FAILED. ITS NOT EVEN POSSIBLE. HOW?????");
        }

        Random random = new Random();
        int randomInt = random.nextInt(categories.size());
        Category c = categories.get(randomInt);

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

        return null;
    }
}
