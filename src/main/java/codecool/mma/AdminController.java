package codecool.mma;

import java.util.Scanner;

public class AdminController {

AdminController(){

}
UserController adminController = new UserController();

    public static void getContactDetails(Admin admin){
        System.out.println("=================");
        System.out.println("Contact details to "+admin.getName());
        System.out.println("=================");
        System.out.println("Phone "+admin.getPhoneNumber());
        System.out.println("=================");
        System.out.println("Email "+admin.getEmail());

    }

    public void createNewUser(){
        System.out.println("Please provide the details of a user to be added ");
        Scanner in = new Scanner(System.in);

        System.out.println("Enter user name ");
        String name = in.nextLine();
        System.out.println("Enter user surname ");
        String surname = in.nextLine();
        System.out.println("Enter user password ");
        String password = in.nextLine();
        System.out.println("Enter user email ");
        String email = in.nextLine();
        boolean loginStatus = false;
      User newUser = new User(name, surname, password, email, loginStatus);

        adminController.createUser(newUser);

    };

    public void removeUser()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Id of user to be removed ");
        int userId = in.nextInt();
        adminController.removeUser(userId);
    }

    public void readUser() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Id of user to view their details ");
        int userId = in.nextInt();
        adminController.readUser(userId);
    }

    public void getAllUsers(){
        adminController.getAllUsers();
    }
    public void updateUserEmail(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter Id of user to update their email: ");
        String StringuserId = in.nextLine();
        int userId = Integer.parseInt(StringuserId);
        System.out.println("Enter user's new email ");
        String email = in.nextLine();
        in.close();
        adminController.updateUserEmail(email, userId);
    }
}
