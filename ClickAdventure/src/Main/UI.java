package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
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
	public JMenuItem menuItem[] = new JMenuItem[4];
	public JMenuItem menuItem1[] = new JMenuItem[4];
	private JButton viewChangeButton;

	//PLAYER UI
	JPanel lifePanel;
	JLabel lifeLabel[] = new JLabel[6];
	JPanel inventoryPanel;
	public JLabel weaponLabel;

	//GAME OVER UI
	public JLabel titleLabel;
	JButton restartButton;

	//START MENU UI
	public JLabel startLabel;
	JButton startButton;
	JButton quitButton;

	public UI(GameManager gm) {

		this.gm = gm;

		createMainField();
		createPlayerField();
		createGameOverField();
		createStartMenu();
		generateScreen();

		window.setVisible(true);
	}

	public void createMainField() {

		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);

		messageText = new JTextArea("");
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
		bgPanel[bgNum].setBackground(Color.black);
		bgPanel[bgNum].setVisible(false);
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
//		objectLabel.setOpaque(true);
//		objectLabel.setBackground(Color.blue);

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

	public void createDaggerObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName,
			String choice1Name, String choice1Command) {
//		String choice2Name, String choice3Name, String choice2Command, String choice3Command) {

			//CREATE POP MENU
			JPopupMenu popMenu = new JPopupMenu();
			//CREATE POP MENU ITEMS
			menuItem[1] = new JMenuItem(choice1Name);
			menuItem[1].addActionListener(gm.aHandler);
			menuItem[1].setActionCommand(choice1Command);
			popMenu.add(menuItem[1]);

//			menuItem1[2] = new JMenuItem(choice2Name);
//			menuItem1[2].addActionListener(gm.aHandler);
//			menuItem1[2].setActionCommand(choice2Command);
//			popMenu.add(menuItem1[2]);
//
//			menuItem1[3] = new JMenuItem(choice3Name);
//			menuItem1[3].addActionListener(gm.aHandler);
//			menuItem1[3].setActionCommand(choice3Command);
//			popMenu.add(menuItem1[3]);

			//CREATE OBJECT
			JLabel objectLabel = new JLabel();
			objectLabel.setBounds(objx,objy,objWidth,objHeight);
			//Check bounds of objects
//			objectLabel.setOpaque(true);
//			objectLabel.setBackground(Color.blue);

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
	
	public void createEnemyObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String objFileName,
			String choice1Name,  String choice1Command ) {
//		 String choice2Name, String choice3Name, String choice2Command, String choice3Command) {

			//CREATE POP MENU
			JPopupMenu popMenu = new JPopupMenu();
			//CREATE POP MENU ITEMS
			menuItem[1] = new JMenuItem(choice1Name);
			menuItem[1].addActionListener(gm.aHandler);
			menuItem[1].setActionCommand(choice1Command);
			popMenu.add(menuItem[1]);

//			menuItem1[2] = new JMenuItem(choice2Name);
//			menuItem1[2].addActionListener(gm.aHandler);
//			menuItem1[2].setActionCommand(choice2Command);
//			popMenu.add(menuItem1[2]);
//
//			menuItem1[3] = new JMenuItem(choice3Name);
//			menuItem1[3].addActionListener(gm.aHandler);
//			menuItem1[3].setActionCommand(choice3Command);
//			popMenu.add(menuItem1[3]);

			//CREATE OBJECT
			JLabel enemyLabel = new JLabel();
			enemyLabel.setBounds(objx,objy,objWidth,objHeight);
			//Check bounds of objects
//			objectLabel.setOpaque(true);
//			objectLabel.setBackground(Color.blue);

			ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
			enemyLabel.setIcon(objectIcon);

			enemyLabel.addMouseListener(new MouseListener() {


				public void mouseClicked(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {}
				public void mouseExited(MouseEvent e) {}
				public void mousePressed(MouseEvent e) {

					if(SwingUtilities.isRightMouseButton(e)) {
						popMenu.show(enemyLabel, e.getX(), e.getY());
					}
				}

				public void mouseReleased(MouseEvent e) {}
			});

			bgPanel[bgNum].add(enemyLabel);
		}

		public void createViewChangeButton(int bgNum, int x, int y, int width, int height, String buttonFileName, String command) {
			ImageIcon viewChangeIcon = new ImageIcon(getClass().getClassLoader().getResource(buttonFileName));

			viewChangeButton = new JButton();
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

		public void updateViewChangeButtonActionCommand(int bgNum, String actionCommand) {
			if (bgNum >= 0 && bgNum < bgPanel.length) {
				for (Component component : bgPanel[bgNum].getComponents()) {
					if (component instanceof JButton) {
						JButton button = (JButton) component;
						if (button.getActionCommand().equals("goScene3")) {
							button.setActionCommand(actionCommand);
						}
					}
				}
			}
		}
		
		public void resetViewChangeButtonActionCommand(int bgNum, String actionCommand) {
			if (bgNum >= 0 && bgNum < bgPanel.length) {
				for (Component component : bgPanel[bgNum].getComponents()) {
					if (component instanceof JButton) {
						JButton button = (JButton) component;
						if (button.getActionCommand().equals("goScene4")) {
							button.setActionCommand(actionCommand);
						}
					}
				}
			}
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

		public void createPlayerField() {

			lifePanel = new JPanel();
			lifePanel.setBounds(50, 20, 220, 40);
			lifePanel.setBackground(null);
			lifePanel.setLayout(new GridLayout(1,5));
			window.add(lifePanel);

			ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("Heart.png"));
			Image image = lifeIcon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
			lifeIcon = new ImageIcon(image);

			int i=1;
			while(i<6) {
				lifeLabel[i] = new JLabel();
				lifeLabel[i].setIcon(lifeIcon);
				lifePanel.add(lifeLabel[i]);
				i++;
			}

			inventoryPanel = new JPanel();
			inventoryPanel.setBounds(30, 85, 50, 100);
			inventoryPanel.setBackground(null);
			inventoryPanel.setLayout(new GridLayout(2,1));
			window.add(inventoryPanel);

			//CREATE ITEMS
			weaponLabel = new JLabel();
			ImageIcon weaponIcon = new ImageIcon(getClass().getClassLoader().getResource("DaggerIcon.png"));
			image = weaponIcon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			weaponIcon = new ImageIcon(image);
			weaponLabel.setIcon(weaponIcon);
			inventoryPanel.add(weaponLabel);
		}

		public void createGameOverField() {

			titleLabel = new JLabel("", JLabel.CENTER);
			titleLabel.setBounds(200, 150, 400, 200);
			titleLabel.setForeground(Color.red);
			titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 70));
			titleLabel.setVisible(false);
			window.add(titleLabel);

			restartButton = new JButton();
			restartButton.setBounds(340, 300, 120, 50);
			restartButton.setBorder(null);
			restartButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			restartButton.setBackground(null);
			restartButton.setForeground(Color.white);
			restartButton.setFocusPainted(false);
			restartButton.addActionListener(gm.aHandler);
			restartButton.setActionCommand("restart");
			restartButton.setVisible(false);
			window.add(restartButton);
		}
		
		public void createEndScreen() {
			
			titleLabel = new JLabel("", JLabel.CENTER);
			titleLabel.setBounds(200, 150, 400, 200);
			titleLabel.setForeground(Color.white);
			titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 70));
			titleLabel.setVisible(false);
			window.add(titleLabel);
		}

		public void createStartMenu() {
			// Start Label
			startLabel = new JLabel("", JLabel.CENTER);
			startLabel.setBounds(200, 100, 400, 100);
			startLabel.setVisible(false);
			startLabel.setForeground(Color.white);
			startLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
			window.add(startLabel);

			// Start Button
			startButton = new JButton("Start");
			startButton.setBounds(340, 230, 120, 40);
			startButton.setVisible(false);
			startButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
			startButton.setBackground(Color.black);
			startButton.setForeground(Color.white);
			startButton.setFocusPainted(false);
			startButton.addActionListener(gm.aHandler);
			startButton.setActionCommand("start");
			window.add(startButton);

			// Quit Game Button
			quitButton = new JButton("Quit Game");
			quitButton.setBounds(310, 280, 180, 40);
			quitButton.setVisible(false);
			quitButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
			quitButton.setBackground(null);
			quitButton.setForeground(Color.white);
			quitButton.setFocusPainted(false);
			quitButton.addActionListener(gm.aHandler);
			quitButton.setActionCommand("quit");
			window.add(quitButton);
		}

		public void generateScreen() {

			//START MENU
			createStartMenu();
			//SCENE 1
			createBackground(1,"Hall1.png");
			createObject(1,0,0,100,100,"", "Choice1", "Choice2", "Choice3", "Response1", "Repsonse2", "Response3");
			createArrowButton(1,140,190,100,100,"LeftArrow-Hall1.png","goScene2",70);
			createArrowButton(1,370,146,50,39,"LeftArrow-Hall1.png","goScene5",39);
			createArrowButton(1,484,110,42,31,"ForwardArrow-Hall1.png","goScene6",37);
			bgPanel[1].add(bgLabel[1]);

			//SCENE 2
			createBackground(2,"Room1-View1.png");
			createArrowButton(2,310,300,50,39,"BackArrow-Room1.png","goScene1",50);
			createViewChangeButton(2,600,20,50,50,"SwitchViewArrow.png","goScene3");
			bgPanel[2].add(bgLabel[2]);

			//SCENE 3
			createBackground(3,"Room1-View2.png");
			createObject(3,510,200,15,100,"","Look","Examine","Nothing","lookCorner","examineCorner","nothingCorner");
			createObject(3,335,130,160,180,"","Look","Examine","Punch","lookBookcase","examineBookcase","pushOrPunchBookcase");
			createViewChangeButton(3,600,20,50,50,"SwitchViewArrow.png","goScene2");
			bgPanel[3].add(bgLabel[3]);

			//SCENE 4
			createBackground(4,"HiddenSpace.png");
			createDaggerObject(4, 442, 258, 61, 20, "Dagger.png","Take","takeDagger");
//			"Look", "Examine","lookDagger", "examineDagger", );
			createViewChangeButton(4,600,20,50,50,"SwitchViewArrow.png","goScene2");
			bgPanel[4].add(bgLabel[4]);
			
			//SCENE 5
			createBackground(5,"Room2.png");
			createArrowButton(5,320,300,50,39,"BackArrow-Room2.png","goScene1",50);
			bgPanel[5].add(bgLabel[5]);
			
			//SCENE 6 - "FINAL SCENE"
			createBackground(6,"ChainsRoom.png");
			createArrowButton(6,320,300,50,39,"BackArrow-Room2.png","goScene1",50);
			createArrowButton(6,320,200,70,37,"ForwardArrow_FinalRoom.png","end",70);
			createEnemyObject(6,185,50,290,260,"ChainedSoul.png","Attack","attackMonster");
			bgPanel[6].add(bgLabel[6]);
		}

	}