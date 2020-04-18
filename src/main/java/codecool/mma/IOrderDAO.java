package codecool.mma;

import java.util.ArrayList;

public interface IOrderDAO {
    ArrayList<Order> getAllOrders();
    void createOrder(int orderID, int userID, String paymentMethod, String shippingMethod);
    void updateOrderByID(int orderID, int userID, String paymentMethod, String shippingMethod);
    void removeOrderByID(int ID);
}
