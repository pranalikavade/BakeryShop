package com.bakery.service;

import com.bakery.dao.CustomerDAO;
import com.bakery.dao.OrderDAO;
import com.bakery.dao.ProductDAO;
import com.bakery.model.Customer;
import com.bakery.model.Order;
import com.bakery.model.Product;

import java.util.List;
import java.util.Scanner;

public class BakeryService {

    private final Scanner sc = new Scanner(System.in);
    private final ProductDAO productDAO = new ProductDAO();
    private final CustomerDAO customerDAO = new CustomerDAO();
    private final OrderDAO orderDAO = new OrderDAO();

    public void run() {
        System.out.println("==== Welcome to Online Bakery Shop ====");

        while (true) {
            System.out.println("\n📋 Main Menu:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. View Customers");
            System.out.println("4. Add Customer");
            System.out.println("5. Place Order");
            System.out.println("6. View All Orders");
            System.out.println("7. Exit");
            System.out.print("Select option: ");
            String choice = sc.nextLine();

            try {
                switch (choice) {
                    case "1" -> viewProducts();
                    case "2" -> addProduct();
                    case "3" -> viewCustomers();
                    case "4" -> addCustomer();
                    case "5" -> placeOrder();
                    case "6" -> viewOrders();
                    case "7" -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }
    }

    private void viewProducts() throws Exception {
        List<Product> list = productDAO.getAllProducts();
        if (list.isEmpty()) {
            System.out.println("No products found.");
        } else {
            list.forEach(System.out::println);
        }
    }

    private void addProduct() throws Exception {
        Product p = new Product();
        System.out.print("Enter product name: ");
        p.name = sc.nextLine();
        System.out.print("Enter product price: ");
        p.price = Double.parseDouble(sc.nextLine());
        System.out.print("Enter stock quantity: ");
        p.stock = Integer.parseInt(sc.nextLine());

        if (productDAO.addProduct(p)) {
            System.out.println("✅ Product added.");
        } else {
            System.out.println("❌ Failed to add product.");
        }
    }

    private void viewCustomers() throws Exception {
        List<Customer> list = customerDAO.getAllCustomers();
        if (list.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            list.forEach(System.out::println);
        }
    }

    private void addCustomer() throws Exception {
        Customer c = new Customer();
        System.out.print("Enter customer name: ");
        c.name = sc.nextLine();
        System.out.print("Enter customer phone: ");
        c.phone = sc.nextLine();

        if (customerDAO.addCustomer(c)) {
            System.out.println("✅ Customer added.");
        } else {
            System.out.println("❌ Failed to add customer.");
        }
    }

    private void placeOrder() throws Exception {
        System.out.print("Enter customer ID: ");
        int customerId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter product ID: ");
        int productId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        Order order = new Order();
        order.customerId = customerId;
        order.productId = productId;
        order.quantity = quantity;

        if (orderDAO.placeOrder(order)) {
            System.out.println("✅ Order placed.");
        } else {
            System.out.println("❌ Failed to place order.");
        }
    }

    private void viewOrders() throws Exception {
        List<Order> list = orderDAO.getAllOrders();
        if (list.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            list.forEach(System.out::println);
        }
    }
}
