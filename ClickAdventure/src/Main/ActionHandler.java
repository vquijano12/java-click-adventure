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
		case "Placeholder1": gm.ev1.Placeholder1(); break;
		case "Placeholder2": gm.ev1.Placeholder2(); break;
		case "Placeholder3": gm.ev1.Placeholder3(); break;
		}
	}

}
