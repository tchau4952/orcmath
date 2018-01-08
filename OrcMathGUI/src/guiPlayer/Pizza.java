package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Pizza extends AnimatedComponent {

	private int orderNumber;
	private String type;
	private String toppings;
	private double price;
	private int amount;
	
	public Pizza(int orderNumber, String type, String toppings, double price, int amount) {
		super(40, 40, 100, 100);
		//addSequence("resources/sheet.png", 150, 0, 0, 89, 175, 5);
		//Thread animation = new Thread(this);
		//animation.start();
		
		this.orderNumber = orderNumber;
		this.type = type;
		this.toppings = toppings;
		this.price = price;
		this.amount = amount;
		
		update();
		
	}

	
	public void update(Graphics2D g) {
	//	g.setColor(Color.PINK);
	//	g.fillRect(0, 0, getWidth(), getHeight());
	//	super.update(g);
	}

	public String toString() {
		return orderNumber + "," + type + "," + toppings + "," + price + "," + amount;
	}
	
}
