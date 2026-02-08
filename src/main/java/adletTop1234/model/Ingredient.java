package adletTop1234.model;

import jakarta.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double calories;
    private double quantity;

    public Ingredient() {}

    public Ingredient(String name, double calories, double quantity) {
        this.name = name;
        this.calories = calories;
        this.quantity = quantity;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getCalories() { return calories; }
    public double getQuantity() { return quantity; }

    public void setName(String name) { this.name = name; }
    public void setCalories(double calories) { this.calories = calories; }
    public void setQuantity(double quantity) { this.quantity = quantity; }
}
