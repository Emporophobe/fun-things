package FunThingGeneratorModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BoardGame extends AbstractFunThing {
    private static final List<BoardGameEntry> LIST_OF_BOARDGAMES = BoardGame.parseBoardGames();
    private String name;

    public BoardGame(int participants,
                     int maxMinutes,
                     int maxCost,
                     boolean isOutside) throws NoMatchException {
        super(participants, maxMinutes, maxCost, isOutside);
    }

    @Override
    void generate(int participants, int maxMinutes, int maxCost, boolean isOutside) throws NoMatchException {
        Collections.shuffle(LIST_OF_BOARDGAMES);
        boolean satisfied = false;
        int counter = 0;
        while(!satisfied) {
            BoardGameEntry potentialGame = LIST_OF_BOARDGAMES.get(counter);
            if (potentialGame.getMinPlayers() <= participants && potentialGame.getMaxPlayers() >= participants
                    && potentialGame.getDuration() <= maxMinutes) {
                this.name = potentialGame.getName();
                satisfied = true;
            }
            counter++;
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

    public static void main(String[] args) throws NoMatchException {
        System.out.println(new BoardGame(2, 90, 0, false).getName());
    }

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
                    BoardGameEntry entry = new BoardGameEntry(name, minPlayers, maxPlayers, duration);
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
