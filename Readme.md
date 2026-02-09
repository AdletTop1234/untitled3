# Dish Management API

Spring Boot REST API for managing dishes and ingredients.  
The project allows creating dishes, adding ingredients, and calculating calories via Postman.

---

## Project Overview

Each dish contains:

- **name** — dish name
- **price** — price
- **ingredients** — list of ingredients (name, calories, quantity)

The database stores **Dish** and **Ingredient** using JPA/Hibernate.

---

## Layers

- **Controller** — HTTP requests, JSON
- **Service** — business logic, Factory for creating dishes
- **Repository** — JPA database access
- **Model** — entities Dish and Ingredient

---

## Design Patterns

- **Factory** — for creating Dish objects
- **Singleton** — AppLogger for logging

---

## Models

**Dish**
```java
public class Dish {
    private Long id;
    private String name;
    private int price;
    private List<Ingredient> ingredients;

    // calories = sum of ingredient.calories * ingredient.quantity
}
public class Ingredient {
    private Long id;
    private String name;
    private double calories;
    private double quantity;
}
```

## Run

1.Run the Spring Boot application  
2.Server at http://localhost:8080

## API Endpoints(Controller)

![Снимок экрана 2026-02-09 234448.png](docs/screenshots/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%202026-02-09%20234448.png)

## Example Dish Calories Calculation

``` java
double totalCalories = 0;
for (Ingredient ingredient : dish.getIngredients()) {
totalCalories += ingredient.getCalories() * ingredient.getQuantity();
}
```

## Reflection

### This project helped me understand key concepts:

1.Spring Boot & JPA – Mapping Java objects (Dish, Ingredient) to a database and managing Many-to-Many relationships.

2.Design Patterns – Factory for dynamic dish creation, Singleton (AppLogger) for centralized logging.

3.API & Postman – Learned to test POST, GET, PUT, DELETE; faced issues with JSON serialization and missing @Id.

4.Refactoring – Replaced dish subclasses with a universal Dish class for flexibility.

### Conclusion: Planning entities, using patterns, and testing APIs early improves scalability and maintainability.