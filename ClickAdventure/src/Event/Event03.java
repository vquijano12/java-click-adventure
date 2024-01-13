package Event;

import Main.GameManager;

public class Event03 {
	
	GameManager gm;
	
	public Event03(GameManager gm) {
		
		this.gm = gm;
	}
	
	public void attackEnemy() {
	    if (!gm.player.hasWeapon) {
	        gm.ui.messageText.setText("You can't challenge the enemy without a weapon!");
	    } else if (gm.player.defeatChainedSoul) {
	        hideEnemyObject();
	        gm.ui.messageText.setText("The enemy has been vanquished!");
	        gm.ui.bgPanel[6].getComponent(1).setVisible(true);
	    } else {
	        gm.bm.setEnemy();
	        gm.ui.bgPanel[6].getComponent(0).setVisible(false);
	    }
	}
	
	private void hideEnemyObject() {
		gm.ui.bgPanel[6].getComponent(2).setVisible(false);
	}

}
