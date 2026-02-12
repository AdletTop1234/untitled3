package adletTop1234.cache;

import adletTop1234.model.Dish;

import java.util.List;

public class DishCache {

    private static DishCache instance;

    private List<Dish> cachedDishes;

    private DishCache() {}

    public static synchronized DishCache getInstance() {
        if (instance == null) {
            instance = new DishCache();
        }
        return instance;
    }

    public List<Dish> getCachedDishes() {
        return cachedDishes;
    }

    public void setCachedDishes(List<Dish> dishes) {
        this.cachedDishes = dishes;
    }

    public void clear() {
        cachedDishes = null;
    }

    public boolean isEmpty() {
        return cachedDishes == null;
    }
}
