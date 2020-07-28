package gameContent;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BattleCity.EkranGlowny;
import BattleCity.EkranGry1Gracz;
import BattleCity.EkranNowaGra;

public class onePlayerGame extends JPanel {

	public long distance1;
	public long distance2;
		String muzykaOnOff;
		Font font = new Font("Visitor TT1 BRK", Font.BOLD, 28);
		String blueTank = "src/main/resources/images/basic_tank_icon.png";
		String grayTank = "src/main/resources/images/gray_tank_icon.png";
		String redTank = "src/main/resources/images/red_tank_icon.png";
		
		String tankObject = "gameContent.onePlayerGame$loadTank";
		String enemyObject = "gameContent.onePlayerGame$enemyTank";
		String wallObject = "gameContent.onePlayerGame$loadWall";
		String fieldObject = "gameContent.onePlayerGame$loadField";
		String blockObject = "gameContent.onePlayerGame$loadBlock";
		String plantObject = "gameContent.onePlayerGame$loadGrass";
		String barrierObject = "gameContent.onePlayerGame$loadBorder";
		
		loadTank tank1 = new loadTank(25, 525, redTank);

		enemyTank eTank1 = new enemyTank(250, 100, grayTank);
		enemyTank eTank2 = new enemyTank(375, 100, grayTank);
		enemyTank eTank3 = new enemyTank(500, 100, grayTank);
		enemyTank eTank4 = new enemyTank(650, 0, grayTank);
		
		int bulletPlayerOne = 300;
		int bulletCounterOne = 299;
		int bulletPlayerTwo = 300;
		int bulletCounterTwo = 299;
		
		
		ArrayList<loadWall> walls = new ArrayList<loadWall>();
		ArrayList<loadField> fields = new ArrayList<loadField>();
		ArrayList<loadBlock> blocks = new ArrayList<loadBlock>();
		ArrayList<loadGrass> plants = new ArrayList<loadGrass>();
		
		ArrayList<loadBullet> bulletsPlayerOne = new ArrayList<loadBullet>();
		ArrayList<loadBullet> bulletsPlayerTwo = new ArrayList<loadBullet>(); 
		
//		ArrayList<Double> bulletAngles = new ArrayList<Double>(); 
		
		public Double tankAngle = -Math.PI / 2;
		public Double enemyAngle = Math.PI / 2;
		//public Double bulletAngle = (double) 0;
		//public TimerTask bulletMove1;

