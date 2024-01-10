package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

	private GameManager gm;

	public ActionHandler(GameManager gm) {
		this.gm = gm;
	}

	public void actionPerformed(ActionEvent e) {
		String yourChoice = e.getActionCommand();

		handleObjectActions(yourChoice);
		handleSceneChanges(yourChoice);
	}

	private void handleObjectActions(String choice) {
		switch (choice) {
		case "lookBookcase":
			gm.ev1.lookBookcase();
			break;
		case "examineBookcase":
			gm.ev1.examineBookcase();
			break;
		case "punchBookcase":
			gm.ev1.pushOrPunchBookcase();
			break;
		case "lookCorner":
			gm.ev1.lookCorner();
			break;
		case "examineCorner":
			gm.ev1.examineCorner();
			break;
		case "nothingCorner":
			gm.ev1.nothingCorner();
			break;
			// Add more cases as needed
		}
	}

	private void handleSceneChanges(String choice) {
		switch (choice) {
		case "goScene1":
			gm.sChanger.showScene1();
			break;
		case "goScene2":
			gm.sChanger.showScene2();
			break;
		case "goScene3":
			gm.sChanger.showScene3();
			break;
		case "goScene4":
			gm.sChanger.showScene4();
			break;
		case "restart":
			gm.sChanger.exitGameOverScreen();
			gm.sChanger.showScene1(); 
			break;
		case "start":
			gm.sChanger.hideStartMenu();
			gm.sChanger.showScene1();
			break;
		case "quit":
			System.exit(0);
			break;
			// Add more cases as needed
		}
	}		
}
