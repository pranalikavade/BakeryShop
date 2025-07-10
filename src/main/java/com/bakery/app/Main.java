package com.bakery.app;

	import com.bakery.service.BakeryService;

	public class Main {
	    public static void main(String[] args) {
	        BakeryService service = new BakeryService();
	        service.run();  // Launches the console-based bakery menu
	    }
	}
