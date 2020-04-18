package codecool.mma;

import java.util.Scanner;

public class ServiceController {
    //    whole application should be here

    Scanner in = new Scanner(System.in);
    private int adminOptionSelected;
    AdminController adminController = new AdminController();
    //ServiceController serviceController = new ServiceController();

    public void sayHello() {
        System.out.println("================= MMA Shoe Store =================\n");
    }

    public void selectUserOrAdmin() {
        System.out.println("Please select 'u' for user or 'a' for admin");

        String optionSelected = in.nextLine();

        if (optionSelected.equals("u")) {
            System.out.println("Welcome, user!");
            //here to put interface for user
        } else if (optionSelected.equals("a")) {
            System.out.println("Welcome, admin!");
            adminOptions();
        } else {
            selectUserOrAdmin();
        }
    }

    public void adminOptions() {
        System.out.println("\nPlease select '1' to view a user");
        System.out.println("Please select '2' to update user's email");
        System.out.println("Please select '3' to view all users");
        System.out.println("Please select '4' to remove a user from database");
        System.out.println("Please select '5' to add a new user");


        while (true)
            try {
                adminOptionSelected = in.nextInt();
                break;
            } catch (NumberFormatException nfe) {
                System.out.print("Try again: ");
            }

        switch (adminOptionSelected) {
            case 1:
                adminController.readUser();
                adminOptions();
                break;
            case 2:
                adminController.updateUserEmail();
                adminOptions();
                break;
            case 3:
                adminController.getAllUsers();
                adminOptions();
                break;
            case 4:
                adminController.removeUser();
                adminOptions();
                break;
            case 5:
                adminController.createNewUser();
                adminOptions();
                break;
        }

    }

}