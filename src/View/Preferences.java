package View;

import FunThingGeneratorModel.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DJ on 10/1/2016.
 */
class Preferences {
    private static int people;
    private static int minutes;
    private static int cost;
    private static int distance;
    private static boolean outside;
    private static List<Category> categories;

    static void loadData(int p, int m, int c, int d, boolean o, List<Category> cats) {
        people = p;
        minutes = m;
        cost = c;
        distance = d;
        outside = o;
        categories = cats;
    }

    static int getPeople() {
        return people;
    }

    static int getMinutes() {
        return minutes;
    }

    static int getCost() {
        return cost;
    }

    static int getDistance() {
        return distance;
    }

    static boolean isOutside() {
        return outside;
    }

    static List<Category> getCategories() {
        List<Category> catClone = new ArrayList<>();
        catClone.addAll(categories);
        return catClone;
    }


}
