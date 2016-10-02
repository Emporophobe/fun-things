package FunThingGeneratorModel;

/**
 * To represent a video game that we own
 *
 * Created by Li on 10/1/2016.
 */
public class VideoGameEntry {

    private String title;
    private String console;
    private int minPlayers;
    private int maxPlayers;
    private String genre;
    private String imageUrl;

    /**
     * To create a VideoGameEntry
     *
     * @param title         the title of the game
     * @param console       the console the game is played on
     * @param minPlayers    the minimum number of players to play
     * @param maxPlayers    the maximum number of players to play
     * @param genre         the genre of the game
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
     *
     * @return the title
     */
    public String getTitle(){
        return title;
    }

    /**
     *
     * @return the console
     */
    public String getConsole() {
        return console;
    }

    /**
     *
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     *
     * @return the min players
     */
    public int getMinPlayers() {
        return minPlayers;
    }

    /**
     *
     * @return the max players
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
