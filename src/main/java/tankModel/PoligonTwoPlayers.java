package tankModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BattleCity.EkranGlowny;
import BattleCity.EkranGry1Gracz;
import BattleCity.EkranNowaGra;
import mapEditor.newBorder;

public class PoligonTwoPlayers extends JPanel {
	
	
	public String muzykaOnOff;
	public Font font = new Font("Visitor TT1 BRK", Font.BOLD, 28);
	
	public String grayTank = "src/main/resources/images/gray_tank_icon.png";
	public String blueTank = "src/main/resources/images/blue_tank_icon.png";
	public String redTank = "src/main/resources/images/red_tank_icon.png";
	public String hBorder = "src/main/resources/images/protection_border_icon_800px_25px.png";
	public String vBorder = "src/main/resources/images/protection_border_icon_25px_800px.png";
	public String vBorderShort = "src/main/resources/images/protection_border_icon_25px_50px.png";
	public String filePath;
	
	
	public PoligonTwoPlayers(String filePath) throws IOException {
		setLayout(null);
		setFocusable(true);
		setBackground(Color.DARK_GRAY);
		
		JPanel playerOnePanel = new JPanel();
		JLabel scorePlayerOne = new JLabel();
		scorePlayerOne.setBounds(0, 0, 130, 50);
		scorePlayerOne.setText("   PLAYER 1   ");
		
		JLabel lifeOnePlayerOne = new JLabel(new ImageIcon("src/main/resources/images/tank_life_icon_red_15x15.png"));
		lifeOnePlayerOne.setBounds(130, 1, 20, 16);
		JLabel lifeTwoPlayerOne = new JLabel(new ImageIcon("src/main/resources/images/tank_life_icon_red_15x15.png"));
		lifeTwoPlayerOne.setBounds(130, 17, 20, 16);
		JLabel lifeThreePlayerOne = new JLabel(new ImageIcon("src/main/resources/images/tank_life_icon_red_15x15.png"));
		lifeThreePlayerOne.setBounds(130, 33, 20, 16);

	
		playerOnePanel.setLayout(null);
		playerOnePanel.add(scorePlayerOne);
		playerOnePanel.add(lifeOnePlayerOne);
		playerOnePanel.add(lifeTwoPlayerOne);
		playerOnePanel.add(lifeThreePlayerOne);
		playerOnePanel.setBounds(0, 0, 150, 50);
		playerOnePanel.setBackground(Color.getHSBColor(0.4f, 0.4f, 0.5f));
		playerOnePanel.setOpaque(true);
		add(playerOnePanel);
	
	JButton backButton = new JButton("Back");
	backButton.setBounds(325, 0, 150, 50);
	backButton.setBorderPainted(false);
	backButton.setBorder(BorderFactory.createEtchedBorder(1));
	backButton.setForeground(Color.white);
	backButton.setBackground(Color.black);
	backButton.setFont(font);
	backButton.setActionCommand("soundB");
	backButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			EkranGlowny.buttonSoundEffect();
			EkranGry1Gracz.setVisible();
			new EkranNowaGra();
		}
	});
	add(backButton);

	JButton pauseButton = new JButton("Pause");
	pauseButton.setBounds(175, 0, 150, 50);
	pauseButton.setBorderPainted(false);
	pauseButton.setBorder(BorderFactory.createEtchedBorder(1));
	pauseButton.setForeground(Color.white);
	pauseButton.setBackground(Color.black);
	pauseButton.setFont(font);
	pauseButton.setActionCommand("soundB");
	pauseButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent a) {
			EkranGlowny.buttonSoundEffect();
		}

	});
	add(pauseButton);

	
	JButton soundButton = new JButton("Music");
	soundButton.setBounds(475, 0, 150, 50);
	soundButton.setBorderPainted(false);
	soundButton.setBorder(BorderFactory.createEtchedBorder(1));
	soundButton.setForeground(Color.white);
	soundButton.setBackground(Color.black);
	soundButton.setFont(font);
	soundButton.setActionCommand("musicB");
	
	soundButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		EkranGlowny.music();
		
	}

	});
	add(soundButton);
		
		newBorder borderTop = new newBorder(0,50,hBorder);
		borderTop.setName("border");
		add(borderTop);
		newBorder borderBottom = new newBorder(0,576,hBorder);
		borderBottom.setName("border");
		add(borderBottom);
		newBorder borderMenuOne = new newBorder(150,0,vBorderShort);
		borderMenuOne.setName("border");
		add(borderMenuOne);
		newBorder borderMenuTwo = new newBorder(625,0,vBorderShort);
		borderMenuTwo.setName("border");
		add(borderMenuTwo);
		newBorder borderLeft = new newBorder(0,50,vBorder);
		borderLeft.setName("border");
		add(borderLeft);
		newBorder borderRight = new newBorder(775,50,vBorder);
		borderRight.setName("border");
		add(borderRight);
		
		Scanner mapArea = new Scanner(new File(filePath));
				
		while(mapArea.hasNextLine()) {
			String nextLine = mapArea.nextLine();
			if (nextLine.charAt(2)==',') {
				String s1 = nextLine.substring(0, 2);
				if (nextLine.charAt(5)==',') {
					String s2 = nextLine.substring(3, 5);
					String s3 = nextLine.substring(6);
					int x = Integer.parseInt(s1);
					int y = Integer.parseInt(s2);
					if (s3.contains("bush")) {
						newObject object = new newObject(x, y, s3, "bush");
						object.setName("bush");
						object.invalidate();
						add(object);
					} else if (s3.contains("protection_wall")) {
						newObject object = new newObject(x, y, s3, "wall");
						object.setName("wall");
						add(object);
					} else if (s3.contains("indestructible")) {
						newObject object = new newObject(x, y, s3, "barrier");
						object.setName("barrier");
						add(object);
					} else if (s3.contains("barrier")) {
						newObject object = new newObject(x, y, s3, "field");
						object.setName("field");
						add(object);
					}
					
				}
				else if (nextLine.charAt(6)==',') {
					String s2 = nextLine.substring(3, 6);
					String s3 = nextLine.substring(7);
					int x = Integer.parseInt(s1);
					int y = Integer.parseInt(s2);
					if (s3.contains("bush")) {
						newObject object = new newObject(x, y, s3, "bush");
						object.setName("bush");
						object.invalidate();
						add(object);
					} else if (s3.contains("protection_wall")) {
						newObject object = new newObject(x, y, s3, "wall");
						object.setName("wall");
						add(object);
					} else if (s3.contains("indestructible")) {
						newObject object = new newObject(x, y, s3, "barrier");
						object.setName("barrier");
						add(object);
					} else if (s3.contains("barrier")) {
						newObject object = new newObject(x, y, s3, "field");
						object.setName("field");
						add(object);
					}
				}
			}
			else if (nextLine.charAt(3)==',') {
				String s1 = nextLine.substring(0, 3);
				if (nextLine.charAt(6)==',') {
					String s2 = nextLine.substring(4, 6);
					String s3 = nextLine.substring(7);
					int x = Integer.parseInt(s1);
					int y = Integer.parseInt(s2);
					if (s3.contains("bush")) {
						newObject object = new newObject(x, y, s3, "bush");
						object.setName("bush");
						object.invalidate();
						add(object);
					} else if (s3.contains("protection_wall")) {
						newObject object = new newObject(x, y, s3, "wall");
						object.setName("wall");
						add(object);
					} else if (s3.contains("indestructible")) {
						newObject object = new newObject(x, y, s3, "barrier");
						object.setName("barrier");
						add(object);
					} else if (s3.contains("barrier")) {
						newObject object = new newObject(x, y, s3, "field");
						object.setName("field");
						add(object);
					}
				}
				else if (nextLine.charAt(7)==',') {
					String s2 = nextLine.substring(4, 7);
					String s3 = nextLine.substring(8);
					int x = Integer.parseInt(s1);
					int y = Integer.parseInt(s2);
					if (s3.contains("bush")) {
						newObject object = new newObject(x, y, s3, "bush");
						object.setName("bush");
						object.invalidate();
						add(object);
					} else if (s3.contains("protection_wall")) {
						newObject object = new newObject(x, y, s3, "wall");
						object.setName("wall");
						add(object);
					} else if (s3.contains("indestructible")) {
						newObject object = new newObject(x, y, s3, "barrier");
						object.setName("barrier");
						add(object);
					} else if (s3.contains("barrier")) {
						newObject object = new newObject(x, y, s3, "field");
						object.setName("field");
						add(object);
					}
				}
				
			}
		}
		
		newTank playerOne = new newTank(75,525,redTank);
		playerOne.setName("tank1");
		add(playerOne);
		for (int i=0;i<300;i++) {
			add(playerOne.pociski.get(i));
			playerOne.pociski.get(i).setVisible(false);
			playerOne.pociski.get(i).setName("bulletP1");
			new Timer().scheduleAtFixedRate(new newBulletMovement(playerOne.pociski.get(i)), 0, 50);
			}
		
		newTank playerTwo = new newTank(675,525,blueTank);
		playerTwo.setName("tank2");
		add(playerTwo);
		for (int i=0;i<300;i++) {
			add(playerTwo.pociski.get(i));
			playerTwo.pociski.get(i).setVisible(false);
			playerTwo.pociski.get(i).setName("bulletP1");
			new Timer().scheduleAtFixedRate(new newBulletMovement(playerTwo.pociski.get(i)), 0, 50);
			}
		