		public onePlayerGame() {
			setLayout(null);
			setFocusable(true);
// adding score and HP panel
			
			
			JPanel playerOne = new JPanel();
				JLabel scorePlayerOne = new JLabel();
				scorePlayerOne.setBounds(0, 0, 130, 50);
				scorePlayerOne.setText("   PLAYER 1   ");
				
				JLabel lifeOnePlayerOne = new JLabel(new ImageIcon("src/main/resources/images/tank_life_icon_red_15x15.png"));
				lifeOnePlayerOne.setBounds(130, 1, 20, 16);
				JLabel lifeTwoPlayerOne = new JLabel(new ImageIcon("src/main/resources/images/tank_life_icon_red_15x15.png"));
				lifeTwoPlayerOne.setBounds(130, 17, 20, 16);
				JLabel lifeThreePlayerOne = new JLabel(new ImageIcon("src/main/resources/images/tank_life_icon_red_15x15.png"));
				lifeThreePlayerOne.setBounds(130, 33, 20, 16);

			
			playerOne.setLayout(null);
			playerOne.add(scorePlayerOne);
			playerOne.add(lifeOnePlayerOne);
			playerOne.add(lifeTwoPlayerOne);
			playerOne.add(lifeThreePlayerOne);
			playerOne.setBounds(0, 0, 150, 50);
			playerOne.setBackground(Color.getHSBColor(0.4f, 0.4f, 0.5f));
			playerOne.setOpaque(true);
			add(playerOne);
			
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

// adding game area borders and scoreboard/menu borders
			String hBorder = "src/main/resources/images/protection_border_icon_800px_25px.png";
			String vBorder = "src/main/resources/images/protection_border_icon_25px_800px.png";
			String vBorderShort = "src/main/resources/images/protection_border_icon_25px_50px.png";
			
			
			
			loadBorder borderTop = new loadBorder(0,50,hBorder);
			add(borderTop);
			loadBorder borderBottom = new loadBorder(0,575,hBorder);
			add(borderBottom);
			loadBorder borderMenuOne = new loadBorder(150,0,vBorderShort);
			add(borderMenuOne);
			loadBorder borderMenuTwo = new loadBorder(625,0,vBorderShort);
			add(borderMenuTwo);
			loadBorder borderLeft = new loadBorder(0,50,vBorder);
			add(borderLeft);
			loadBorder borderRight = new loadBorder(775,50,vBorder);
			add(borderRight);
			
			
// adding obstacles			
			blocks.add(new loadBlock(50, 75));
			walls.add(new loadWall(50, 150));
			walls.add(new loadWall(50, 200));
			walls.add(new loadWall(50, 250));
			walls.add(new loadWall(50, 350));
			blocks.add(new loadBlock(100, 75));
			walls.add(new loadWall(100, 100));
			fields.add(new loadField(100, 150));
			walls.add(new loadWall(100, 200));
			fields.add(new loadField(100, 250));
			walls.add(new loadWall(100, 300));
			plants.add(new loadGrass(100, 350));
			plants.add(new loadGrass(100, 400));
			blocks.add(new loadBlock(150, 75));
			walls.add(new loadWall(150, 100));
			fields.add(new loadField(150, 150));
			walls.add(new loadWall(150, 200));
			fields.add(new loadField(150, 250));
			walls.add(new loadWall(150, 300));
			plants.add(new loadGrass(150, 350));
			plants.add(new loadGrass(150, 400));
			walls.add(new loadWall(200, 100));
			walls.add(new loadWall(200, 150));
			walls.add(new loadWall(200, 200));
			walls.add(new loadWall(200, 250));
			walls.add(new loadWall(200, 300));
			plants.add(new loadGrass(200, 350));
			plants.add(new loadGrass(200, 400));
			walls.add(new loadWall(250, 150));
			blocks.add(new loadBlock(250, 200));
			walls.add(new loadWall(250, 250));
			walls.add(new loadWall(250, 300));
			plants.add(new loadGrass(250, 350));
			plants.add(new loadGrass(250, 400));
			walls.add(new loadWall(300, 75));
			walls.add(new loadWall(300, 100));
			walls.add(new loadWall(300, 150));
			blocks.add(new loadBlock(300, 200));
			walls.add(new loadWall(300, 250));
			walls.add(new loadWall(300, 300));
			walls.add(new loadWall(300, 350));
			walls.add(new loadWall(300, 400));
			walls.add(new loadWall(350, 150));
			blocks.add(new loadBlock(350, 200));
			walls.add(new loadWall(350, 250));
			walls.add(new loadWall(350, 300));
			walls.add(new loadWall(350, 350));
			walls.add(new loadWall(350, 400));
			walls.add(new loadWall(400, 150));
			blocks.add(new loadBlock(400, 200));
			walls.add(new loadWall(400, 250));
			walls.add(new loadWall(400, 300));
			walls.add(new loadWall(400, 350));
			walls.add(new loadWall(400, 400));
			walls.add(new loadWall(450, 75));
			walls.add(new loadWall(450, 100));
			walls.add(new loadWall(450, 150));
			blocks.add(new loadBlock(450, 200));
			walls.add(new loadWall(450, 250));
			walls.add(new loadWall(450, 300));
			walls.add(new loadWall(450, 350));
			walls.add(new loadWall(450, 400));
			walls.add(new loadWall(500, 150));
			blocks.add(new loadBlock(500, 200));
			walls.add(new loadWall(500, 250));
			walls.add(new loadWall(500, 300));
			plants.add(new loadGrass(500, 350));
			plants.add(new loadGrass(500, 400));
			walls.add(new loadWall(550, 100));
			walls.add(new loadWall(550, 150));
			walls.add(new loadWall(550, 200));
			walls.add(new loadWall(550, 250));
			walls.add(new loadWall(550, 300));
			plants.add(new loadGrass(550, 350));
			plants.add(new loadGrass(550, 400));
			blocks.add(new loadBlock(600, 75));
			walls.add(new loadWall(600, 100));
			fields.add(new loadField(600, 150));
			walls.add(new loadWall(600, 200));
			fields.add(new loadField(600, 250));
			walls.add(new loadWall(600, 300));
			plants.add(new loadGrass(600, 350));
			plants.add(new loadGrass(600, 400));
			blocks.add(new loadBlock(650, 75));
			walls.add(new loadWall(650, 100));
			fields.add(new loadField(650, 150));
			walls.add(new loadWall(650, 200));
			fields.add(new loadField(650, 250));
			walls.add(new loadWall(650, 300));
			plants.add(new loadGrass(650, 350));
			plants.add(new loadGrass(650, 400));
			blocks.add(new loadBlock(700, 75));
			walls.add(new loadWall(700, 150));
			walls.add(new loadWall(700, 200));
			walls.add(new loadWall(700, 250));
			walls.add(new loadWall(700, 350));
			
			for (int i = 0; i < blocks.size(); i++)
				add(blocks.get(i));
			for (int i = 0; i < walls.size(); i++)
				add(walls.get(i));
			for (int i = 0; i < fields.size(); i++)
				add(fields.get(i));
			for (int i = 0; i < plants.size(); i++)
				add(plants.get(i));
			
			add(tank1);
			add(eTank1);
			add(eTank2);
			add(eTank3);
			//add(eTank4);
			playerOneMomement p1 = new playerOneMomement();
			
			for (int i=0;i<bulletPlayerOne;i++) {
				bulletsPlayerOne.add(new loadBullet(tank1.getX()+21,tank1.getY()-20));
				add(bulletsPlayerOne.get(i));
				bulletsPlayerOne.get(i).setVisible(false);
				new Timer().scheduleAtFixedRate(new bulletMove(bulletsPlayerOne.get(i)), 0, 50);;
			}
			
			for (int i=0;i<bulletPlayerTwo;i++) {
				bulletsPlayerTwo.add(new loadBullet(tank1.getX()+21,tank1.getY()-20));
				add(bulletsPlayerTwo.get(i));
				bulletsPlayerTwo.get(i).setVisible(false);
				new Timer().scheduleAtFixedRate(new bulletMove(bulletsPlayerTwo.get(i)), 0, 50);;
			}
			
//			for(int i=0;i<bulletPlayerOne;i++) {
//				bulletAngles.add((double) 0);
//			}
			
			addKeyListener(p1);
			
			setBackground(Color.DARK_GRAY);
			
//			Timer bulletTimer = new Timer();
//			bulletsPlayerOne.get(bulletCounterOne).setVisible(true);
//			bulletMove1 = new bulletMove(bulletsPlayerOne.get(bulletCounterOne));
//			bulletTimer.scheduleAtFixedRate(bulletMove1, 0, 50);
//			Timer enemyTimer1 = new Timer();
//			
//			enemyAutoMove enemyMove1 = new enemyAutoMove(eTank1);
//			enemyTimer1.scheduleAtFixedRate(enemyMove1, 0, 50);
//			
//			enemyAutoMove enemyMove2 = new enemyAutoMove(eTank2);
//			enemyTimer1.scheduleAtFixedRate(enemyMove2, 0, 50);
//			
//			enemyAutoMove enemyMove3 = new enemyAutoMove(eTank3);
//			enemyTimer1.scheduleAtFixedRate(enemyMove3, 0, 50);
//			
//			enemyAutoMove enemyMove4 = new enemyAutoMove(eTank4);
//			enemyTimer1.scheduleAtFixedRate(enemyMove4, 0, 50);		

		}
		
