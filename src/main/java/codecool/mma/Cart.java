package codecool.mma;

public class Cart {
    private int ProductID;
    private int quantity;
    private int totalCost;
    private boolean readyForCheckout;

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public boolean getReadyForCheckout() {
        return readyForCheckout;
    }

    public void setReadyForCheckout(boolean readyForCheckout) {
        this.readyForCheckout = readyForCheckout;
    }

}
