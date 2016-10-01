package FunThingGeneratorModel;

/**
 * Fun things!
 */
abstract class AbstractFunThing implements IFunThing {
    String theName;
    String details;

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
    public String getName() {
        return theName;
    }

    public String getInfoString() {
        return details;
    }
}
