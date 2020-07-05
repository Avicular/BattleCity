package Poligon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Poligon.ekranGryFull.ekranGry.enemyTank;

public class ekranGryFull extends JPanel {

	public long distance1;
	public long distance2;

	public ekranGryFull() {

		ekranGry game = new ekranGry();
		game.setPreferredSize(new Dimension(800, 450));
		add(game);

		ekranGryMenu menu = new ekranGryMenu();
		menu.setPreferredSize(new Dimension(800, 150));
		menu.setLocation(0, 450);
		add(menu);
	}

	public class ekranGryMenu extends JPanel {

		public ekranGryMenu() {
			setLayout(null);

			JLabel playerOne = new JLabel("PLAYER 1");
			playerOne.setBounds(0, 0, 150, 150);
			playerOne.setBackground(Color.BLUE);
			playerOne.setOpaque(true);
			add(playerOne);

			JLabel playerTwo = new JLabel("PLAYER 2");
			playerTwo.setBounds(650, 0, 150, 150);
			playerTwo.setBackground(Color.RED);
			playerTwo.setOpaque(true);
			add(playerTwo);

			JLabel scorePlayerOne = new JLabel("TEXT");
			scorePlayerOne.setBounds(150, 50, 200, 100);
			scorePlayerOne.setBackground(Color.DARK_GRAY);
			scorePlayerOne.setOpaque(true);
			add(scorePlayerOne);

			JLabel scorePlayerTwo = new JLabel("TEXT");
			scorePlayerTwo.setBounds(450, 50, 200, 100);
			scorePlayerTwo.setBackground(Color.DARK_GRAY);
			scorePlayerTwo.setOpaque(true);
			add(scorePlayerTwo);

			JPanel lifePlayerOne = new JPanel();
			JLabel tankLifeOneOne = new JLabel(new ImageIcon("src/main/resources/images/tank_life_icon_red_red_50x50.png"));
			JLabel tankLifeOneTwo = new JLabel(new ImageIcon("src/main/resources/images/tank_life_icon_red_red_50x50.png"));
			JLabel tankLifeOneThree = new JLabel(
					new ImageIcon("src/main/resources/images/tank_life_icon_red_empty_50x50.png"));
			lifePlayerOne.add(tankLifeOneOne);
			lifePlayerOne.add(tankLifeOneTwo);
			lifePlayerOne.add(tankLifeOneThree);
			lifePlayerOne.setBounds(150, 0, 200, 50);
			lifePlayerOne.setBackground(Color.WHITE);
			lifePlayerOne.setOpaque(true);
			add(lifePlayerOne);

			JPanel lifePlayerTwo = new JPanel();
			JLabel tankLifeTwoOne = new JLabel(new ImageIcon("src/main/resources/images/tank_life_icon_red_red_50x50.png"));
			JLabel tankLifeTwoTwo = new JLabel(new ImageIcon("src/main/resources/images/tank_life_icon_red_red_50x50.png"));
			JLabel tankLifeTwoThree = new JLabel(
					new ImageIcon("src/main/resources/images/tank_life_icon_red_empty_50x50.png"));
			lifePlayerTwo.add(tankLifeTwoOne);
			lifePlayerTwo.add(tankLifeTwoTwo);
			lifePlayerTwo.add(tankLifeTwoThree);
			lifePlayerTwo.setBounds(450, 0, 200, 50);
			lifePlayerTwo.setBackground(Color.WHITE);
			lifePlayerTwo.setOpaque(true);
			add(lifePlayerTwo);

			JButton backButton = new JButton("powr�t");
			backButton.setBounds(350, 0, 100, 50);
			backButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent a) {
					setVisible(false);
				}

			});
			add(backButton);

			JButton pauseButton = new JButton("pauza");
			pauseButton.setBounds(350, 50, 100, 50);
			pauseButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent a) {

				}

			});
			add(pauseButton);

			JButton soundButton = new JButton("sound on/off");
			soundButton.setBounds(350, 100, 100, 50);
			soundButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent a) {

				}

			});
			add(soundButton);

		}
	}

	public class ekranGry extends JPanel {

		String blueTank = "src/main/resources/images/basic_tank_icon.png";
		String grayTank = "src/main/resources/images/gray_tank_icon.png";
		String redTank = "src/main/resources/images/red_tank_icon.png";

		loadTank tank1 = new loadTank(0, 400, blueTank);
		loadTank tank2 = new loadTank(750, 400, redTank);
		enemyTank eTank1 = new enemyTank(0, 0, grayTank);
		enemyTank eTank2 = new enemyTank(200, 0, grayTank);
		enemyTank eTank3 = new enemyTank(550, 0, grayTank);
		enemyTank eTank4 = new enemyTank(750, 0, grayTank);

		ArrayList<loadWall> walls = new ArrayList<loadWall>();
		ArrayList<loadField> fields = new ArrayList<loadField>();
		ArrayList<loadBlock> blocks = new ArrayList<loadBlock>();
		
		public Double tankAngle = -Math.PI / 2;
		public Double enemyAngle = Math.PI / 2;

		public ekranGry() {
			setLayout(null);
			add(tank1);
			add(tank2);
			add(eTank1);
			add(eTank2);
			add(eTank3);
			add(eTank4);
			setFocusable(true);

// adding obstacles			
			walls.add(new loadWall(0, 50));
			walls.add(new loadWall(0, 100));
			walls.add(new loadWall(0, 150));
			walls.add(new loadWall(0, 250));
			walls.add(new loadWall(0, 300));
			walls.add(new loadWall(0, 350));
			walls.add(new loadWall(50, 0));
			walls.add(new loadWall(50, 50));
			walls.add(new loadWall(50, 150));
			walls.add(new loadWall(50, 200));
			walls.add(new loadWall(50, 250));
			walls.add(new loadWall(50, 350));
			walls.add(new loadWall(50, 400));
			walls.add(new loadWall(100, 100));
			walls.add(new loadWall(100, 200));
			walls.add(new loadWall(100, 300));
			walls.add(new loadWall(150, 100));
			walls.add(new loadWall(150, 200));
			walls.add(new loadWall(150, 300));
			walls.add(new loadWall(200, 100));
			walls.add(new loadWall(200, 150));
			walls.add(new loadWall(200, 200));
			walls.add(new loadWall(200, 250));
			walls.add(new loadWall(200, 300));
			walls.add(new loadWall(250, 100));
			walls.add(new loadWall(250, 150));
			walls.add(new loadWall(250, 200));
			walls.add(new loadWall(250, 250));
			walls.add(new loadWall(250, 300));
			walls.add(new loadWall(300, 0));
			walls.add(new loadWall(300, 50));
			walls.add(new loadWall(300, 100));
			walls.add(new loadWall(300, 150));
			walls.add(new loadWall(300, 200));
			walls.add(new loadWall(300, 250));
			walls.add(new loadWall(300, 300));
			walls.add(new loadWall(300, 350));
			walls.add(new loadWall(300, 400));
			walls.add(new loadWall(350, 100));
			walls.add(new loadWall(350, 150));
			walls.add(new loadWall(350, 200));
			walls.add(new loadWall(350, 250));
			walls.add(new loadWall(350, 300));
			walls.add(new loadWall(350, 350));
			walls.add(new loadWall(350, 400));
			walls.add(new loadWall(400, 100));
			walls.add(new loadWall(400, 150));
			walls.add(new loadWall(400, 200));
			walls.add(new loadWall(400, 250));
			walls.add(new loadWall(400, 300));
			walls.add(new loadWall(400, 350));
			walls.add(new loadWall(400, 400));
			walls.add(new loadWall(450, 0));
			walls.add(new loadWall(450, 50));
			walls.add(new loadWall(450, 100));
			walls.add(new loadWall(450, 150));
			walls.add(new loadWall(450, 200));
			walls.add(new loadWall(450, 250));
			walls.add(new loadWall(450, 300));
			walls.add(new loadWall(450, 350));
			walls.add(new loadWall(450, 400));
			walls.add(new loadWall(500, 100));
			walls.add(new loadWall(500, 150));
			walls.add(new loadWall(500, 200));
			walls.add(new loadWall(500, 250));
			walls.add(new loadWall(500, 300));
			walls.add(new loadWall(550, 100));
			walls.add(new loadWall(550, 150));
			walls.add(new loadWall(550, 200));
			walls.add(new loadWall(550, 250));
			walls.add(new loadWall(550, 300));
			walls.add(new loadWall(600, 100));
			walls.add(new loadWall(600, 200));
			walls.add(new loadWall(600, 300));
			walls.add(new loadWall(650, 100));
			walls.add(new loadWall(650, 200));
			walls.add(new loadWall(650, 300));
			walls.add(new loadWall(700, 0));
			walls.add(new loadWall(700, 50));
			walls.add(new loadWall(700, 150));
			walls.add(new loadWall(700, 200));
			walls.add(new loadWall(700, 250));
			walls.add(new loadWall(700, 350));
			walls.add(new loadWall(700, 400));
			walls.add(new loadWall(750, 50));
			walls.add(new loadWall(750, 100));
			walls.add(new loadWall(750, 150));
			walls.add(new loadWall(750, 250));
			walls.add(new loadWall(750, 300));
			walls.add(new loadWall(750, 350));
			
			for (int i = 0; i < blocks.size(); i++)
				add(blocks.get(i));
			for (int i = 0; i < walls.size(); i++)
				add(walls.get(i));
			for (int i = 0; i < fields.size(); i++)
				add(fields.get(i));
			
// random obstacle generator			
//			for (int i=0;i<75;i++) {
//				int x = (int)(Math.random()*16)*50;
//				int y = (int)(Math.random()*8)*50;
//			walls.add(new loadWall(x,y));
//			}
//			for (int i=0;i<walls.size();i++)
//				add(walls.get(i));

// other method to generate obstacles			
//			for (int a=1;a<=8;a++) {
//				if (a%2 != 0)
//				for (int i=1;i<=14;i++) {
//					add(new loadWall(i*50,a*50));
//				}
//			}

			playerOneMomement p1 = new playerOneMomement();
			playerTwoMovement p2 = new playerTwoMovement();
			addKeyListener(p1);
			addKeyListener(p2);
			setBackground(Color.DARK_GRAY);

			Timer enemyTimer1 = new Timer();
			
			enemyAutoMove enemyMove1 = new enemyAutoMove(eTank1);
			enemyTimer1.scheduleAtFixedRate(enemyMove1, 0, 50);
			
			enemyAutoMove enemyMove2 = new enemyAutoMove(eTank2);
			enemyTimer1.scheduleAtFixedRate(enemyMove2, 0, 50);
			
			enemyAutoMove enemyMove3 = new enemyAutoMove(eTank3);
			enemyTimer1.scheduleAtFixedRate(enemyMove3, 0, 50);
			
			enemyAutoMove enemyMove4 = new enemyAutoMove(eTank4);
			enemyTimer1.scheduleAtFixedRate(enemyMove4, 0, 50);

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

		public class loadWall extends JLabel {

			int x;
			int y;

			public loadWall(int x, int y) {
				setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
				new JLabel();
				setBounds(this.x = x, this.y = y, 50, 50);
				// setBackground(Color.BLACK);
				add(new JLabel(new ImageIcon("src/main/resources/images/protection_wall_icon_50px_50px_blackborder.png")));
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
				add(new JLabel(new ImageIcon("src/main/resources/images/protection_field_icon_50px_50px.png")));
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
						String objectClass = getComponentAt(tank1.getX() + i, tank1.getY() - 1).getClass().getName();
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
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
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
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
					for (int i = 0; i <= 49; i++) {
						String objectClass = getComponentAt(tank1.getX() - 1, tank1.getY() + i).getClass().getName();
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
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
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
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
					System.out.println(tank1.getLocation());
					System.out.println(getComponentAt(50, 350).getClass().getName());
					System.out.println("Player's 1 tank distance: " + distance1 * 2 + " pixels.");

				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		}

		public class playerTwoMovement implements KeyListener {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (tankAngle != -(Math.PI / 2)) {
						tankAngle = -Math.PI / 2;
						tank2.repaint();
					}
					int counter = 0;
					for (int i = 0; i <= 49; i++) {
						String objectClass = getComponentAt(tank2.getX() + i, tank2.getY() - 1).getClass().getName();
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
							counter++;
					}
					if (counter > 0)
						tank2.setLocation(tank2.getX(), tank2.getY());
					else
						tank2.setLocation(tank2.getX(), tank2.getY() - 2);
					distance2++;
					System.out.println("Ruch o pixel w g�r�.");
				}

				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (tankAngle != (Math.PI / 2)) {
						tankAngle = Math.PI / 2;
						tank2.repaint();
					}
					int counter = 0;
					for (int i = 0; i <= 49; i++) {
						String objectClass = getComponentAt(tank2.getX() + i, tank2.getY() + 51).getClass().getName();
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
							counter++;
					}
					if (counter > 0)
						tank2.setLocation(tank2.getX(), tank2.getY());
					else
						tank2.setLocation(tank2.getX(), tank2.getY() + 2);
					distance2++;
					System.out.println("Ruch o pixel w d�.");
				}

				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (tankAngle != Math.PI) {
						tankAngle = Math.PI;
						tank2.repaint();
					}
					int counter = 0;
					for (int i = 0; i <= 49; i++) {
						String objectClass = getComponentAt(tank2.getX() - 1, tank2.getY() + i).getClass().getName();
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
							counter++;
					}
					if (counter > 0)
						tank2.setLocation(tank2.getX(), tank2.getY());
					else
						tank2.setLocation(tank2.getX() - 2, tank2.getY());
					distance2++;
					System.out.println("Ruch o pixel w lewo.");
				}

				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (tankAngle != 0) {
						tankAngle = (double) 0;
						tank2.repaint();
					}
					int counter = 0;
					for (int i = 0; i <= 49; i++) {
						String objectClass = getComponentAt(tank2.getX() + 51, tank2.getY() + i).getClass().getName();
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
							counter++;
					}
					if (counter > 0)
						tank2.setLocation(tank2.getX(), tank2.getY());
					else
						tank2.setLocation(tank2.getX() + 2, tank2.getY());
					distance2++;
					System.out.println("Ruch o pixel w prawo.");
				}

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("Player's 2 tank distance: " + distance2 * 2 + " pixels.");
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
				
				if (Math.random()>0.95) {
					enemyAngle = enemyAngles.get(random);
					eTank1.repaint();
				}
				if (enemyAngle == -Math.PI/2) {
					try {
						int counter = 0;
						for (int i = 0; i <= 49; i++) {
							String objectClass = getComponentAt(eTank1.getX() + i, eTank1.getY() - 1).getClass().getName();		
							if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
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
							if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
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
							if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
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
							if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
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

	}

}
