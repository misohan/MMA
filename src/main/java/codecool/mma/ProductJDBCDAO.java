package codecool.mma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductJDBCDAO implements ProductDAO {
    private List<Product> products = new ArrayList<>();
    private ProductSQLConn dbConn = new ProductSQLConn();

    public Product readProductByID(int id) {
        Product product = new Product();

        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement("SELECT * FROM products WHERE ID = " + id);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                product.setTitle(rs.getString("title"));
                product.setBrand(rs.getString("brand"));
                product.setModel(rs.getString("model"));
                product.setType(rs.getString("type"));
                product.setPrice(rs.getInt("price"));
                product.setProductSize(rs.getInt("productSize"));
                product.setAvailability(rs.getBoolean("availability"));
                product.setID(rs.getInt("id"));

                con.close();
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(ProductJDBCDAO.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return product;
    }

    public List<Product> getAllProducts() {
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
                product.setPrice(rs.getInt("price"));
                product.setProductSize(rs.getInt("productSize"));
                product.setAvailability(rs.getBoolean("availability"));
                products.add(product);

                con.close();
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(ProductJDBCDAO.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return products;
    }

    public void createProduct(Product product) {

        String sql = "INSERT INTO products (ID, title, brand, model, type, price, productSize, availability) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            // set the corresponding parameter

            pst.setInt(1, product.getID());
            pst.setString(2, product.getTitle());
            pst.setString(3, product.getBrand());
            pst.setString(4, product.getModel());
            pst.setString(5, product.getType());
            pst.setInt(6, product.getPrice());
            pst.setInt(7, product.getProductSize());
            pst.setBoolean(8, product.getAvailability());

            // update
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateProductByID(Product product) {
        String sql = "UPDATE products "
                + "SET title= ?, brand= ?, model= ?, type= ?, price= ?, productSize= ?, availability = ? "
                + "WHERE ID = ?";

        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            // set the corresponding param
            pst.setString(1, product.getTitle());
            pst.setString(2, product.getBrand());
            pst.setString(3, product.getModel());
            pst.setString(4, product.getType());
            pst.setInt(5, product.getPrice());
            pst.setInt(6, product.getProductSize());
            pst.setBoolean(7, product.getAvailability());
            pst.setInt(8, product.getID());
            pst.executeUpdate();

            // update
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeProductByID(int id) {
        String sql = "DELETE from products WHERE ID= ?";

        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            // set the corresponding parameter

            pst.setInt(1, id);

            // update
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}



