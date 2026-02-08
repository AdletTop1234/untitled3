package adletTop1234.service;

import adletTop1234.model.Dish;
import adletTop1234.repository.DishRepository;
import org.springframework.stereotype.Service;
import adletTop1234.patterns.AppLogger;

import java.util.List;

@Service
public class DishService {

    private final DishRepository repository;

    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    public Dish create(Dish dish) {
        dish.validate();
        Dish saved = repository.save(dish);
        AppLogger.getInstance().log("Dish created: " + saved.getName());
        return saved;
    }

    public List<Dish> getAll() {
        return repository.findAll();
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

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
