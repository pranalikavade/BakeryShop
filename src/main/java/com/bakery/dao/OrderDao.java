
	package com.bakery.dao;

	import com.bakery.model.Order;
	import com.bakery.model.Product;
	import com.bakery.model.Customer;
	import com.bakery.util.DBConnection;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	public class OrderDAO {

	    // Place an order
	    public boolean placeOrder(Order order) throws Exception {
	        String sql = "INSERT INTO orders (customer_id, product_id, quantity, order_date) VALUES (?, ?, ?, current_timestamp)";

	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, order.customerId);
	            ps.setInt(2, order.productId);
	            ps.setInt(3, order.quantity);
	            return ps.executeUpdate() > 0;
	        }
	    }

	    // Get all orders
	    public List<Order> getAllOrders() throws Exception {
	        List<Order> list = new ArrayList<>();
	        String sql = "SELECT o.id, o.customer_id, o.product_id, o.quantity, o.order_date, " +
	                     "c.name AS customer_name, p.name AS product_name " +
	                     "FROM orders o " +
	                     "JOIN customers c ON o.customer_id = c.id " +
	                     "JOIN products p ON o.product_id = p.id " +
	                     "ORDER BY o.order_date DESC";

	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                Order o = new Order();
	                o.id = rs.getInt("id");
	                o.customerId = rs.getInt("customer_id");
	                o.productId = rs.getInt("product_id");
	                o.quantity = rs.getInt("quantity");
	                o.orderDate = rs.getTimestamp("order_date");
	                o.customerName = rs.getString("customer_name");
	                o.productName = rs.getString("product_name");
	                list.add(o);
	            }
	        }
	        return list;
	    }

	    // Get orders for a specific customer
	    public List<Order> getOrdersByCustomerId(int customerId) throws Exception {
	        List<Order> list = new ArrayList<>();
	        String sql = "SELECT o.id, o.product_id, o.quantity, o.order_date, p.name AS product_name " +
	                     "FROM orders o " +
	                     "JOIN products p ON o.product_id = p.id " +
	                     "WHERE o.customer_id = ? " +
	                     "ORDER BY o.order_date DESC";

	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, customerId);
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                    Order o = new Order();
	                    o.id = rs.getInt("id");
	                    o.productId = rs.getInt("product_id");
	                    o.quantity = rs.getInt("quantity");
	                    o.orderDate = rs.getTimestamp("order_date");
	                    o.productName = rs.getString("product_name");
	                    list.add(o);
	                }
	            }
	        }
	        return list;
	    }
	}

	
	
}
