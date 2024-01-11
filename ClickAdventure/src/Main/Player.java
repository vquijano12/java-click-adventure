package Main;

public class Player {

	GameManager gm;

	//Variables for player life
	public int playerMaxLife;
	public int playerLife;
	//Variables for items
	public boolean hasWeapon;

	public Player(GameManager gm) {

		this.gm = gm;
	}

	public void setPlayerDefaultStatus() {

		playerMaxLife = 5;
		playerLife = 5;
		hasWeapon = false;

		updatePlayerStatus();
	}

	public void updatePlayerStatus() {

		// REMOVE ALL LIFE ICON
		int i = 1;
		while(i < 6) {
			gm.ui.lifeLabel[i].setVisible(false);
			i++;
		}

		int lifeCount = playerLife;
		while(lifeCount != 0) {
			gm.ui.lifeLabel[lifeCount].setVisible(true);
			lifeCount--;
		}

		//CHECK PLAYER ITEMS
		if(hasWeapon == false) {
			gm.ui.weaponLabel.setVisible(false);
		}
		if(hasWeapon == true) {
			gm.ui.weaponLabel.setVisible(true);
		}
	}

}
