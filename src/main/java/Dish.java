import java.util.ArrayList;
import java.util.List;

public class Dish {
    private int id;
    private String name;
    private DishTypeEnum dishType;
    private List<Ingredient>  ingredients;

    public Dish(int id, String name, DishTypeEnum dishType, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.dishType = dishType;
        this.ingredients = ingredients;
    }

    public Dish(int id, String name) {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DishTypeEnum getDishType() {
        return dishType;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /*public Double getDishPrice() {
        Double price = 0.0;
        int count = 0;
        while ( count != ingredients.size() ) {
            price += ingredients.getFirst().getPrice();
            count++;
        }
        return price;
    }*/
    public Double getDishPrice(){
        return ingredients.stream()
                .mapToDouble(Ingredient::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
