package myStuff;

import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.components.*;

public class CatalogScreen extends FullFunctionScreen {

	private TextField descriptionField;
	private TextField aField;
	private TextField bField;
	private Button add;
	
	public CatalogScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		descriptionField = new TextField(40, 40, 200, 30, 
				"Text Goes Here", "Description");
		aField = new TextField(40, 40, 200, 30, 
				"Text Goes Here", "Description");
		bField = new TextField(40, 40, 200, 30, 
				"Text Goes Here", "Description");
		viewObjects.add(descriptionField);
		viewObjects.add(aField);
		viewObjects.add(bField);
		
		add = new Button(20,20,20,20, "ADD", new Action() {
			
			@Override
			public void act() {
				descriptionField.setText("You clicked the button.");
				
			}
		});
	}

}
