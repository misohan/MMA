package codecool.mma;


import java.util.ArrayList;
import java.util.Collections;

public class ProductController extends ProductDAO {


//    @Override
//    public ArrayList<Product> getAllProducts() {
//        return super.getAllProducts();
//    }
    public ArrayList<Product> sortProductsByPriceAsc(){
        ArrayList<Product> allProducts = getAllProducts();
        ArrayList<Integer> sortedPrices = new ArrayList<>();

        for(Product product: allProducts){
            sortedPrices.add(product.getPrice());
        }
        Collections.sort(sortedPrices);

        ArrayList<Product> sortedProducts = new ArrayList<Product>();

        while (sortedProducts.size()<sortedPrices.size()){
            for(Integer sortedPrice: sortedPrices){
                for(Product product: allProducts){
                    if (sortedPrice == product.getPrice()){
                        sortedProducts.add(product);
                    }
                }
            }
        }
        return sortedProducts;
    }
    public ArrayList<Product> sortProductsByPriceDsc(){
        ArrayList<Product> allProductsDsc = getAllProducts();
        ArrayList<Integer> sortedPrices = new ArrayList<>();

        for(Product product: allProductsDsc){
            sortedPrices.add(product.getPrice());
        }
        Collections.sort(sortedPrices, Collections.reverseOrder());

        ArrayList<Product> sortedProducts = new ArrayList<Product>();

        while (sortedProducts.size()<sortedPrices.size()){
            for(Integer sortedPrice: sortedPrices){
                for(Product product: allProductsDsc){
                    if (sortedPrice == product.getPrice()){
                        sortedProducts.add(product);
                    }
                }
            }
        }
        return sortedProducts;
    }

    public void viewProduct(Product product){
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
    public void viewAllProducts(ArrayList<Product> allProducts){
        for (Product product: allProducts){
            viewProduct(product);
        }
    }
}
