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

    public static void loadData(int people, int minutes, int cost, int distance, boolean isOutside, List<Category> categories){
        people = people;
        minutes = minutes;
        cost = cost;
        distance = distance;
        outside = isOutside;
        categories = categories;
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
