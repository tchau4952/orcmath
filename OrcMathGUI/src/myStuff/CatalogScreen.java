package myStuff;

import java.util.List;

import guiPlayer.CatalogMaker;
<<<<<<< HEAD
import guiPlayer.Monsters;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.components.*;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField nameField;
	private TextField typeField;
	private TextField hpField;
	private TextField fireResField;
	private TextField iceResField;
	private TextField waterResField;
	private TextField descriptionField;
	private Button add;
	private TextArea descriptionArea;
	private CatalogMaker catalog;

	public CatalogScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		catalog = new CatalogMaker();
		nameField = new TextField(40,40,200,30,"","Monster Name");
		viewObjects.add(nameField);
		hpField = new TextField(40,100,200,30, "", "Base HP");
		hpField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(hpField);
		fireResField = new TextField(40, 160, 200, 30, "", "Fire Res");
		fireResField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(fireResField);
		iceResField = new TextField(40, 220, 200, 30, "", "Ice Res");
		iceResField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(iceResField);
		waterResField = new TextField(40, 280, 200, 30, "", "Water Res");
		waterResField.setInputType(TextField.INPUT_TYPE_NUMERIC);
		viewObjects.add(waterResField);
		descriptionField = new TextField(40, 160, 200, 30, "", "rawr");
		add = new Button(260,40,40,40,"Add", new Action(){
			@Override
			public void act() {
				descriptionField.setText(addButtonClicked());
			}
		});
		descriptionArea = new TextArea(40, 280, 200, 30, "Insert text here");
		viewObjects.add(descriptionArea);
		viewObjects.add(add);
	}

	protected String addButtonClicked() {
		Monsters m = new Monsters(nameField.getText(), Integer.parseInt(hpField.getText()), Integer.parseInt(fireResField.getText()), Integer.parseInt(iceResField.getText()), borderWidth, borderWidth, borderWidth, borderWidth, borderWidth, borderWidth, borderWidth, borderWidth, borderWidth, name, alpha);
		String s = descriptionArea.getText() + m + "\n";
		descriptionArea.setText(s);;
		catalog.getCatalog().add(m);
		return null;
	}
	
	

}
=======
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
