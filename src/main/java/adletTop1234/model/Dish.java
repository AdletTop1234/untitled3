package adletTop1234.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients = new ArrayList<>();

    public Dish() {}

    public Dish(String name, int price, List<Ingredient> ingredients) {
        this.name = name;
        this.price = price;
        if (ingredients != null) this.ingredients = ingredients;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public List<Ingredient> getIngredients() { return ingredients; }

    public void setName(String name) { this.name = name; }
    public void setPrice(int price) { this.price = price; }
    public void setIngredients(List<Ingredient> ingredients) { this.ingredients = ingredients; }

    public double calculateCalories() {
        double total = 0;
        for (Ingredient i : ingredients) {
            total += i.getCalories() * i.getQuantity();
        }
        return total;
    }

    public void validate(){

    }
}
