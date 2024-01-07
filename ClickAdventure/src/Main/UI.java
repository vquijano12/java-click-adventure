package Main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UI {

	GameManager gm;

	JFrame window;
	public JTextArea messageText;
	public JPanel bgPanel[] = new JPanel[10];
	public JLabel bgLabel[] = new JLabel[10];

	public UI(GameManager gm) {

		this.gm = gm;

		createMainField();

		generateScreen();

		window.setVisible(true);
	}

	public void createMainField() {

		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);

		messageText = new JTextArea("THIS IS SAMPLE TEXT");
		messageText.setBounds(50,400,700,150);
		messageText.setBackground(Color.black);
		messageText.setForeground(Color.white);
		messageText.setEditable(false);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
		window.add(messageText);
	}

	public void createBackground(int bgNum, String bgFileName) {

		bgPanel[bgNum] = new JPanel();
		bgPanel[bgNum].setBounds(50,50,700,350);
		bgPanel[bgNum].setBackground(Color.blue);
		bgPanel[bgNum].setLayout(null);
		window.add(bgPanel[1]);

		bgLabel[bgNum] = new JLabel();
		bgLabel[bgNum].setBounds(0,0,700,350);

		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
		bgLabel[bgNum].setIcon(bgIcon);


	}

	public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName) {

		JLabel objectLabel = new JLabel();
		objectLabel.setBounds(objx,objy,objWidth,objHeight);

		ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
		objectLabel.setIcon(objectIcon);

		bgPanel[bgNum].add(objectLabel);
		bgPanel[bgNum].add(bgLabel[bgNum]);
	}

	public void generateScreen() {

		//SCREEN 1
		createBackground(1,"Hall1.png");
		createObject(1,0,0,700,350,"LeftArrow_Hall1.png");
	}

}