package FunThingGeneratorModel;

/**
 * Types of fun things.
 */
public enum Category {
    MOVIE("Movie"),
    TV("TV Show"),
    BOARDGAME("Board Game"),
    VIDEOGAME("Video Game"),
    RESTAURANT("Restaurant"),
    RECIPE("Recipe");
    //OUTSIDE

    private String name;

    Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
