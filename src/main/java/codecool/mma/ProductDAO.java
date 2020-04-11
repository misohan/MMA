package codecool.mma;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ProductDAO implements IProductDAO {
    private Product product;
    private ArrayList<Product> products = new ArrayList<>();
    private ProductSQLConn dbConn = new ProductSQLConn();


    public Product getProductByStatement(String attribute, String attributeValue) {
        try (Connection con = dbConn.connect() ;
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

                con.close();
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(ProductDAO.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return product;
    }

    public ArrayList<Product> getAllProducts() {
        try (Connection con = dbConn.connect();
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

                con.close();
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(ProductDAO.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return products;
    }
    public void createProduct(int ID, String title, String brand, String model, String type, int price, int productSize, boolean availability){

        String sql = "INSERT INTO products (ID, title, brand, model, type, price, productSize, availability) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            // set the corresponding parameter

            pst.setInt(1, ID);
            pst.setString(2, title);
            pst.setString(3, brand);
            pst.setString(4,model);
            pst.setString(5,type);
            pst.setInt(6,price);
            pst.setInt(7,productSize);
            pst.setBoolean(8,availability);

            // update
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateProductByID(int ID, String title, String brand, String model, String type, int price, int productSize, boolean availability) {

        String sql = "UPDATE products "
                + "SET title= ?, brand= ?, model= ?, type= ?, price= ?, productSize= ?, availability = ? "
                + "WHERE ID = ?";

        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            // set the corresponding param

            pst.setString(1, title);
            pst.setString(2, brand);
            pst.setString(3, model);
            pst.setString(4, type);
            pst.setInt(5, price);
            pst.setInt(6, productSize);
            pst.setBoolean(7, availability);
            pst.setInt(8, ID);
            pst.executeUpdate();

            // update
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void removeProductByID(int ID){
        String sql = "DELETE from products WHERE ID= ?";

        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            // set the corresponding parameter

            pst.setInt(1, ID);

            // update
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}



