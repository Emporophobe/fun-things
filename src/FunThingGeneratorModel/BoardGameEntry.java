package FunThingGeneratorModel;

class BoardGameEntry {

    private String name;
    private int minPlayers;
    private int maxPlayers;
    private int duration;
    private String imageUrl;

    BoardGameEntry(String name, int minPlayers, int maxPlayers, int duration, String imageUrl) {
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.duration = duration;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    int getMinPlayers() {
        return minPlayers;
    }

    int getMaxPlayers() {
        return maxPlayers;
    }

    int getDuration() {
        return duration;
    }

    String getImageUrl() {
        return imageUrl;
    }
}
