package FunThingGeneratorModel;

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
     *
     * @return A string with miscellaneous relevant information
     */
    String getInfoString();

    /**
     * Get the URL of an image of the thing.
     *
     * @return URL string
     */
    String getImageSource();

}
