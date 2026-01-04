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
    }
}
