package FunThingGeneratorModel;

/**
 * Fun things!
 */
public abstract class AbstractFunThing implements IFunThing {

    Category theCategory;
    String theName;
    int theRating;
    int maxRating;

    int minPeople;
    int maxPeople;
    int minMinutes;
    int maxMinutes;
    int minCost;
    int maxCost;
    int distance;

    @Override
    public double getDistance() {
        return distance;
    }

    @Override
    public int getMinPeople() {
        return minPeople;
    }

    @Override
    public int getMaxPeople() {
        return maxPeople;
    }

    @Override
    public int getMinMinutes() {
        return minMinutes;
    }

    @Override
    public int getMaxMinutes() {
        return maxMinutes;
    }

    @Override
    public int getMinCost() {
        return minCost;
    }

    @Override
    public int getMaxCost() {
        return maxCost;
    }

    @Override
    public Category getType() {
        return theCategory;
    }

    @Override
    public String getName() {
        return theName;
    }

    @Override
    public double getNormalizedRating() {
        return theRating / maxRating;
    }
}
