

	package com.bakery.dao;

	import com.bakery.model.Product;
	import com.bakery.util.DBConnection;

	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	public class CustomerDAO {

	    // Fetch all products
	    public List<Product> getAllProducts() throws Exception {
	        List<Product> list = new ArrayList<>();
	        String sql = "SELECT * FROM products ORDER BY id";

	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {

	            while (rs.next()) {
	                Product p = new Product();
	                p.id = rs.getInt("id");
	                p.name = rs.getString("name");
	                p.price = rs.getDouble("price");
	                p.stock = rs.getInt("stock");
	                list.add(p);
	            }
	        }
	        return list;
	    }

	    // Add a new product
	    public boolean addProduct(Product p) throws Exception {
	        String sql = "INSERT INTO products(name, price, stock) VALUES (?, ?, ?)";

	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setString(1, p.name);
	            ps.setDouble(2, p.price);
	            ps.setInt(3, p.stock);

	            return ps.executeUpdate() > 0;
	        }
	    }

	    // Update product stock
	    public boolean updateStock(int productId, int newStock) throws Exception {
	        String sql = "UPDATE products SET stock = ? WHERE id = ?";

	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, newStock);
	            ps.setInt(2, productId);

	            return ps.executeUpdate() > 0;
	        }
	    }

	    // Delete a product
	    public boolean deleteProduct(int productId) throws Exception {
	        String sql = "DELETE FROM products WHERE id = ?";

	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, productId);

	            return ps.executeUpdate() > 0;
	        }
	    }

	    // Get a single product by ID
	    public Product getProductById(int id) throws Exception {
	        String sql = "SELECT * FROM products WHERE id = ?";

	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, id);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    Product p = new Product();
	                    p.id = rs.getInt("id");
	                    p.name = rs.getString("name");
	                    p.price = rs.getDouble("price");
	                    p.stock = rs.getInt("stock");
	                    return p;
	                }
	            }
	        }
	        return null;
	    }
	}

}
