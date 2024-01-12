package Event;

import Main.GameManager;

public class Event03 {
	
	GameManager gm;
	
	public Event03(GameManager gm) {
		
		this.gm = gm;
	}
	
	public void attackMonster() {
	    if (!gm.player.hasWeapon) {
	        gm.ui.messageText.setText("You can't challenge the monster without a weapon!");
	    } else if (gm.player.defeatAbomination) {
	        hideMonsterObject();
	    } else {
	        gm.bm.setMonster();
	    }
	}
	
	private void hideMonsterObject() {
		gm.ui.bgPanel[6].getComponent(0).setVisible(false);
	}

}
