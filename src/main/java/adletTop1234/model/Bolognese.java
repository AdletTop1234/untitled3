package adletTop1234.model;

import jakarta.persistence.Entity;

@Entity
public class Bolognese extends SecondCourse {

    public Bolognese() {}

    public Bolognese(Long id, int price, String name) {
        super(id, price, name);
    }

    @Override
    public String getRecipeType() {
        return "Bolognese";
    }

    @Override
    public double calculateCalories() {
        double total=0;
        for(Ingredient i:getIngredients()){
            total += i.getCalories() * i.getQuantity();
        }
        return total;
    }

    @Override
    public void validate() {
        if(getName()==null || getName().isEmpty()){
            throw new IllegalArgumentException("Name is empty");
        }
        if(getIngredients()==null || getIngredients().isEmpty()){
            throw new IllegalArgumentException("Ingredients are empty ");
        }
    }
}
