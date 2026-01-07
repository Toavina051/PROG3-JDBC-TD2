import java.util.Arrays;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
       DataRetriever dataRetriever = new DataRetriever(dbConnection);
        /*System.out.println("TEST a) findDishById(1)");
        try {
            Dish dish = dataRetriever.findDishById(1);
            System.out.println(dish);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nTEST c) findIngredients(page=2, size=2)");
        List<Ingredient> ingredientsPage2 =
                dataRetriever.findIngredients(3, 5);
        ingredientsPage2.forEach(System.out::println);*/

       /* System.out.println("\nTEST i) createIngredients OK");

        Ingredient fromage = new Ingredient(
                7,
                "Fromage",
                1200.0,
                CategoryEnum.DAIRY,
                null

        );

        Ingredient oignon = new Ingredient(
                8,
                "Oignon",
                500.0,
                CategoryEnum.VEGETABLE,
                null
        );

        try {
            List<Ingredient> createdIngredients =
                    dataRetriever.createIngredients(
                            Arrays.asList(fromage, oignon)
                    );
            createdIngredients.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }*/

        /*System.out.println("\nTEST e) findDishByIngredientName(\"fleur\")");
        List<Dish> dishesWithFleur =
                dataRetriever.findDishByIngredientName("poulet");
        dishesWithFleur.forEach(System.out::println);*/
        Dish dish = dataRetriever.findDishById(1);

        try {
            System.out.println("Marge brute : " + dish.getGrossMargin());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

    }
}
