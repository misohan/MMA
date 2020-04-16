package codecool.mma;

public class Admin {



    private String name = "MMA Shoe Store";
    private String phoneNumber = "+48 800 300 200";
    private String email = "mma@mma.com";


    public Admin() {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //public Admin admin = new Admin();

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



