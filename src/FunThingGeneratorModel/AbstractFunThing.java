package FunThingGeneratorModel;

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
}
