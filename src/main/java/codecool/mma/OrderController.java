package codecool.mma;

import java.util.ArrayList;

public class OrderController {

    private OrderDAO orderDAO;

    public OrderController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public ArrayList<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public void showOrder(Order order) {
        System.out.println(order.getOrderID());
        System.out.println(order.getUserID());
        System.out.println(order.getPaymentMethod());
        System.out.println(order.getShippingMethod());
    }

    public void showAllOrders(ArrayList<Order> allOrders) {
        for (Order order : allOrders) {
            showOrder(order);
        }
    }

}
