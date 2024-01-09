package Event;

import Main.GameManager;

public class Event01 {
	
	GameManager gm;
	
	public Event01(GameManager gm) {
		
		this.gm = gm;
	}
	
	public void lookCorner() {
		gm.ui.messageText.setText("Hmmm...");
	}
	
	public void examineCorner() {
		gm.ui.messageText.setText("What's that? It looks like something hidden behind the bookcase.");
	}
	
	public void nothingCorner() {
		gm.ui.messageText.setText(".....");
	}
	
	public void lookBookcase() {
		gm.ui.messageText.setText("Nice lookin' bookcase, I guess.");
	}
	
	public void examineBookcase() {
		gm.ui.messageText.setText("Something feels a little off about this...");
	}
	
	public void punchBookcase() {
		gm.ui.messageText.setText("OUCH!! That's one tough bookcase, better be careful.");
	}

}
