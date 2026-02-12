package adletTop1234.service;

import adletTop1234.cache.DishCache;
import adletTop1234.model.Dish;
import adletTop1234.repository.DishRepository;
import org.springframework.stereotype.Service;
import adletTop1234.patterns.AppLogger;

import java.util.List;

@Service
public class DishService {
    private final DishRepository repository;
    private final DishCache cache = DishCache.getInstance();

    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    public Dish create(Dish dish) {
        dish.validate();
        Dish saved = repository.save(dish);
        AppLogger.getInstance().log("Dish created: " + saved.getName());
        return saved;
    }

    public Dish getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not Found"));
    }

    public Dish update(Long id, Dish dish) {
        Dish existing = getById(id);
        existing.setName(dish.getName());
        existing.setPrice(dish.getPrice());
        return repository.save(existing);
    }

    public double getCalories(Long id){
        Dish dish=getById(id);
        return dish.calculateCalories();
    }

    public List<Dish> getAll() {

        if (!cache.isEmpty()) {
            System.out.println("Returning dishes from CACHE");
            return cache.getCachedDishes();
        }

        System.out.println("Fetching dishes from DATABASE");
        List<Dish> dishes = repository.findAll();
        cache.setCachedDishes(dishes);
        return dishes;
    }

    public Dish save(Dish dish) {
        Dish saved = repository.save(dish);
        cache.clear(); // invalidate cache
        return saved;
    }

    public void delete(Long id) {
        repository.deleteById(id);
        cache.clear(); // invalidate cache
    }

    public void clearCache() {
        cache.clear();
    }
}
