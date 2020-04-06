package codecool.mma;

public interface IProductDAO {
    Product getProduct();
    void updateProduct(Product product);
    void removeProduct(Product product);
    void createProduct(Product porduct);


}
