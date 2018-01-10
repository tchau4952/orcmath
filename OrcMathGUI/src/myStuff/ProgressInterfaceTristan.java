package myStuff;

import guiTeacher.interfaces.Visible;

public interface ProgressInterfaceTristan extends Visible {
	void gameOver();
	
	void setRound(int x);
	
	void setSequenceSize(int x);
}