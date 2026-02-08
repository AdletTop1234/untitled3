package adletTop1234.controller;

import adletTop1234.model.SecondCourse;
import adletTop1234.service.DishService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books/")
public class DishController {

    private final DishService service;

    public DishController(DishService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public SecondCourse create(@RequestBody SecondCourse secondCourse) {
        return service.create(secondCourse);
    }

    // READ ALL
    @GetMapping
    public List<SecondCourse> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public SecondCourse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public SecondCourse update(@PathVariable Long id, @RequestBody SecondCourse secondCourse) {
        return service.update(id, secondCourse);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
