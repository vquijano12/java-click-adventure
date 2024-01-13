package Main;

import java.util.Random;

import Enemy.Enemy;
import Enemy.Entity01;

public class BattleManager {

	GameManager gm;
	Enemy entity;
	Entity01 chainedSoul = new Entity01();
	Random randomDie = new Random();

	public BattleManager(GameManager gm) {

		this.gm = gm;
	}

	public void resetEnemyLife() {

		chainedSoul.entityLife = chainedSoul.entityMaxLife;
	}

	public void setEnemy() {
		entity = chainedSoul;
		attack();
	}

	public void attack() {

		int playerDamage = randomDie.nextInt(gm.player.playerAttack) - entity.entityDefense;
		if(playerDamage < 0) {
			playerDamage = 0;
		}
		gm.ui.messageText.setText("");
		gm.ui.messageText.append("You attack the " + entity.entityName + " and deal " + playerDamage + " damage!");
		entity.entityLife -= playerDamage;
		if(entity.entityLife < 1) {
			win();
		} else {
			int entityDamage = randomDie.nextInt(entity.entityAttack) - gm.player.playerDefense;
			if(entityDamage < 0) {
				entityDamage = 0;
			}
			gm.player.playerLife -= entityDamage;
			gm.ui.messageText.append("\nThe " + entity.entityName + " attacks you and deals " + entityDamage + " damage!");
			if(gm.player.playerLife < 1) {
				gm.player.playerLife = 0;
				gm.player.updatePlayerStatus();
				lose();
			} else {
				gm.player.updatePlayerStatus();
			}
		}
	}

	public void win() {

		gm.ui.messageText.setText("You have defeated the enemy!");
		gm.ui.menuItem[1].setText("Vanquish");

		if(entity == chainedSoul) {
			gm.player.defeatChainedSoul = true;
		} else {

		}
	}

	public void lose() {

		gm.ui.messageText.setText("You never had a chance...");
		gm.sChanger.showGameOverScreen(6);
	}



}
