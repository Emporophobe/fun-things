package FunThingGeneratorModel;

import java.util.List;

/**
 * Interface for generating suggestions for activities.
 */
public interface IGenerator {

    /**
     * Generate a list of IFunThings to do.
     *
     * @param n          The number of things to suggest.
     * @param categories The categories of fun thing that you want to do.
     * @return A list of n IFunThing suggestions.
     */
    List<IFunThing> generate(int n, List<Category> categories);
}