		public class loadTank extends JLabel {

			int x;
			int y;
			String tankVersion;

			public loadTank(int x, int y, String tankVersion) {

				setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				setBounds(this.x = x, this.y = y, 50, 50);
				ImageIcon tankIcon = new ImageIcon(this.tankVersion = tankVersion);
				add(new JLabel(tankIcon) {
					@Override
					protected void paintComponent(Graphics g) {
						Graphics2D g2 = (Graphics2D) g;
						g2.rotate(tankAngle, tankIcon.getIconWidth() / 2, tankIcon.getIconHeight() / 2);
						g2.drawImage(tankIcon.getImage(), 0, 0, null);
					}
				});

				System.out.println("player's tank added");
				System.out.println("tank hitpoints:3");
			}
		}

		public class enemyTank extends JLabel {

			int x;
			int y;
			String tankVersion;

			public enemyTank(int x, int y, String tankVersion) {

				setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				setBounds(this.x = x, this.y = y, 50, 50);
				ImageIcon tankIcon = new ImageIcon(this.tankVersion = tankVersion);
				add(new JLabel(tankIcon) {
					@Override
					protected void paintComponent(Graphics g) {
						Graphics2D g2 = (Graphics2D) g;
						g2.rotate(enemyAngle, tankIcon.getIconWidth() / 2, tankIcon.getIconHeight() / 2);
						g2.drawImage(tankIcon.getImage(), 0, 0, null);
					}
				});

				System.out.println("enemy's tank added");
				System.out.println("tank hitpoints:3");
			}
		}

