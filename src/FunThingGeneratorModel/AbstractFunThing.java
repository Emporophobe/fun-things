package FunThingGeneratorModel;

import java.util.List;

/**
 * Fun things!
 */
public abstract class AbstractFunThing implements IFunThing {
    protected String theName;
    protected String details;

    public AbstractFunThing(String name) {
        this.theName = name;
    }

    @Override
    public String getName() {
        return theName;
    }

    public abstract String getFormattedInformationString();

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
    abstract List<IFunThing> getListOfFunThings(int participants,
                                       int minMinutes,
                                       int maxMinutes,
                                       int minCost,
                                       int maxCost,
                                       boolean isOutside);
}
