package adletTop1234.model;

import adletTop1234.interfaces.CalorieCalculable;
import adletTop1234.interfaces.Validatable;
import adletTop1234.model.Ingredient;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SecondCourse implements Validatable, CalorieCalculable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;

    @ManyToMany
    private List<Ingredient> ingredients = new ArrayList<>();

    // 👉 ОБЯЗАТЕЛЬНЫЙ пустой конструктор для JPA
    public SecondCourse() {}

    public SecondCourse(Long id, int price, String name) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients=new ArrayList<Ingredient>(ingredients);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public abstract String getRecipeType();
}
