package myStuff;

import guiTeacher.components.Graphic;

public class MoveKevin implements MoveInterfaceTristan {
	
	private ButtonInterfaceTristan button;
	
	public MoveKevin(ButtonInterfaceTristan bIndex) {
		button = bIndex;
	}

	@Override
	public ButtonInterfaceTristan getButton() {
		return button;
	}
	
}