//		newTank enemyOne = new newTank(300,75,grayTank);
//		enemyOne.setName("enemy");
//		add(enemyOne);
//		for (int i=0;i<300;i++) {
//			add(enemyOne.pociski.get(i));
//			enemyOne.pociski.get(i).setVisible(false);
//			enemyOne.pociski.get(i).setName("bulletEnemy");
//			new Timer().scheduleAtFixedRate(new newBulletMovement(enemyOne.pociski.get(i)), 0, 50);
//			}
//		new Timer().scheduleAtFixedRate(new newEnemyMovement(enemyOne), 0, 50);
		
//		newTank enemyTwo = new newTank(300,400,grayTank);
//		add(enemyTwo);
//		for (int i=0;i<300;i++) {
//			add(enemyTwo.pociski.get(i));
//			enemyTwo.pociski.get(i).setVisible(false);
//			new Timer().scheduleAtFixedRate(new newBulletMovement(enemyTwo.pociski.get(i)), 0, 50);
//			}
//		new Timer().scheduleAtFixedRate(new newEnemyMovement(enemyTwo), 0, 50);
		
		
		newPlayerMovement mOne = new newPlayerMovement(playerOne, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_SPACE);
		newPlayerMovement mTwo = new newPlayerMovement(playerTwo, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_ENTER);
		addKeyListener(mOne);
		addKeyListener(mTwo);
		
	}
	
}
