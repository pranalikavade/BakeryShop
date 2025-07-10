
	package com.bakery.model;

	import java.sql.Timestamp;

	public class Order {
	    public int id;
	    public int customerId;
	    public int productId;
	    public int quantity;
	    public Timestamp orderDate;

	    // Optional: extra display fields
	    public String customerName;
	    public String productName;

	    @Override
	    public String toString() {
	        return "Order #" + id +
	                " | Customer: " + customerName +
	                " | Product: " + productName +
	                " | Qty: " + quantity +
	                " | Date: " + orderDate;
	    }
	}
	
	
