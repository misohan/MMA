package codecool.mma;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        ProductDAO productDAO = new ProductDAO();
        UserController userController = new UserController();

        Admin admin = new Admin();

        ServiceController serviceController = new ServiceController();
        serviceController.sayHello();
        serviceController.selectUserOrAdmin();
        serviceController.adminOptions();


        customerService.customersOptions(productDAO);



















    }
}