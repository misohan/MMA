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
        int productId = product.getID();
        int price = product.getPrice();

        System.out.println("price" + price);

        this.total += price;
        CartItem newCartItem = new CartItem(productId,quantity, price);

       this.cartItems.add(newCartItem);
    }
    public void removeCartItemFromCart(Product product, int quantity){
        for(CartItem cartItem: this.cartItems){
            if(cartItem.getProductID() == product.getID()){
                cartItems.remove(cartItem);
            }
            System.out.println("No such product in your Cart");
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

