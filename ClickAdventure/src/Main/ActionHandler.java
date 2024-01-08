package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{

	GameManager gm;

	public ActionHandler(GameManager gm) {

		this.gm = gm;
	}

	public void actionPerformed(ActionEvent e) {

		String yourChoice = e.getActionCommand();

		switch(yourChoice) {
		case "lookBookcase": gm.ev1.lookBookcase(); break;
		case "examineBookcase": gm.ev1.examineBookcase(); break;
		case "punchBookcase": gm.ev1.punchBookcase(); break;
		//CHANGE SCENES
		case "goScene1": gm.sChanger.showScene1(); break;
		case "goScene2": gm.sChanger.showScene2(); break;
		case "goScene3": gm.sChanger.showScene3(); break;
		}
	}

}
