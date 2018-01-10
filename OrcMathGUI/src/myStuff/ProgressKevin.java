package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Component;

public class ProgressKevin extends Component implements ProgressInterfaceTristan {
	
	private int roundNumber;
	private int sequenceSize;
	private boolean progressState;

	public ProgressKevin(int x, int y, int w, int h) {
		super(x, y, w, h);
		progressState = true;
		update();
	}

	@Override
	public void gameOver() {
		progressState = false;
		update();
	}

	@Override
	public void setRound(int n) {
		roundNumber = n;
		update();
	}

	@Override
	public void setSequenceSize(int n) {
		sequenceSize = n;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		clear();
		if(progressState) {
			g.setColor(Color.black);
			g.drawString("This is Round: " + this.roundNumber, 400, 40);
			g.drawString("The Sequence Size is: " + this.sequenceSize, 400, 80);
		}else {
			g.setColor(Color.black);
			g.drawString("Game Over", 400, 40);
			g.drawString("This is Round: " + this.roundNumber, 400, 80);
			g.drawString("The Sequence Size is: " + this.sequenceSize, 400, 120);
		}
	}

}