package Event;

import Main.GameManager;

public class Event03 {
	
	GameManager gm;
	
	public Event03(GameManager gm) {
		
		this.gm = gm;
	}
	
	public void attackEnemy() {
	    if (!gm.player.hasWeapon) {
	        gm.ui.messageText.setText("You can't challenge the monster without a weapon!");
	    } else if (gm.player.defeatChainedSoul) {
	        hideEntityObject();
	    } else {
	        gm.bm.setEntity();
	        gm.ui.bgPanel[6].getComponent(0).setVisible(false);
	    }
	}
	
	private void hideEntityObject() {
		gm.ui.bgPanel[6].getComponent(1).setVisible(false);
	}

}
