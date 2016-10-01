package FunThingGeneratorModel;

/**
 * Interface for fun things.
 */
public interface IFunThing {
    /**
     * Get distance to the location of the thing.
     *
     * @return distance in miles.
     */
    double getDistance();

    /**
     * Get the minimum number of participants
     *
     * @return The number of people
     */
    int getMinPeople();

    /**
     * Get the maximum number of participants
     *
     * @return The number of people
     */
    int getMaxPeople();

    /**
     * Get the minimum amount of time the thing takes.
     *
     * @return The minimum time in minutes
     */
    int getMinMinutes();

    /**
     * Get the maximum amount of time the thing takes.
     *
     * @return The maximum time in minutes
     */
    int getMaxMinutes();

    /**
     * Get the minimum cost of the thing.
     *
     * @return The minimum cost in dollars.
     */
    int getMinCost();

    /**
     * Get the maximum cost of the thing.
     *
     * @return The maximum cost in dollars.
     */
    int getMaxCost();

    /**
     * Get the {@link Category} of the thing.
     *
     * @return The type of the thing.
     */
    Category getType();

    /**
     * Get the name of the thing.
     *
     * @return The name of the thing.
     */
    String getName();

    /**
     * Get the rating of the thing, in [0, 1]
     *
     * @return The rating on a scale of 0 to 1.
     */
    double getNormalizedRating();
}
