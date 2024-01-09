package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

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
		messageText.setBounds(50,405,700,150);
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
		window.add(bgPanel[bgNum]);

		bgLabel[bgNum] = new JLabel();
		bgLabel[bgNum].setBounds(0,0,700,350);

		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
		bgLabel[bgNum].setIcon(bgIcon);


	}

	public void createObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName,
			String choice1Name, String choice2Name, String choice3Name, String choice1Command, String choice2Command, String choice3Command) {

		//CREATE POP MENU
		JPopupMenu popMenu = new JPopupMenu();
		//CREATE POP MENU ITEMS
		JMenuItem menuItem[] = new JMenuItem[4];
		menuItem[1] = new JMenuItem(choice1Name);
		menuItem[1].addActionListener(gm.aHandler);
		menuItem[1].setActionCommand(choice1Command);
		popMenu.add(menuItem[1]);

		menuItem[2] = new JMenuItem(choice2Name);
		menuItem[2].addActionListener(gm.aHandler);
		menuItem[2].setActionCommand(choice2Command);
		popMenu.add(menuItem[2]);

		menuItem[3] = new JMenuItem(choice3Name);
		menuItem[3].addActionListener(gm.aHandler);
		menuItem[3].setActionCommand(choice3Command);
		popMenu.add(menuItem[3]);

		//CREATE OBJECTS
		JLabel objectLabel = new JLabel();
		objectLabel.setBounds(objx,objy,objWidth,objHeight);
		//Check bounds of objects
		objectLabel.setOpaque(true);
		objectLabel.setBackground(Color.blue);

		ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
		objectLabel.setIcon(objectIcon);

		objectLabel.addMouseListener(new MouseListener() {


			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {

				if(SwingUtilities.isRightMouseButton(e)) {
					popMenu.show(objectLabel, e.getX(), e.getY());
				}
			}


			public void mouseReleased(MouseEvent e) {}
		});

		bgPanel[bgNum].add(objectLabel);

	}

	public void createViewChangeButton(int bgNum, int x, int y, int width, int height, String buttonFileName, String command) {
		ImageIcon viewChangeIcon = new ImageIcon(getClass().getClassLoader().getResource(buttonFileName));

		JButton viewChangeButton = new JButton();
		viewChangeButton.setBounds(x, y, width, height);
		viewChangeButton.setBackground(null);
		viewChangeButton.setContentAreaFilled(false);
		viewChangeButton.setFocusPainted(false);
		viewChangeButton.setIcon(viewChangeIcon);
		viewChangeButton.addActionListener(gm.aHandler);
		viewChangeButton.setActionCommand(command);
		viewChangeButton.setBorderPainted(false);
		bgPanel[bgNum].add(viewChangeButton);
	}
	
	public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName, String command, int newWidth) {
	    ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));

	    Image originalImage = arrowIcon.getImage();
	    
	    int newHeight = (int) (((double) originalImage.getHeight(null) / originalImage.getWidth(null)) * newWidth);

	    Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

	    JButton arrowButton = new JButton();
	    arrowButton.setBounds(x, y, width, height);
	    arrowButton.setBackground(null);
	    arrowButton.setContentAreaFilled(false);
	    arrowButton.setFocusPainted(false);

	    // Set the initial icon to the scaled image
	    arrowButton.setIcon(new ImageIcon(scaledImage));

	    arrowButton.addActionListener(gm.aHandler);
	    arrowButton.setActionCommand(command);
	    arrowButton.setBorderPainted(false);
	    
	    arrowButton.setIcon(null);

	    arrowButton.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseEntered(MouseEvent e) {
	            // Set the icon to make the button visible
	            arrowButton.setIcon(new ImageIcon(scaledImage));
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            arrowButton.setIcon(null);
	        }
	    });

	    bgPanel[bgNum].add(arrowButton);
	}

//	public void createArrowButton(int bgNum, int x, int y, int width, int height, String arrowFileName, String command, 
//			int newWidth, int newHeight) {
//
//		ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));
//
//		Image originalImage = arrowIcon.getImage();
//
//		Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight,  Image.SCALE_SMOOTH);
//
//		JButton arrowButton = new JButton();
//		arrowButton.setBounds(x, y, width, height);
//		arrowButton.setBackground(null);
//		arrowButton.setContentAreaFilled(false);
//		arrowButton.setFocusPainted(false);
//		arrowButton.setIcon(new ImageIcon(scaledImage));
//		arrowButton.addActionListener(gm.aHandler);
//		arrowButton.setActionCommand(command);
//		arrowButton.setBorderPainted(false);
//
//		// Initially, set the button icon to null (invisible)
//		arrowButton.setIcon(null);
//
//		arrowButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// Set the icon to make the button visible
//				arrowButton.setIcon(arrowIcon);
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// Set the icon to null to make the button invisible
//				arrowButton.setIcon(null);
//			}
//		});
//
//		bgPanel[bgNum].add(arrowButton);
//	}


	public void generateScreen() {

		//SCENE 1
		createBackground(1,"Hall1.png");
//		createObject(1,0,0,50,39,"", "Choice1", "Choice2", "Choice3", "Response1", "Repsonse2", "Response3");
		createArrowButton(1,140,190,100,100,"LeftArrow-Hall1.png","goScene2",70);
		createArrowButton(1,370,146,50,39,"LeftArrow-Hall1.png","",39);
		bgPanel[1].add(bgLabel[1]);

		//SCENE 2
		createBackground(2,"Room1-View1.png");
		createArrowButton(2,310,300,50,39,"BackArrow-Room1.png","goScene1",50);
		createViewChangeButton(2,600,20,50,50,"SwitchViewArrow.png","goScene3");
		bgPanel[2].add(bgLabel[2]);

		//SCENE 3
		createBackground(3,"Room1-View2.png");
		createObject(3,510,200,15,100,"","Look","Examine","Nothing","lookCorner","examineCorner","nothingCorner");
		createObject(3,335,130,160,180,"","Look","Examine","Punch","lookBookcase","examineBookcase","punchBookcase");
		createViewChangeButton(3,600,20,50,50,"SwitchViewArrow.png","goScene2");
		bgPanel[3].add(bgLabel[3]);
	}

}