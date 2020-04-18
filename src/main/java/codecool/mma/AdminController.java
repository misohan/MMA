package codecool.mma;

import java.io.IOException;
import java.util.Scanner;

public class AdminController {

AdminController(){

}
    Scanner in = new Scanner(System.in);
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
        //Scanner in = new Scanner(System.in);

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
        System.out.println("User added successfully");
    };

    public void removeUser()
    {
        //Scanner in = new Scanner(System.in);
        System.out.println("Enter Id of user to be removed ");
        int userId = in.nextInt();
        adminController.removeUser(userId);
    }

    public void readUser() {

        System.out.println("Enter Id of user to view their details ");
       // Scanner in = new Scanner(System.in);


        if(in.hasNextLine()){
            int userId = in.nextInt();
            adminController.readUser(userId);
        }

    }

    public void getAllUsers(){
        adminController.getAllUsers();
    }
    public void updateUserEmail(){

        System.out.println("Enter Id of user to update their email: ");
        String StringuserId = in.nextLine();
        int userId = Integer.parseInt(StringuserId);
        System.out.println("Enter user's new email ");
        String email = in.nextLine();
        adminController.updateUserEmail(email, userId);
    }


}
