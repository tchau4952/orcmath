package myStuff;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenTristanChau extends ClickableScreen implements Runnable {

	public TextLabel currentRound;
	public ButtonInterfaceTristanChau[] buttons;
	public ProgressInterfaceTristanChau gameInfo;
	public ArrayList<MoveInterfaceTristanChau> sequence;
	int roundNumber;
	boolean acceptingInput;
	int sequenceIndex;
	int lastSelectedButton;
	
	public SimonScreenTristanChau(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceTristanChau b: buttons){ 
		    viewObjects.add(b); 
		}
		gameInfo = getProgress();
		currentRound = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceTristanChau>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(gameInfo);
		viewObjects.add(currentRound);
	}

	private MoveInterfaceTristanChau randomMove() {
		int buttonIndex = (int)(Math.random()*buttons.length);
	    while(buttonIndex == lastSelectedButton){
	        buttonIndex = (int)(Math.random()*buttons.length);
	    }
	    return getMove(buttonIndex);
	}
	
	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	
	private MoveInterfaceTristanChau getMove(int buttonIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceTristanChau getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 3;
		buttons = new ButtonInterfaceTristanChau[numberOfButtons];
	}

	@Override
	public void run() {
		
	}
}
