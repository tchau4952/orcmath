package myStuff;

import guiTeacher.GUIApplication;

public class SimonGameTristan extends GUIApplication {

	public static CatalogMakerGUI catalog;
	public static OpeningScreen opener;
	public static NextScreen transition;

	public SimonGameTristan(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		catalog = new CatalogMakerGUI(500, 500);
		Thread go = new Thread(catalog);
		go.start();
	}
//


	@Override

	public void initScreen() {
		opener = new OpeningScreen(getWidth(), getHeight());
		transition = new NextScreen(getWidth(), getHeight());
		setScreen(opener);
		//setScreen(transition);

	}
}
