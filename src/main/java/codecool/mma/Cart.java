package codecool.mma;

import java.util.ArrayList;

public class Cart{
    private ArrayList<CartItem> cartItems;
    private int total;
    private boolean checkCart;

    public Cart(boolean checkCart) {
        this.cartItems = new ArrayList<CartItem>();
        this.total = total;
        this.checkCart = checkCart;
    }

    public void addCartItemToCart(Product product, int quantity){
        String productName = product.getTitle();
        int productId = product.getID();
        int price = product.getPrice();

        this.total += price*quantity;
        CartItem newCartItem = new CartItem(productName, productId,quantity, price);

       this.cartItems.add(newCartItem);
    }
    public void removeCartItemFromCart(Product product, int quantity, Cart cart){
        ArrayList<CartItem> cartItems = cart.getCartItems();


        for(int i =0; i<cartItems.size(); i++ ){

            CartItem cartItem = cartItems.get(i);



            if(cartItem.getProductID() == product.getID()){

                int totalPrice = this.total;
                cart.setTotal(totalPrice - product.getPrice()*quantity);

                int currentProductQuantity = cartItem.getQuantity();

                System.out.println("CurrentProduct Quantity: " + currentProductQuantity);

                cartItem.setQuantity(currentProductQuantity-quantity);

                int cartItemTotalPrice = cartItem.getPrice();

                if(cartItemTotalPrice == 0){
                    cartItems.remove(cartItem);
                    System.out.println("Product removed");
                }
            }
        }
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isCheckCart() {
        return checkCart;
    }

    public void setCheckCart(boolean checkCart) {
        this.checkCart = checkCart;
    }
}

