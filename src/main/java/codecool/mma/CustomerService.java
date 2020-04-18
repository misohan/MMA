package codecool.mma;

import java.util.ArrayList;
import java.util.Scanner;


public class CustomerService {
    Cart cart;
    Order order;
    User user;
    Product product;

    Scanner scanner = new Scanner(System.in);



    public void showAllProducts(ProductDAO productDAO){
          ProductController productController = new ProductController();
          productController.viewAllProducts(productDAO.getAllProducts());
        }


    public void getProductByID(ProductDAO productDAO){
        System.out.println("What product do you want see by ID?");

        int userInput = scanner.nextInt();

        ProductController productController = new ProductController();
        Product product = productDAO.readProductByID(userInput);

        productController.viewProduct(product);

        scanner.nextLine();
        scanner.close();
    }
    public void addProductToCart(ProductDAO productDAO, Cart cart){
        showAllProducts(productDAO);

        System.out.println("What product do yo want to add (choose by Id)");
        int userInputID = scanner.nextInt();
        scanner.nextLine();

        Product product = productDAO.readProductByID(userInputID);

        System.out.println("How many of this product you want to add?");

        int userInputQuantity = scanner.nextInt();
        scanner.nextLine();

        cart.addCartItemToCart(product, userInputQuantity);
        scanner.close();
    }
    public void removeProductFromCart(ProductDAO productDAO, Cart cart){
        CartController cartController = new CartController();

        cartController.checkCartSummary(cart); //show all items in Cart

        System.out.println("What product do yo want to remove (choose by Id)");

        int userInputID = scanner.nextInt(); //ask user to remove item
        scanner.nextLine();

        Product product = productDAO.readProductByID(userInputID);

        System.out.println("How many of this product you want to remove?");

        int userInputQuantity = scanner.nextInt(); //ask user how many items
        cart.removeCartItemFromCart(product, userInputQuantity);

        scanner.nextLine();

        cart.addCartItemToCart(product, userInputQuantity); //remove item

        scanner.close();
    }
    public void checkCartSummary(Cart cart){
        CartController cartController = new CartController();
        cartController.checkCartSummary(cart);
    }

}


