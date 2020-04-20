package codecool.mma;

public class Main {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductJDBCDAO();
        UserDAO userDAO = new UserJDBCDAO();


        ServiceController serviceController = new ServiceController(productDAO, userDAO);
        serviceController.sayHello();
        serviceController.selectUserOrAdmin();
        serviceController.adminOptions();
    }
}