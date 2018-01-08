package myStuff.simon;

import guiTeacher.GUIApplication;

public class SimonGameKevin extends GUIApplication {

	public static SimonGameKevin game;
	public static SimonScreenKevin screen;
	
	
	public SimonGameKevin(int width, int height) {
		super(width, height);
		setVisible(true);
	}
	@Override
	public void initScreen() {
		screen = new SimonScreenKevin(getWidth(), getHeight());
		setScreen(screen);

	}
	public static void main(String[] args)
	{
		game = new SimonGameKevin(800,800);
		Thread runner = new Thread(game);
		runner.start();
	}


}
