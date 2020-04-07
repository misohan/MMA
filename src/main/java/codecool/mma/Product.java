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

    public Product getProductByStatement(String attribute, String attributeValue) {
        String url = "jdbc:postgresql://localhost:5432/MMAdata";
        String user = "MMA";
        String password = "mma123";
        String getAttribute = null;

        Product product = new Product();

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement("SELECT * FROM products WHERE " + attribute + "=" + attributeValue + ";");
             ResultSet rs = pst.executeQuery()) {


            while (rs.next()) {

                product.setID(rs.getInt("id"));
                product.setTitle(rs.getString("title"));
                product.setBrand(rs.getString("brand"));
                product.setModel(rs.getString("model"));
                product.setType(rs.getString("type"));
                product.setProductSize(rs.getInt("productSize"));
                product.setPrice(rs.getInt("productSize"));
                product.setAvailability(rs.getBoolean("availability"));


            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Product.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return product;

    }

    public ArrayList<Product> getAllProducts() {
        String url = "jdbc:postgresql://localhost:5432/MMAdata";
        String user = "MMA";
        String password = "mma123";
        ArrayList<Product> products = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement("SELECT * FROM products;");
             ResultSet rs = pst.executeQuery()) {


            while (rs.next()) {

                Product product = new Product();
                product.setID(rs.getInt("id"));
                product.setTitle(rs.getString("title"));
                product.setBrand(rs.getString("brand"));
                product.setModel(rs.getString("model"));
                product.setType(rs.getString("type"));
                product.setProductSize(rs.getInt("productSize"));
                product.setPrice(rs.getInt("productSize"));
                product.setAvailability(rs.getBoolean("availability"));
                products.add(product);

            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(Product.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return products;
    }
    public void createProduct(int ID, String title, String brand, String model, String type, int price, int productSize, boolean availability){
        String url = "jdbc:postgresql://localhost:5432/MMAdata";
        String user = "MMA";
        String password = "mma123";

        String comma = "', '";

        String statement = "INSERT INTO products VALUES (" +ID + ", '" + title + comma + brand + comma + model + comma + type + comma + price + comma + productSize + "'," + availability + ");";

        System.out.println(statement);

        try {Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            st.executeUpdate(statement);

        } catch (SQLException e) {
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductSize() {
        return productSize;
    }

    public void setProductSize(int productSize) {
        this.productSize = productSize;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}




