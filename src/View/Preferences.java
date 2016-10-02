package View;

import FunThingGeneratorModel.Category;

import java.util.List;

/**
 * Created by DJ on 10/1/2016.
 */
public class Preferences {
    private static int people;
    private static int minutes;
    private static int cost;
    private static int distance;
    private static boolean outside;
    private static List<Category> categories;

    public static void loadData(int p, int m, int c, int d, boolean o, List<Category> cats){
        people = p;
        minutes = m;
        cost = c;
        distance = d;
        outside = o;
        categories = cats;
    }

    public static int getPeople() {
        return people;
    }

    public static int getMinutes() {
        return minutes;
    }

    public static int getCost() {
        return cost;
    }

    public static int getDistance() {
        return distance;
    }

    public static boolean isOutside() {
        return outside;
    }

    public static List<Category> getCategories() {
        return categories;
    }


}
