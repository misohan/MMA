package codecool.mma;

import java.util.List;

public interface ProductDAO {
    Product readProductByID(int id);

    List<Product> getAllProducts();

    void updateProductByID(Product product);

    void createProduct(Product product);

    void removeProductByID(int id);

}
