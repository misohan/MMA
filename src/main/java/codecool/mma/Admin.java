package codecool.mma;

public class Admin {


    private String name;
    private String phoneNumber;
    private String email;

    public Admin(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    private Admin admin = new Admin(name, phoneNumber, email) {};

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getEmail() {
            return email;
        }

}



