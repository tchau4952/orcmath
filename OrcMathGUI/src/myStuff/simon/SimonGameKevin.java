package myStuff.simon;

import guiTeacher.GUIApplication;

public class SimonGameKevin extends GUIApplication {

	public SimonGameKevin(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		SimonScreenKevin screen = new SimonScreenKevin(getWidth(), getHeight());
		setScreen(screen);

	}

	public static void main(String[] args) {
		SimonGameKevin s = new SimonGameKevin(800, 550);
		Thread runner = new Thread(s);
		runner.start();
	}

}
