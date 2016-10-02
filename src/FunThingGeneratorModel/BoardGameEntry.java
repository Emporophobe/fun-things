package FunThingGeneratorModel;

public class BoardGameEntry {

    private String name;
    private int minPlayers;
    private int maxPlayers;
    private int duration;

    public BoardGameEntry(String name, int minPlayers, int maxPlayers, int duration) {
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getDuration() {
        return duration;
    }
}
