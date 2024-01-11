package Event;

import Main.GameManager;

public class Event02 {
	GameManager gm;

	public Event02(GameManager gm) {
		this.gm = gm;
	}

//	public void lookDagger() {
//		gm.ui.messageText.setText("");
//	}

//	public void examineDagger() {
//		gm.ui.messageText.setText("");
//	}

	public void takeDagger() {
		gm.ui.messageText.setText("You took the dagger.");
		gm.ui.weaponLabel.setVisible(true);

		hideDaggerObject();
	}

	private void hideDaggerObject() {
		gm.ui.bgPanel[4].getComponent(0).setVisible(false);
	}
}
