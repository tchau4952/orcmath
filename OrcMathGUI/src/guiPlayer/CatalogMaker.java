package guiPlayer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker {

	private ArrayList<Pizza> catalog;
	
	public CatalogMaker() {
		catalog = new ArrayList<Pizza>();
		catalog.add(new Pizza(1, "Regular", "Pepperoni", 3.50, 1));
		catalog.add(new Pizza(2, "Sicilian", "Pepperoni", 3.50, 1));
		catalog.add(new Pizza(3, "Regular", "Pepperoni", 3.50, 1));
		catalog.add(new Pizza(4, "Sicilian", "Pepperoni", 3.50, 1));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CatalogMaker c = new CatalogMaker();
		System.out.println(c.getCSVContent());
		c.saveContent("yay.csv");
	}

	public String getCSVContent() {
		String data = "orderNumber, type, toppings, price, amount\n";
		for(Pizza p: catalog) {
			data += p + "\n";
		}
		return data;
	}
	
	public void addNewItem(int orderNumber, String type, String toppings, double price, int amount) {
		catalog.add(new Pizza(orderNumber, type, toppings, price, amount));
		System.out.println("Item added successfully!");
	}
	
	private void saveContent(String fileName) {
		try{    
			FileWriter fw=new FileWriter("BookCatalog.csv");
			for(Pizza b: catalog){
				fw.write(b+"\n");    	
			}
			fw.close();    
			System.out.println("Success! File \"BookCatalog.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}
}
