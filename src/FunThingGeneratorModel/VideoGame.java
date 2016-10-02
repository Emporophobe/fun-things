package FunThingGeneratorModel;

/**
 * Created by Li on 10/1/2016.
 */
public class VideoGame extends AbstractFunThing {

    VideoGame(int participants, int maxMinutes, int maxCost, boolean isOutside) throws NoMatchException {
        super(participants, maxMinutes, maxCost, isOutside);
    }

    @Override
    void generate(int participants, int maxMinutes, int maxCost, boolean isOutside) throws NoMatchException {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getInfoString() {
        return null;
    }
}
