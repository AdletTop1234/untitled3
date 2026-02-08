package adletTop1234.service;

import adletTop1234.model.SecondCourse;
import adletTop1234.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    private final DishRepository repository;

    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    public SecondCourse create(SecondCourse secondCourse) {
        return repository.save(secondCourse);
    }

    public List<SecondCourse> getAll() {
        return repository.findAll();
    }

    public SecondCourse getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not Found"));
    }

    public SecondCourse update(Long id, SecondCourse secondCourse) {
        SecondCourse existing = getById(id);
        existing.setName(secondCourse.getName());
        existing.setPrice(secondCourse.getPrice());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
