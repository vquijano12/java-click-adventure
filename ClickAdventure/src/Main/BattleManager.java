package Main;

import java.util.Random;

import Monster.Abomination;
import Monster.Monster;

public class BattleManager {
	
	GameManager gm;
	Monster monster;
	Abomination abomination = new Abomination();
	Random randomDie = new Random();
	
	public BattleManager(GameManager gm) {
		
		this.gm = gm;
	}
	
	public void resetMonsterLife() {
		
		abomination.monsterLife = abomination.monsterMaxLife;
	}
	
	public void setMonster() {
		monster = abomination;
		attack();
	}
	
	public void attack() {
		
		int playerDamage = randomDie.nextInt(gm.player.playerAttack) - monster.monsterDefense;
		if(playerDamage < 0) {
			playerDamage = 0;
		}
		gm.ui.messageText.setText("");
		gm.ui.messageText.append("You attack the " + monster.monsterName + " and deal " + playerDamage + " damage!");
		monster.monsterLife -= playerDamage;
		if(monster.monsterLife < 1) {
			win();
		} else {
			int monsterDamage = randomDie.nextInt(monster.monsterAttack) - gm.player.playerDefense;
			if(monsterDamage < 0) {
				monsterDamage = 0;
			}
			gm.player.playerLife -= monsterDamage;
			gm.ui.messageText.append("\nThe" + monster.monsterName + " attacks you and deals " + monsterDamage + " damage!");
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
		
		gm.ui.messageText.append("\nYou have defeated the monster!");
		
		if(monster == abomination) {
			gm.player.defeatAbomination = true;
		} else {
			
		}
	}
	
	public void lose() { 
		
		gm.ui.messageText.setText("You never had a chance...");
		gm.sChanger.showGameOverScreen(6);
	}
	
	

}
