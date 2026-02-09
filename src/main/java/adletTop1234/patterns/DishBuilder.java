package adletTop1234.patterns;

import adletTop1234.model.Dish;
import adletTop1234.model.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class DishBuilder {

    private String name;
    private int price;
    private List<Ingredient> ingredients = new ArrayList<>();

    public DishBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DishBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public DishBuilder addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public Dish build() {
        Dish dish = new Dish();
        dish.setName(name);
        dish.setPrice(price);
        dish.setIngredients(ingredients);
        return dish;
    }
}
