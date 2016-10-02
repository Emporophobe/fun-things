package FunThingGeneratorModel;

/**
 * To represent a video game that we own
 * <p>
 * Created by Li on 10/1/2016.
 */
class VideoGameEntry {

    private String title;
    private String console;
    private int minPlayers;
    private int maxPlayers;
    private String genre;
    private String imageUrl;

    /**
     * To create a VideoGameEntry
     *
     * @param title      the title of the game
     * @param console    the console the game is played on
     * @param minPlayers the minimum number of players to play
     * @param maxPlayers the maximum number of players to play
     * @param genre      the genre of the game
     */
    VideoGameEntry(String title, String console, int minPlayers, int maxPlayers, String genre, String imageUrl) {
        this.title = title;
        this.console = console;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.genre = genre;
        this.imageUrl = imageUrl;
    }

    /**
     * @return the title
     */
    String getTitle() {
        return title;
    }

    /**
     * @return the console
     */
    String getConsole() {
        return console;
    }

    /**
     * @return the genre
     */
    String getGenre() {
        return genre;
    }

    /**
     * @return the min players
     */
    int getMinPlayers() {
        return minPlayers;
    }

    /**
     * @return the max players
     */
    int getMaxPlayers() {
        return maxPlayers;
    }

    String getImageUrl() {
        return imageUrl;
    }
}
