package codecool.mma;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductController {

    private ProductDAO productDAO;

    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> sortProductsByPriceAsc() {
        List<Product> allProducts = productDAO.getAllProducts();
        List<Integer> sortedPrices = new ArrayList<>();

        for (Product product : allProducts) {
            sortedPrices.add(product.getPrice());
        }
        Collections.sort(sortedPrices);

        ArrayList<Product> sortedProducts = new ArrayList<Product>();

        while (sortedProducts.size() < sortedPrices.size()) {
            for (Integer sortedPrice : sortedPrices) {
                for (Product product : allProducts) {
                    if (sortedPrice == product.getPrice()) {
                        sortedProducts.add(product);
                    }
                }
            }
        }
        return sortedProducts;
    }

    public List<Product> sortProductsByPriceDsc() {
        List<Product> allProductsDsc = productDAO.getAllProducts();
        List<Integer> sortedPrices = new ArrayList<>();

        for (Product product : allProductsDsc) {
            sortedPrices.add(product.getPrice());
        }
        Collections.sort(sortedPrices, Collections.reverseOrder());

        List<Product> sortedProducts = new ArrayList<Product>();

        while (sortedProducts.size() < sortedPrices.size()) {
            for (Integer sortedPrice : sortedPrices) {
                for (Product product : allProductsDsc) {
                    if (sortedPrice == product.getPrice()) {
                        sortedProducts.add(product);
                    }
                }
            }
        }
        return sortedProducts;
    }

    public void viewProduct(Product product) {
        System.out.println("=================");
        System.out.println("Product ID: " + product.getID());
        System.out.println("Name: " + product.getTitle());
        System.out.println("Brand: " + product.getBrand());
        System.out.println("Model: " + product.getModel());
        System.out.println("Type: " + product.getType());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Price: " + product.getProductSize());
        System.out.println("Availability: " + product.getAvailability());
        System.out.println("=================");
    }

    public void viewAllProducts() {
        List<Product> allProducts = productDAO.getAllProducts();
        for (Product product : allProducts) {
            viewProduct(product);
        }
    }
}
