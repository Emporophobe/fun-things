package FunThingGeneratorModel;

import java.util.List;

/**
 * Interface for fun things.
 */
public interface IFunThing {

    /**
     * Get the name of the thing.
     *
     * @return The name of the thing.
     */
    String getName();

    /**
     * This is a catch-all for anything you might want to show the user
     * e.g Address, genre, etc.
     * @return A string with miscellaneous relevant information
     */
    String getFormattedInformationString();

    /**
     * Get a list of activities that fit the given parameters.
     *
     * @param participants The number of participants
     * @param minMinutes   The minimum length of time to do stuff in minutes
     * @param maxMinutes   The maximum length of time to do stuff in minutes
     * @param minCost      The minimum cost of the activity in dollars.
     * @param maxCost      The maximum cost of the activity in dollars.
     * @param isOutside    Whether you have to leave the house to do the thing.
     * @return A list of IFunThing that fit the requirements.
     */
    List<IFunThing> getListOfFunThings(int participants,
                                       int minMinutes,
                                       int maxMinutes,
                                       int minCost,
                                       int maxCost,
                                       boolean isOutside);
}
