package codecool.mma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Statement;
import java.util.List;

public class Product {
    private int ID;
    private String title;
    private String brand;
    private String model;
    private String type;
    private int price;
    private int productSize;
    private boolean availability;

    public String getProductByAttribute(String attribute, String attributeValue){
        String url = "jdbc:postgresql://localhost:5432/MMAdata";
        String user = "MMA";
        String password = "mma123";
        String getAttribute = null;

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement("SELECT * FROM products WHERE " + attribute +"=" + attributeValue + ";");
             ResultSet rs = pst.executeQuery()) {


            while (rs.next()) {

                getAttribute=rs.getString(2);

            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Product.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return getAttribute;

    }

    public void printAttribute(String attribute) {
        String url = "jdbc:postgresql://localhost:5432/MMAdata";
        String user = "MMA";
        String password = "mma123";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(attribute);
             ResultSet rs = pst.executeQuery()) {


            while (rs.next()) {

                System.out.print(rs.getInt(1));
                System.out.print(": ");
                System.out.println(rs.getString(2));
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Product.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}


