package adletTop1234.controller;

import adletTop1234.model.Dish;
import adletTop1234.service.DishService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    private final DishService service;

    public DishController(DishService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Dish create(@RequestBody Dish dish) {
        return service.create(dish);
    }

    // READ ALL
    @GetMapping
    public List<Dish> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Dish getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Dish update(@PathVariable Long id, @RequestBody Dish dish) {
        return service.update(id, dish);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}/calories")
    public double getCalories(@PathVariable Long id) {
        return service.getCalories(id);
    }

    @DeleteMapping("/cache")
    public String clearCache() {
        service.clearCache();
        return "Cache cleared!";
    }
}
