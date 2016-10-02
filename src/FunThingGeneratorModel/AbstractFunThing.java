package FunThingGeneratorModel;

/**
 * Fun things!
 */
abstract class AbstractFunThing implements IFunThing {

    /**
     * Create an abstract fun thing with the given preferences and generate
     * a random object that meets these parameters
     *
     * @param participants the number of people that wish to do the fun thing
     * @param maxMinutes   the longest you wish to do the fun thing for
     * @param maxCost      the most you are willing to pay for the fun thing
     * @throws NoMatchException if there is no fun thing that matches your requirements :(
     */
    AbstractFunThing(int participants,
                     int maxMinutes,
                     int maxCost,
                     int maxDistance) throws NoMatchException {
        generate(participants,
                maxMinutes,
                maxCost,
                maxDistance);
    }

    abstract void generate(int participants,
                           int maxMinutes,
                           int maxCost,
                           int maxDistance) throws NoMatchException;

    @Override
    public abstract String getName();

    @Override
    public abstract String getInfoString();

    public abstract String getImageSource();
}
