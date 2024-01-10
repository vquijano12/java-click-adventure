package Main;

public class SceneChanger {

	GameManager gm;

	public SceneChanger(GameManager gm) {

		this.gm = gm;
	}
	
	public void showStartMenu() {
        // Show the start menu components
        gm.ui.startLabel.setVisible(true);
        gm.ui.startButton.setVisible(true);
        gm.ui.quitButton.setVisible(true);

        // Hide other components
        gm.ui.bgPanel[1].setVisible(false);
        gm.ui.bgPanel[2].setVisible(false);
        gm.ui.bgPanel[3].setVisible(false);
        gm.ui.bgPanel[4].setVisible(false);
        gm.ui.titleLabel.setVisible(false);
        gm.ui.restartButton.setVisible(false);
    }
	
	public void hideStartMenu() {
        // Hide the start menu components
		gm.ui.startLabel.setVisible(false);
		gm.ui.startButton.setVisible(false);
		gm.ui.quitButton.setVisible(false);
    }
	
	public void showScene1() { 

		gm.ui.bgPanel[1].setVisible(true);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
		gm.ui.messageText.setText("");
	}

	public void showScene2() { 

		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(true);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(false);
	}

	public void showScene3() { 

		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(true);
		gm.ui.bgPanel[4].setVisible(false);
	}

	public void showScene4() { 

		gm.ui.bgPanel[1].setVisible(false);
		gm.ui.bgPanel[2].setVisible(false);
		gm.ui.bgPanel[3].setVisible(false);
		gm.ui.bgPanel[4].setVisible(true);
	}
	
	public void showGameOverScreen(int currentBgNum) {
		
		gm.ui.bgPanel[currentBgNum].setVisible(false);
		gm.ui.titleLabel.setVisible(true);
		gm.ui.titleLabel.setText("YOU DIED...");
		gm.ui.restartButton.setVisible(true);
		gm.ui.restartButton.setText("Click to restart");
	}
	
	public void exitGameOverScreen() {
		
		gm.ui.titleLabel.setVisible(false);
		gm.ui.restartButton.setVisible(false);
		gm.player.setPlayerDefaultStatus();
	}
}
