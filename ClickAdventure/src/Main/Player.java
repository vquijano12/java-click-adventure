package Main;

public class Player {

	GameManager gm;

	//PLAYER STATUS
	public int playerMaxLife;
	public int playerLife;
	public int playerStrength;
	public int playerEndurance;
	public int playerAttack;
	public int playerDefense;

	public boolean hasWeapon;
	public int weaponPower;
	public boolean defeatChainedSoul = false;

	public Player(GameManager gm) {

		this.gm = gm;
	}

	public void setPlayerDefaultStatus() {

		playerMaxLife = 5;
		playerLife = 5;
		playerStrength = 100;
		playerEndurance = 1;
		hasWeapon = false;
		weaponPower = 2;

		defeatChainedSoul = false;
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
		playerAttack = playerStrength + weaponPower;
		playerDefense = playerEndurance;

		//CHECK PLAYER ITEMS
		if(hasWeapon == false) {
			gm.ui.weaponLabel.setVisible(false);
		}
		if(hasWeapon == true) {
			gm.ui.weaponLabel.setVisible(true);
		}
	}

}
