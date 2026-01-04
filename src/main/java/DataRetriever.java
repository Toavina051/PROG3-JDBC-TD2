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

}
