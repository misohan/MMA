package codecool.mma;

import java.util.HashMap;

public class CartItem {
    private int productID;
    private int quantity;
    private int price;

    public CartItem(int productID, int quantity, int price) {
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

