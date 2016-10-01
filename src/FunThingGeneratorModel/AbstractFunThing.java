package FunThingGeneratorModel;

/**
 * Fun things!
 */
public abstract class AbstractFunThing implements IFunThing {
    protected String theName;
    protected String details;

    @Override
    public String getName() {
        return theName;
    }

    @Override
    public String getFormattedInformationString() {
        return details;
    }
}
