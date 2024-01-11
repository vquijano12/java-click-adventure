package Event;

import Main.GameManager;

public class Event02 {
	GameManager gm;

	public Event02(GameManager gm) {
		this.gm = gm;
	}

	public void lookDagger() {
		gm.ui.messageText.setText("");
	}

	public void examineDagger() {
		gm.ui.messageText.setText("");
	}

	public void takeDagger() {
		gm.ui.messageText.setText("You took the dagger.");
		gm.ui.weaponLabel.setVisible(true);

		hideDaggerObject();
	}

	private void hideDaggerObject() {
		// Assuming the dagger object is added to the UI as a JLabel
		// Update the index and the visibility accordingly
		gm.ui.bgPanel[4].getComponent(0).setVisible(false); // Assuming the dagger is the first component in bgPanel[4]
	}
}
