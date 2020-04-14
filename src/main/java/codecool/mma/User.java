package codecool.mma;

public class User {

    private int userId;
    private String name;
    private  String surname;
    private String password;
    private String email;
    private Boolean loginStatus;

    public User(int userId, String name, String surname,
                String password, String email, Boolean loginStatus) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.loginStatus = loginStatus;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }

}
