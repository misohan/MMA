package codecool.mma;

import java.util.ArrayList;

public interface IProductDAO {
    ArrayList<Product> getAllProducts();
    void updateProductByID(int ID, String title, String brand, String model, String type, int price, int productSize, boolean availability);
    void createProduct(int ID, String title, String brand, String model, String type, int price, int productSize, boolean availability);
    void removeProductByID(int ID);


}
