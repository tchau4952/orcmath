package someStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import guiPlayer.CustomLabel;
import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button implements CustomLabel {

	public CustomButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
	}

	@Override
	public void updateString1(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateString2(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIconColor(Color color) {
		// TODO Auto-generated method stub
		
	}

	public void drawButton(Graphics2D g, boolean hover){
			g.setColor(Color.black);
			
			g.drawString("String1" , 200, 150);
			g.drawString("String2" , 200, 250);
		}

}
