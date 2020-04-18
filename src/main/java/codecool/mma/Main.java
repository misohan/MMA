package codecool.mma;

public class Main {
    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.readProductByID(1);
        CartController cartController = new CartController();
        Product product1 = productDAO.readProductByID(2);

        Cart newCart = new Cart(true);

        newCart.addCartItemToCart(product,5);
        newCart.addCartItemToCart(product1,7);
        newCart.addCartItemToCart(product, 5);


        cartController.checkCartSummary(newCart);










    }
}