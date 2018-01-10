package myStuff;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.Utilities;
import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonKevin extends Button implements ButtonInterfaceTristan{
	
	private Color color;

	public ButtonKevin(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		update();
	}

	public ButtonKevin(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		update();
	}

	@Override
	public void setColor(Color color) {
		this.setBackground(color);
		this.color = color;
		update();
	}

	@Override
	public void highlight() {
		this.setBackground(Color.white);
		update();
	}

	@Override
	public void dim() {
		this.setBackground(this.color);
		update();
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		drawShape(g, hover);
		g.setBackground(color);
	}

}