package myStuff;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceTristan extends Clickable {
	void setColor(Color color);
	
	void setAction(Action action);
	
	void highlight();
	
	void dim();
}