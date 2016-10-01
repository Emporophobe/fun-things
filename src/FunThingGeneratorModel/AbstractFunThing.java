package FunThingGeneratorModel;

/**
 * Fun things!
 */
abstract class AbstractFunThing implements IFunThing {

    AbstractFunThing(int participants,
                     int maxMinutes,
                     int maxCost,
                     boolean isOutside) throws NoMatchException {
        generate(participants,
                maxMinutes,
                maxCost,
                isOutside);
    }

    abstract void generate(int participants,
                           int maxMinutes,
                           int maxCost,
                           boolean isOutside) throws NoMatchException;

    @Override
    public abstract String getName();

    public abstract String getInfoString();
}
