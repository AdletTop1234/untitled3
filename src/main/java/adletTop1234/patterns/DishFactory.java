package adletTop1234.patterns;

import adletTop1234.model.Dish;
import adletTop1234.model.Ingredient;
import adletTop1234.patterns.AppLogger;

import java.util.List;

public class DishFactory {

    public static Dish createDish(String name, int price, List<Ingredient> ingredients) {
        Dish dish = new Dish(name, price, ingredients);
        AppLogger.getInstance().log("Dish created: " + name);
        return dish;
    }
}
