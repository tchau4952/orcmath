package guiPlayer;

import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker {

	private ArrayList<Pizza> catalog;
	
	public CatalogMaker() {
		catalog = new ArrayList<Pizza>();
		catalog.add(new Pizza("Order 1", "Regular", "Pepperoni", 3.50, 1));
		catalog.add(new Pizza("Order 2", "Sicilian", "Pepperoni", 3.50, 1));
		catalog.add(new Pizza("Order 3", "Regular", "Pepperoni", 3.50, 1));
		catalog.add(new Pizza("Order 4", "Sicilian", "Pepperoni", 3.50, 1));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CatalogMaker c = new CatalogMaker();
		System.out.println(c.getCSVContent());
	}

	public String getCSVContent() {
		String data = "orderNumber, type, toppings, price, amount\n";
		for(Pizza p: catalog) {
			data += p + "\n";
		}
		return data;
	}
	
	public void addNewItem(String orderNumber, String type, String toppings, double price, int amount) {
		catalog.add(new Pizza(orderNumber, type, toppings, price, amount));
		System.out.println("Item added successfully!");
	}
	
}
