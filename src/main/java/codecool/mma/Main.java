package codecool.mma;

public class Main {
    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.readProductByID(1);
        CartController cartController = new CartController();
        Product product1 = productDAO.readProductByID(2);

        UserController userController = new UserController();

        Admin admin = new Admin();

//        userController.getAllUsers();

        OrderDAO orderDAO = new OrderDAO();

        orderDAO.readOrderByID(1);

        Order order = orderDAO.readOrderByID(1);


        OrderController orderController = new OrderController();

        orderController.showOrder(order);












    }
}