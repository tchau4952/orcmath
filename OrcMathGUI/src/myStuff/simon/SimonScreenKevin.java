package myStuff.simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenKevin extends ClickableScreen implements Runnable {

	public SimonScreenKevin(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	private TextLabel label;
	private ButtonInterfaceKevin[] buttons;
	private ProgressInterfaceKevin progress;
	private ArrayList<MoveInterfaceKevin> sequence;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceKevin b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceKevin>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceKevin randomMove() {
		int bIndex = (int)(Math.random()*buttons.length);
	    while(bIndex == lastSelectedButton){
	        bIndex = (int)(Math.random()*buttons.length);
	    }
	    return getMove(bIndex);
	}

	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	
	private MoveInterfaceKevin getMove(int bIndex) {
		return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	
	private ProgressInterfaceKevin getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 6;
		buttons = new ButtonInterfaceKevin[numberOfButtons];
		
		Color[] color = new Color[5];
		color[0] = Color.red;
		color[1] = Color.magenta;
		color[2] = Color.blue;
		color[3] = Color.green;
		color[4] = Color.yellow;
		color[5] = Color.orange;
		
		for (int i = 0; i < numberOfButtons; i++) {
			final ButtonInterfaceKevin b = getAButton();
			buttons[i] = b;
			
			b.setColor(color[i]);
			b.setX(i*100 + 100);
			b.setY(200);
			
			b.setAction(new Action() {
				
				public void act() {
					if (acceptingInput) {
						Thread blink = new Thread (new Runnable() {
							
							public void run() {
								b.highlight();
								try {
									Thread.sleep(800);
									} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									}
									b.dim();
							}
						});
						blink.start();
						
						if (b == sequence.get(sequenceIndex).getButton()){
							sequenceIndex++;
						} else {
							progress.gameOver();
						}
						
						if(sequenceIndex == sequence.size()){
							Thread nextRound = new Thread(SimonScreenBen.this); 
							nextRound.start();
						}
					}
				}
			});
		}
	}

	/**
	Placeholder until partner finishes implementation of ButtonInterface
	*/
	
	private ButtonInterfaceKevin getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run() {
		label.setText("");
   		nextRound();	
	}

}
