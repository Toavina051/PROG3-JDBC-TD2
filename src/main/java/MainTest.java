import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        DataRetriever dataRetriever = new DataRetriever(dbConnection);
        System.out.println("TEST a) findDishById(1)");
        try {
            Dish dish = dataRetriever.findDishById(1);
            System.out.println(dish);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nTEST c) findIngredients(page=2, size=2)");
        List<Ingredient> ingredientsPage2 =
                dataRetriever.findIngredients(3, 5);
        ingredientsPage2.forEach(System.out::println);
    }
}
