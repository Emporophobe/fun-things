package FunThingGeneratorModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BoardGame extends AbstractFunThing {
    /**
     * Static list of board games that we own, parsed from the csv file
     */
    private static final List<BoardGameEntry> LIST_OF_BOARDGAMES = BoardGame.parseBoardGames();
    /**
     * Name of this particular board game
     */
    private String name;
    private String imageUrl;

    /**
     * Pick a random board game from the list of board games that satisfy the given options
     * @param participants the number of people that wish to play
     * @param maxMinutes the longest time you wish to play
     * @param maxCost board games don't have costs dummy
     * @throws NoMatchException
     */
    public BoardGame(int participants,
                     int maxMinutes,
                     int maxCost) throws NoMatchException {
        super(participants, maxMinutes, maxCost);
    }

    @Override
    void generate(int participants, int maxMinutes, int maxCost) throws NoMatchException {
        Collections.shuffle(LIST_OF_BOARDGAMES);
        boolean satisfied = false;
        int counter = 0;
        while(!satisfied && counter < LIST_OF_BOARDGAMES.size()) {
            BoardGameEntry potentialGame = LIST_OF_BOARDGAMES.get(counter);
            if (potentialGame.getMinPlayers() <= participants && potentialGame.getMaxPlayers() >= participants
                    && potentialGame.getDuration() <= maxMinutes) {
                this.name = potentialGame.getName();
                this.imageUrl = potentialGame.getImageUrl();
                satisfied = true;
            }
            counter++;
        }
        if (!satisfied) {
            throw new NoMatchException("No board games are available for those parameters");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getInfoString() {
        return this.name;
    }

    @Override
    public String getImageSource() {
        return this.imageUrl;
    }

    /**
     * Parses the board games from the csv file into a list of BoardGameEntries
     * @return the list of BoardGameEntries
     */
    private static List<BoardGameEntry> parseBoardGames() {
        List<BoardGameEntry> boardGames = new ArrayList<>();
        File file = new File("BoardGames.csv");
        try {
            Scanner lineScanner = new Scanner(file);
            lineScanner.useDelimiter("\n");
            while(lineScanner.hasNext()) {
                Scanner entryScanner = new Scanner(lineScanner.next());
                entryScanner.useDelimiter(",");
                try {
                    String name = entryScanner.next();
                    int minPlayers = Integer.parseInt(entryScanner.next());
                    int maxPlayers = Integer.parseInt(entryScanner.next());
                    int duration = Integer.parseInt(entryScanner.next());
                    String imageUrl = entryScanner.next();
                    BoardGameEntry entry = new BoardGameEntry(name, minPlayers, maxPlayers, duration, imageUrl);
                    boardGames.add(entry);
                } catch (Exception e) {
                    throw new IllegalStateException("Entry in csv file does not have the required parameters");
                }
                entryScanner.close();
            }
            lineScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return boardGames;
    }
}
