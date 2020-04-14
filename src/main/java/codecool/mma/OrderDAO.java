package codecool.mma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDAO implements IOrderDAO {

    private ArrayList<Order> orders = new ArrayList<>();
    private OrderSQLConn dbConn = new OrderSQLConn();


    public Order readOrderByID(int ID) {
        Order order = new Order();

        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement("SELECT * FROM orders WHERE ID = " + ID);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                order.setOrderID(rs.getInt("orderID"));
                order.setUserID(rs.getInt("userID"));
                order.setPaymentMethod(rs.getString("paymentMethod"));
                order.setShippingMethod(rs.getString("shippingMethod"));

                con.close();
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(OrderDAO.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return order;
    }

    public void createOrder (int orderID, int userID, String paymentMethod, String shippingMethod) {
        String sql = "INSERT into orders (orderID, userID, paymentMethod, shippingMethod)" + "VALUES (?, ?, ?, ?)";
        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, orderID);
            pst.setInt(2, userID);
            pst.setString(3, paymentMethod);
            pst.setString(4, shippingMethod);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Order> getAllOrders() {
        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement("SELECT * FROM orders;");
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("orderID"));
                order.setUserID(rs.getInt("userID"));
                order.setPaymentMethod(rs.getString("paymentMethod"));
                order.setShippingMethod(rs.getString("shippingMethod"));
            }
        } catch (SQLException ex) {
            Logger lrg = Logger.getLogger(OrderDAO.class.getName());
            lrg.log(Level.SEVERE, ex.getMessage(), ex);

        }
        return this.orders;
    }

    public void updateOrderByID(int orderID, int userID, String paymentMethod, String shippingMethod) {
        String sql = "UPDATE order" + "SET paymentMethod = ?, shippingMethod + WHERE ID = ?";
        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {
             pst.setString(1, paymentMethod);
             pst.setString(2, shippingMethod);
             pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void removeOrderByID (int orderID) {
        String sql  = "Delete from products WHERE ID = ?";

        try { Connection con = dbConn.connect();
            PreparedStatement pst = con.prepareStatement(sql); {
            pst.setInt(1, orderID);
            pst.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

