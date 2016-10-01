package FunThingGeneratorModel;

/**
 * Fun things!
 */
abstract class AbstractFunThing implements IFunThing {

    AbstractFunThing(int participants,
                     int maxMinutes,
                     int maxCost,
                     boolean isOutside) {
        generate(participants,
                maxMinutes,
                maxCost,
                isOutside);
    }

    abstract void generate(int participants,
                           int maxMinutes,
                           int maxCost,
                           boolean isOutside);

    @Override
    public abstract String getName();

    public abstract String getInfoString();
}
