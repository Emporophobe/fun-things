package FunThingGeneratorModel;

import java.util.List;

public class BoardGame extends AbstractFunThing {

    public BoardGame(String name) {
        super(name);
    }

    @Override
    public List<IFunThing> getListOfFunThings(int participants, int minMinutes, int maxMinutes,
                                              int minCost, int maxCost, boolean isOutside) {
        return null;
    }

    @Override
    public String getFormattedInformationString() {
        return null;
    }
}
