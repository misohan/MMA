package codecool.mma;

//import java.util.List;

public interface UserDAO {
    void getAllUsers();

    void createUser(User user);
    void updateUserEmail(String email, int userId);
    void removeUser(int userId);
    void readUser(int userId);






}
