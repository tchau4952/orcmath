package myStuff;

import java.util.List;

import guiPlayer.CatalogMaker;
import guiPlayer.Pizza;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.components.*;

public class CatalogScreen extends FullFunctionScreen {

	private TextField orderNumberField;
	private TextField typeField;
	private TextField toppingsField;
	private TextField priceField;
	private TextField amountField;
	private Button add;
	private CatalogMaker catalog;
	private TextArea textarea;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		catalog = new CatalogMaker();
		
		orderNumberField = new TextField(40, 50, 200, 30, 
				"orderNumber", "Description");
		viewObjects.add(orderNumberField);
		//
		typeField = new TextField(40, 100, 200, 30, 
				"type", "Description");
		viewObjects.add(typeField);
		//
		toppingsField = new TextField(40, 150, 200, 30, 
				"toppings", "Description");
		viewObjects.add(toppingsField);
		//
		priceField = new TextField(40, 200, 200, 30, 
				"price", "Description");
		viewObjects.add(priceField);
		//
		amountField = new TextField(40, 250, 200, 30, 
				"amount", "Description");
		viewObjects.add(amountField);
		//
		add = new Button(40,300,200,20, "ADD", new Action() {
			@Override
			public void act() {
				orderNumberField.setText(addButtonClicked());
				
			}
		});
		viewObjects.add(add);
		//
		textarea = new TextArea(300, 50, 200, 30, "Text");
		viewObjects.add(textarea);
	}


	protected String addButtonClicked() {
		Pizza p = new Pizza(Integer.parseInt(orderNumberField.getText()), typeField.getText(), toppingsField.getText(),
				Double.parseDouble(priceField.getText()), Integer.parseInt(amountField.getText()));
		String s = textarea.getText() + p + "New Line Characters" + "\n";
		textarea.setText(s);
		catalog.addNewItem(Integer.parseInt(orderNumberField.getText()), typeField.getText(), toppingsField.getText(),
				Double.parseDouble(priceField.getText()), Integer.parseInt(amountField.getText()));
		
		orderNumberField.setText("");
		typeField.setText("");
		toppingsField.setText("");
		priceField.setText("");
		amountField.setText("");
		orderNumberField.setText("");
		priceField.setInputType(TextField.inputTypeNumeric);
	}

}