		public class loadGrass extends JLabel {

			int x;
			int y;

			public loadGrass(int x, int y) {
				setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				new JLabel();
				setBounds(this.x = x, this.y = y, 50, 50);
				// setBackground(Color.BLACK);
				add(new JLabel(new ImageIcon("src/main/resources/images/bush_field_bordered_icon_50px_50px.png")));
			}
		}
		
		public class loadWall extends JLabel {

			int x;
			int y;

			public loadWall(int x, int y) {
				setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				new JLabel();
				setBounds(this.x = x, this.y = y, 50, 50);
				// setBackground(Color.BLACK);
				add(new JLabel(new ImageIcon("src/main/resources/images/protection_wall_icon_50px_50px.png")));
			}
		}

		public class loadField extends JLabel {

			int x;
			int y;

			public loadField(int x, int y) {
				setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				new JLabel();
				setBounds(this.x = x, this.y = y, 50, 50);
				// setBackground(Color.BLACK);
				add(new JLabel(new ImageIcon("src/main/resources/images/protection_barrier_icon_50px_50px.png")));
			}
		}
		
		public class loadBlock extends JLabel {

			int x;
			int y;

			public loadBlock(int x, int y) {
				setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				new JLabel();
				setBounds(this.x = x, this.y = y, 50, 50);
				// setBackground(Color.BLACK);
				add(new JLabel(new ImageIcon("src/main/resources/images/indestructible_wall_icon_50px_50px.png")));
			}
		}
		
		public class loadBorder extends JLabel {

			int x;
			int y;
			String borderPath;
			

			public loadBorder(int x, int y, String borderPath) {
				setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				new JLabel();
				ImageIcon icon = new ImageIcon(borderPath);
				setBounds(this.x = x, this.y = y, icon.getIconWidth(), icon.getIconHeight());
				// setBackground(Color.BLACK);
				add(new JLabel(icon));
			}
		}
		
		
		
		public class loadBullet extends JLabel {

			int x;
			int y;
			
			public loadBullet(int x, int y) {
				setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				setBounds(this.x = x, this.y = y, 8, 20);
				ImageIcon bulletIcon = new ImageIcon("src/main/resources/images/red_bullet_icon.png");
				add(new JLabel(bulletIcon) {
					@Override
					protected void paintComponent(Graphics g) {
						Graphics2D g2 = (Graphics2D) g;
//						g2.rotate(bulletAngles.get(bulletCounterOne), bulletIcon.getIconWidth() / 2, bulletIcon.getIconHeight() / 2);
						g2.rotate(Math.PI, bulletIcon.getIconWidth() / 2, bulletIcon.getIconHeight() / 2);
						g2.drawImage(bulletIcon.getImage(), 0, 0, null);
					}
				});
			}
			
		}

