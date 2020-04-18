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
    }
    public void addProductToCart(ProductDAO productDAO, Cart cart){
        showAllProducts(productDAO);

        System.out.println("What product do yo want to add (choose by Id)\n");
        int userInputID = scanner.nextInt();
        scanner.nextLine();

        Product product = productDAO.readProductByID(userInputID);

        System.out.println("How many of this product you want to add?");

        int userInputQuantity = scanner.nextInt();
        scanner.nextLine();

        cart.addCartItemToCart(product, userInputQuantity);

    }
    public void removeProductFromCart(ProductDAO productDAO, Cart cart){
        CartController cartController = new CartController();


        cartController.checkCartSummary(cart); //show all items in Cart

        System.out.println("What product do yo want to remove (choose by Id)");

        int userInputID = scanner.nextInt(); //ask user to remove item

        Product product = productDAO.readProductByID(userInputID);

        System.out.println("How many of this product you want to remove?");

        int userInputQuantity = scanner.nextInt(); //ask user how many items
        cart.removeCartItemFromCart(product, userInputQuantity, cart);

        cart.addCartItemToCart(product, userInputQuantity); //remove item



    }
    public void checkCartSummary(Cart cart){
        CartController cartController = new CartController();
        cartController.checkCartSummary(cart);
    }
    public void updateCustomerEmail(){
        UserController userController = new UserController();

        System.out.println("What is your ID?");
        int userInputID = scanner.nextInt();
        scanner.nextLine();

        System.out.println("What is your new email?");
        String userInputEmail = scanner.nextLine();

        userController.updateUserEmail(userInputEmail, userInputID);
    }
    public void customersOptions(Cart cart, ProductDAO productDAO){

        boolean quit = false;
        while(!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nEnding shopping..");
                    quit = true;
                    break;

                case 1:
                    showAllProducts(productDAO);
                    break;

                case 2:
                    addProductToCart(productDAO, cart);
                    break;

                case 3:
                    removeProductFromCart(productDAO, cart);
                    break;

                case 4:
                    checkCartSummary(cart);
                    break;

                case 5:
                    updateCustomerEmail();
                    break;

                case 6:
                    printCustomersOptions();
                    break;
            }

        }

    }
    public void printCustomersOptions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - To end shopping, press 0.\n" +
                "1  - To display all products, press 1.\n" +
                "2  - To add product to cart, press 2.\n" +
                "3  - To remove product from cart, press 3.\n" +
                "4  - To check your cart, press 4.\n" +
                "5  - To update your e-mail, press 5.\n" +
                "6  - To print a list of available actions.");
        System.out.println("Choose your action: ");
    }

}


