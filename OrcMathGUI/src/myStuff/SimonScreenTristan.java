package myStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenTristan extends ClickableScreen implements Runnable{

	private static final long serialVersionUID = 3565322860517751569L;
	private static ProgressInterfaceTristan progress;
	private ArrayList<MoveInterfaceTristan> sequence;
	private TextLabel label;
	private static ButtonInterfaceTristan[] buttons;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private static int lastSelectedButton;
	
	
	public SimonScreenTristan(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceTristan b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceTristan>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	public MoveInterfaceTristan randomMove() {
		int selectedButton = (int)(Math.random()*buttons.length);
		while(selectedButton == lastSelectedButton) {
			selectedButton = (int)(Math.random()*buttons.length);
		}
		lastSelectedButton = selectedButton;
		return getMove(selectedButton);
	}
	
	private MoveInterfaceTristan getMove(int selectedButton) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceTristan getProgress() { 
	    // TODO Auto-generated method stub 
	    return null; 
	}

	public void addButtons() {
		int numberOfButtons = 6;
		buttons = new ButtonInterfaceTristan[numberOfButtons];
		Color[] colors = new Color[numberOfButtons];
		colors[0] = Color.blue;
		colors[1] = Color.red;
		colors[2] = Color.green;
		colors[3] = Color.yellow;
		colors[4] = Color.orange;
		colors[5] = Color.pink;
		int x = 100;
		int y = 200;
		for(int j = 0; j < buttons.length; j++) {
			final ButtonInterfaceTristan b = getButton();
			b.setColor(colors[j]);
			b.setX(x);
			b.setY(y);
			b.setAction(new Action(){
				
				public void act(){
					if(acceptingInput) {
						Thread blink = new Thread(new Runnable(){
							public void run(){
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
						if(b == sequence.get(sequenceIndex).getButton()) {
							sequenceIndex++;
							if(sequenceIndex == sequence.size()){ 
							    Thread nextRound = new Thread(SimonScreenTristan.this); 
							    nextRound.start(); 
							}
						}
						else {
							gameOver();
						}
					}
				}
				
			});
			buttons[j] = b;
			y += 100;
		}
	}

	private ButtonInterfaceTristan getButton() {
		// TODO Auto-generated method stub
		return new ButtonKevin(0, 0, 100, 50, "", null);
	}

	@Override
	public void run() {
		label.setText("");
	    nextRound();
	}

	private void nextRound() {
		acceptingInput = false;
		roundNumber++;
		sequence.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn");
		playSequence();
		changeText("Your turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}
	
	public void changeText(String text) {
		Thread changer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				label.setText(text);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				label.setText("");
			}
		});
		changer.start();
	}
	
	public void playSequence() {
		ButtonInterfaceTristan b = null;
		for(int i = 0; i < sequence.size(); i++) {
			if(b != null) {
				b.dim();
			}
			b = sequence.get(i).getButton();
			b.highlight();
			int sleepTime = (int) Math.log(Math.pow(2, roundNumber)) + 3;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		b.dim();
	}  

}