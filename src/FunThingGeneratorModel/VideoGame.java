package FunThingGeneratorModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Video game fun things, drawn from a database of games the group owns.
 */
public class VideoGame extends AbstractFunThing {
    private static final List<VideoGameEntry> LIST_OF_VIDEOGAMES = VideoGame.parseVideoGames();
    private String name;
    private String genre;
    private String console;
    private String imageUrl;

    VideoGame(int participants,
              int maxMinutes,
              int maxCost) throws NoMatchException {
        super(participants, maxMinutes, maxCost);
    }

    private static List<VideoGameEntry> parseVideoGames() {
        List<VideoGameEntry> videoGames = new ArrayList<>();
        File file = new File("VideoGames.csv");
        try {
            Scanner lineScanner = new Scanner(file);
            lineScanner.useDelimiter("\n");
            while (lineScanner.hasNext()) {
                Scanner entryScanner = new Scanner(lineScanner.next());
                entryScanner.useDelimiter(",");
                try {
                    String name = entryScanner.next();
                    String console = entryScanner.next();
                    int minPlayers = Integer.parseInt(entryScanner.next());
                    int maxPlayers = Integer.parseInt(entryScanner.next());
                    String genre = entryScanner.next();
                    String imageUrl = entryScanner.next();
                    VideoGameEntry entry = new VideoGameEntry(name, console, minPlayers, maxPlayers, genre, imageUrl);
                    videoGames.add(entry);
                } catch (Exception e) {
                    throw new IllegalStateException("Entry in csv file does not have the required parameters");
                }
                entryScanner.close();
            }
            lineScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return videoGames;
    }

    public static void main(String[] args) throws NoMatchException {
        System.out.println(new VideoGame(1, 0, 0).getInfoString());

    }

    //FIX THIS
    @Override
    void generate(int participants, int maxMinutes, int maxCost) throws NoMatchException {
        Collections.shuffle(LIST_OF_VIDEOGAMES);
        boolean satisfied = false;
        int counter = 0;
        while (!satisfied) {
            VideoGameEntry potentialGame = LIST_OF_VIDEOGAMES.get(counter);
            if (potentialGame.getMinPlayers() <= participants && potentialGame.getMaxPlayers() >= participants) {
                this.name = potentialGame.getTitle();
                this.console = potentialGame.getConsole();
                this.genre = potentialGame.getGenre();
                this.imageUrl = potentialGame.getImageUrl();

                satisfied = true;
            }
            counter++;
        }
    }

    String getGenre() {
        return this.genre;
    }

    String getConsole() {
        return this.console;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getInfoString() {
        return this.getGenre() + "\n" +
                this.getConsole();
    }

    @Override
    public String getImageSource() {
        return imageUrl;
    }


}
