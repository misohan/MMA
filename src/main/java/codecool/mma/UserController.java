package codecool.mma;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;


public class UserController implements UserDAO {

    private UserSQLConnection dbConn = new UserSQLConnection();
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public UserController() {
    }

    //UserController userController = new UserController();

    public void readUser(int userId) {

        String sql = "SELECT * FROM users WHERE UserId=?";

        try
                (Connection con = dbConn.connect();
                 PreparedStatement ptmt = con.prepareStatement(sql)) {
            ptmt.setInt(1, userId);
            resultSet = ptmt.executeQuery();

            if (resultSet.next()) {

               System.out.println("Name: " + resultSet.getString("name")
                        + "\nSurname: " + resultSet.getString("surname")
               +"\nEmail: " + resultSet.getString("email"));
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    public User getUserByStatement(String attribute, String attributeValue) {
//
//
//        try (Connection con = dbConn.connect() ;
//             PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE " + attribute + "="
//                     + attributeValue + ";");
//             ResultSet rs = pst.executeQuery()) {
//
//            while (rs.next()) {
//
//                user.setName(rs.getString("name"));
//                user.setSurname(rs.getString("surname"));
//                user.setPassword(rs.getString("password"));
//                user.setEmail(rs.getString("password"));
//                user.setLoginStatus(rs.getBoolean("availability"));
//
//
//            }
//        } catch (SQLException ex) {
//
//            Logger lgr = Logger.getLogger(ProductDAO.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
//        }
//        return user;
//    }

    // updating user is not working correctly at this point.

    public void updateUserEmail(String email, int userId) {

        String sql = "UPDATE users SET email=? WHERE userId=?";

        try
                (Connection con = dbConn.connect();
                 PreparedStatement ptmt = con.prepareStatement(sql)) {
//don't know why, but the parameters are swaped and it works now

            ptmt.setString(1, email);
            ptmt.setInt(2, userId);
            ptmt.executeUpdate();
            System.out.println("Email updated successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public void createUser(User user) {

        String sql = "INSERT INTO users (name, surname, password, email, loginStatus) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = dbConn.connect();
             PreparedStatement ptmt = con.prepareStatement(sql)) {

            // set the corresponding parameter

            ptmt.setString(1, user.getName());
            ptmt.setString(2, user.getSurname());
            ptmt.setString(3, user.getPassword());
            ptmt.setString(4, user.getEmail());
            ptmt.setBoolean(5, user.getLoginStatus());

            // update
            ptmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeUser(int userId) {

        String sql = "DELETE FROM users WHERE userId=?";

        try
                (Connection con = dbConn.connect();
                 PreparedStatement ptmt = con.prepareStatement(sql)) {

            ptmt.setInt(1, userId);
            ptmt.executeUpdate();
            System.out.println("Data deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getAllUsers() {

            String sql = "SELECT * FROM users";

            try
                    (Connection con = dbConn.connect();
                     PreparedStatement ptmt = con.prepareStatement(sql)) {
                resultSet = ptmt.executeQuery();
                while (resultSet.next()) {
                    System.out.println("Id: " + resultSet.getInt("userId")
                            + ", Name: " + resultSet.getString("name") + ", Surname: "
                            + resultSet.getString("surname") + ", Email Address: "
                            + resultSet.getString("email"));

        }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            }

    public void LogInLogOut(User user) {

        if (user.getLoginStatus().equals(false)) {
            user.setLoginStatus(true);
            System.out.println("Logged in successfully");
        } else {
            user.setLoginStatus(false);
            System.out.println("You were logged out");
        }
    }
}




