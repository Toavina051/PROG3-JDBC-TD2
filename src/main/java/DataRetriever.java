import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    private final DBConnection connection;

    public DataRetriever(DBConnection connection) {
        this.connection = connection;
    }

    public Dish findDishById(Integer id) {

        String sql = "SELECT dish.id, dish.name, dish.dish_type, ingredient.id, ingredient.name, ingredient.price, ingredient.category FROM dish LEFT JOIN ingredient ON dish.id = ingredient.id_dish WHERE dish.id = ?";

        try (Connection dbconnection = connection.getDBConnection();
             PreparedStatement statement = dbconnection.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            Dish dish = null;
            List<Ingredient> ingredients = new ArrayList<>();

            while (result.next()) {

                if (dish == null) {
                    dish = new Dish(
                            result.getInt(1),
                            result.getString(2),
                            DishTypeEnum.valueOf(result.getString(3)),
                            ingredients
                    );
                }

                int ingredientId = result.getInt(4);
                if (!result.wasNull()) {
                    ingredients.add(new Ingredient(
                            ingredientId,
                            result.getString(5),
                            result.getDouble(6),
                            CategoryEnum.valueOf(result.getString(7)),
                            null
                    ));
                }
            }

            if (dish == null) {
                throw new RuntimeException("Dish not found");
            }

            return dish;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Ingredient> findIngredients(int page, int size) {

        List<Ingredient> ingredients = new ArrayList<>();
        int offset = (page - 1) * size;

        String sql = "SELECT ingredient.id, ingredient.name, ingredient.price, ingredient.category FROM ingredient ORDER BY ingredient.id LIMIT ? OFFSET ?";

        try (Connection dbconnection = connection.getDBConnection();
             PreparedStatement statement = dbconnection.prepareStatement(sql)) {

            statement.setInt(1, size);
            statement.setInt(2, offset);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                ingredients.add(new Ingredient(
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        CategoryEnum.valueOf(result.getString(4)),
                        null
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error in findIngredients: " + e.getMessage());
        }
        if (ingredients.isEmpty()) {
            throw new RuntimeException("Ingredients not found");
        }
        return ingredients;
    }


}