		public class playerOneMomement implements KeyListener {	
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_W) {
					if (tankAngle != -(Math.PI / 2)) {
						tankAngle = -Math.PI / 2;
						tank1.repaint();
					}
					int counter = 0;
					for (int i = 0; i <= 49; i++) {
						String objectClass = getComponentAt(tank1.getX() + i, tank1.getY()-1).getClass().getName();
						if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject)
							counter++;
					}
					if (counter > 0)
						tank1.setLocation(tank1.getX(), tank1.getY());
					else
						tank1.setLocation(tank1.getX(), tank1.getY() - 2);
					distance1++;
					System.out.println("Ruch o pixel w g�r�.");
				}

				if (e.getKeyCode() == KeyEvent.VK_S) {
					if (tankAngle != (Math.PI / 2)) {
						tankAngle = Math.PI / 2;
						tank1.repaint();
					}
					int counter = 0;
					for (int i = 0; i <= 49; i++) {
						String objectClass = getComponentAt(tank1.getX() + i, tank1.getY() + 51).getClass().getName();
						if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject)
							counter++;
					}
					if (counter > 0)
						tank1.setLocation(tank1.getX(), tank1.getY());
					else
						tank1.setLocation(tank1.getX(), tank1.getY() + 2);
					distance1++;
					System.out.println("Ruch o pixel w d�.");
				}

				if (e.getKeyCode() == KeyEvent.VK_A) {
					if (tankAngle != Math.PI) {
						tankAngle = Math.PI;
						tank1.repaint();
					}
					int counter = 0;
					for (int i = 0; i < 49; i++) {
						String objectClass = getComponentAt(tank1.getX() - 1, tank1.getY() + i).getClass().getName();
						if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject)
							counter++;
					}
					if (counter > 0)
						tank1.setLocation(tank1.getX(), tank1.getY());
					else
						tank1.setLocation(tank1.getX() - 2, tank1.getY());
					distance1++;
					System.out.println("Ruch o pixel w lewo.");
				}

				if (e.getKeyCode() == KeyEvent.VK_D) {
					if (tankAngle != 0) {
						tankAngle = (double) 0;
						tank1.repaint();
					}
					int counter = 0;
					for (int i = 0; i <= 49; i++) {
						String objectClass = getComponentAt(tank1.getX() + 51, tank1.getY() + i).getClass().getName();
						if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject)
							counter++;
					}
					if (counter > 0)
						tank1.setLocation(tank1.getX(), tank1.getY());
					else
						tank1.setLocation(tank1.getX() + 2, tank1.getY());
					distance1++;
					System.out.println("Ruch o pixel w prawo.");
				}

				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (tankAngle == -Math.PI / 2) {
//						bulletAngles.get(bulletCounterOne)
//						bulletAngles.set(bulletCounterOne, Math.PI);
						bulletsPlayerOne.get(bulletCounterOne).setBounds(tank1.getX()+21, tank1.getY()-20, 8, 20);
						bulletsPlayerOne.get(bulletCounterOne).repaint();
						bulletsPlayerOne.get(bulletCounterOne).setVisible(true);
						bulletCounterOne--;
//						System.out.println(bulletAngles.get(bulletCounterOne));
						System.out.println("Zosta�o " + bulletCounterOne + " pocisk�w!");
					}
					else if (tankAngle == (double) 0) {
						//bulletAngles.get(bulletCounterOne)
						bulletsPlayerOne.get(bulletCounterOne).setBounds(tank1.getX()+70, tank1.getY()+21, 8, 20);
						bulletsPlayerOne.get(bulletCounterOne).repaint();
						bulletsPlayerOne.get(bulletCounterOne).setVisible(true);
						bulletCounterOne--;
//						System.out.println(bulletAngles.get(bulletCounterOne));
						System.out.println("Zosta�o " + bulletCounterOne + " pocisk�w!");
					}
					else if (tankAngle == Math.PI/2) {
//						bulletAngles.get(bulletCounterOne)
						bulletsPlayerOne.get(bulletCounterOne).setBounds(tank1.getX()+29, tank1.getY()+70, 8, 20);
						bulletsPlayerOne.get(bulletCounterOne).repaint();
						bulletsPlayerOne.get(bulletCounterOne).setVisible(true);
						bulletCounterOne--;
//						System.out.println(bulletAngles.get(bulletCounterOne));
						System.out.println("Zosta�o " + bulletCounterOne + " pocisk�w!");
					}
					else if (tankAngle == Math.PI) {
//						bulletAngles.get(bulletCounterOne)
						bulletsPlayerOne.get(bulletCounterOne).setBounds(tank1.getX()-20, tank1.getY()+29, 8, 20);
						bulletsPlayerOne.get(bulletCounterOne).repaint();
						bulletsPlayerOne.get(bulletCounterOne).setVisible(true);
						bulletCounterOne--;
//						System.out.println(bulletAngles.get(bulletCounterOne));
						System.out.println("Zosta�o " + bulletCounterOne + " pocisk�w!");
					}

				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		}

		public class enemyAutoMove extends TimerTask {

			enemyTank eTank1;
			int timer = 0;
			
			public enemyAutoMove(enemyTank eTank1) {
				this.eTank1 = eTank1;
			}	

			@Override
			public void run() {
				timer++;
				ArrayList<Double> enemyAngles = new ArrayList<Double>();
				enemyAngles.add(-Math.PI/2);
				enemyAngles.add((double)0);
				enemyAngles.add(Math.PI/2);
				enemyAngles.add(Math.PI);
				
				int random = (int)(Math.random()*4);
				
				if (Math.random()>0.99) {
					enemyAngle = enemyAngles.get(random);
					eTank1.repaint();
				}
				if (enemyAngle == -Math.PI/2) {
					try {
						int counter = 0;
						for (int i = 0; i <= 49; i++) {
							String objectClass = getComponentAt(eTank1.getX() + i, eTank1.getY() - 1).getClass().getName();		
							if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject)
								counter++;
						}
						if (counter > 0)
							eTank1.setLocation(eTank1.getX(), eTank1.getY());
						else
							eTank1.setLocation(eTank1.getX(), eTank1.getY() - 2);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else if (enemyAngle == (double)0){
					try {
						int counter = 0;
						for (int i = 0; i <= 49; i++) {
							String objectClass = getComponentAt(eTank1.getX() + 51, eTank1.getY() + i).getClass().getName();		
							if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject)
								counter++;
						}
						if (counter > 0)
							eTank1.setLocation(eTank1.getX(), eTank1.getY());
						else
							eTank1.setLocation(eTank1.getX() + 2, eTank1.getY());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else if (enemyAngle == Math.PI/2) {
					try {
						int counter = 0;
						for (int i = 0; i <= 49; i++) {
							String objectClass = getComponentAt(eTank1.getX() + i, eTank1.getY() + 51).getClass().getName();
							if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject)
								counter++;
						}
						if (counter > 0)
							eTank1.setLocation(eTank1.getX(), eTank1.getY());
						else
							eTank1.setLocation(eTank1.getX(), eTank1.getY() + 2);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else if (enemyAngle == Math.PI) {
					try {
						int counter = 0;
						for (int i = 0; i <= 49; i++) {
							String objectClass = getComponentAt(eTank1.getX() - 1, eTank1.getY() + i).getClass().getName();
							if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject)
								counter++;
						}
						if (counter > 0)
							eTank1.setLocation(eTank1.getX(), eTank1.getY());
						else
							eTank1.setLocation(eTank1.getX() - 2, eTank1.getY());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}

		
		public class bulletMove extends TimerTask {
			
			loadBullet bullet;
			Double tankangle;
			int timer = 0;
			
			public bulletMove(loadBullet bullet) {
				this.bullet = bullet;
			}

			@Override
			public void run() {
				timer++;
			
				bullet.setLocation(bullet.getX(), bullet.getY()-4);
				if (bullet.isVisible()){
					String objectClass = getComponentAt(bullet.getX(), bullet.getY()-1).getClass().getName();		
					if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject) {
						bullet.removeAll();
					}	
				}
//				bullet.setLocation(bullet.getX(), bullet.getY()+4);
//				bullet.setLocation(bullet.getX()-4, bullet.getY());
//				bullet.setLocation(bullet.getX()+4, bullet.getY());
				
//				if (bulletAngles.get(bulletCounterOne) == 0) {
//					bullet.setLocation(bullet.getX(), bullet.getY()-4);
//					if (bullet.isVisible()){
//						String objectClass = getComponentAt(bullet.getX(), bullet.getY()-1).getClass().getName();		
//						if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject) {
//							bullet.removeAll();
//					
//				}
				
				
//				if (timer==1) {
//					if (tankangle == (double) 0) {
//						
//					}
//				}
					//if
				
//				if (bulletsPlayerOne.get(bulletCounterOne).bulletAngle == (double) 0) {
//					
//					bullet.setLocation(bullet.getX(), bullet.getY()-4);
//					if (bullet.isVisible()){
//					String objectClass = getComponentAt(bullet.getX(), bullet.getY()-1).getClass().getName();		
//					if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject) {
//						bullet.removeAll();
//					}
//				}
//				
//				} else if (bulletsPlayerOne.get(bulletCounterOne).bulletAngle == Math.PI/2) {
//					
//					bullet.setLocation(bullet.getX()+4, bullet.getY());
//					if (bullet.isVisible()){
//					String objectClass = getComponentAt(bullet.getX(), bullet.getY()-1).getClass().getName();		
//					if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject) {
//						bullet.removeAll();
//					}
//				}
//				
//				}
				
				//System.out.println(timer);
			}

		}
		
	

}
