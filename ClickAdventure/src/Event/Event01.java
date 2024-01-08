package Event;

import Main.GameManager;

public class Event01 {
	
	GameManager gm;
	
	public Event01(GameManager gm) {
		
		this.gm = gm;
	}
	
	public void Placeholder1() {
		gm.ui.messageText.setText("Placeholder text1");
	}
	
	public void Placeholder2() {
		gm.ui.messageText.setText("Placeholder text2");
	}
	
	public void Placeholder3() {
		gm.ui.messageText.setText("Placeholder text3");
	}

}
