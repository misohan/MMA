package codecool.mma;

import java.util.ArrayList;

public class CartController  {
    Cart cart;

    public void proceedToCheckout(Cart cart){
        if (cart.isCheckCart()){

        }

    }
    public void checkCartSummary(Cart cart){
        ArrayList<CartItem> cartItems = cart.getCartItems();
        for(CartItem cartItem: cartItems){
            viewCartItem(cartItem);
        }
        System.out.println("Total price: " + cart.getTotal());

    }
    public void viewCartItem(CartItem cartItem){
        System.out.println("**Your product**");
        System.out.println("ProductID: " +cartItem.getProductID());
        System.out.println("Price: " + cartItem.getPrice());
        System.out.println("Quantity: " + cartItem.getQuantity());
        System.out.println("****************");

    }


}


