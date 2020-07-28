package Poligon;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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

public class EkranGry2Graczy extends JPanel {

	public long distance1;
	public long distance2;
		public Double tankAngle = -Math.PI / 2;
		public Double enemyAngle = Math.PI / 2;
		
		String blueTank = "src/main/resources/images/basic_tank_icon.png";
		String grayTank = "src/main/resources/images/gray_tank_icon.png";
		String redTank = "src/main/resources/images/red_tank_icon.png";
		
		String wall = "src/main/resources/images/protection_wall_icon_50px_50px.png";
		String block = "src/main/resources/images/indestructible_wall_icon_50px_50px.png";		
		String field = "src/main/resources/images/protection_barrier_icon_50px_50px.png";
		String plant = "src/main/resources/images/bush_field_bordered_icon_50px_50px.png";
		String barrier = "src/main/resources/images/protection_barrier_icon_50px_50px.png";
		
		String tankObject = "Poligon.ekranGryFull$ekranGry$loadTank";
		String enemyObject = "Poligon.ekranGryFull$ekranGry$enemyTank";
		String wallObject = "Poligon.ekranGryFull$ekranGry$loadWall";
		String fieldObject = "Poligon.ekranGryFull$ekranGry$loadField";
		String blockObject = "Poligon.ekranGryFull$ekranGry$loadBlock";
		String plantObject = "Poligon.ekranGryFull$ekranGry$loadGrass";
		String barrierObject = "Poligon.ekranGryFull$ekranGry$loadBorder";
		
		loadTank tank1 = new loadTank(25, 525, blueTank, tankAngle);
		loadTank tank2 = new loadTank(725, 525, redTank, tankAngle);
		loadTank eTank1 = new loadTank(250, 100, grayTank, enemyAngle);
		loadTank eTank2 = new loadTank(375, 100, grayTank, enemyAngle);
		loadTank eTank3 = new loadTank(500, 100, grayTank, enemyAngle);
		loadTank eTank4 = new loadTank(650, 0, grayTank, enemyAngle);
		
		ArrayList<loadObstacle> walls = new ArrayList<loadObstacle>();
		ArrayList<loadObstacle> fields = new ArrayList<loadObstacle>();
		ArrayList<loadObstacle> blocks = new ArrayList<loadObstacle>();
		ArrayList<loadObstacle> plants = new ArrayList<loadObstacle>();
		
		// adding obstacles	
		{
					blocks.add(new loadObstacle(50, 75,block));
					walls.add(new loadObstacle(50, 150,wall));
					walls.add(new loadObstacle(50, 200,wall));
					walls.add(new loadObstacle(50, 250,wall));
					walls.add(new loadObstacle(50, 350,wall));
					blocks.add(new loadObstacle(100, 75,block));
					walls.add(new loadObstacle(100, 100,wall));
					fields.add(new loadObstacle(100, 150,block));
					walls.add(new loadObstacle(100, 200,wall));
					fields.add(new loadObstacle(100, 250,field));
					walls.add(new loadObstacle(100, 300,wall));
					plants.add(new loadObstacle(100, 350,plant));
					plants.add(new loadObstacle(100, 400,plant));
					blocks.add(new loadObstacle(150, 75,block));
					walls.add(new loadObstacle(150, 100,wall));
					fields.add(new loadObstacle(150, 150,field));
					walls.add(new loadObstacle(150, 200,wall));
					fields.add(new loadObstacle(150, 250,field));
					walls.add(new loadObstacle(150, 300,wall));
					plants.add(new loadObstacle(150, 350,plant));
					plants.add(new loadObstacle(150, 400,plant));
					walls.add(new loadObstacle(200, 100,wall));
					walls.add(new loadObstacle(200, 150,wall));
					walls.add(new loadObstacle(200, 200,wall));
					walls.add(new loadObstacle(200, 250,wall));
					walls.add(new loadObstacle(200, 300,wall));
					plants.add(new loadObstacle(200, 350,plant));
					plants.add(new loadObstacle(200, 400,plant));
					walls.add(new loadObstacle(250, 150,wall));
					blocks.add(new loadObstacle(250, 200,block));
					walls.add(new loadObstacle(250, 250,wall));
					walls.add(new loadObstacle(250, 300,wall));
					plants.add(new loadObstacle(250, 350,plant));
					plants.add(new loadObstacle(250, 400,plant));
					walls.add(new loadObstacle(300, 75,wall));
					walls.add(new loadObstacle(300, 100,wall));
					walls.add(new loadObstacle(300, 150,wall));
					blocks.add(new loadObstacle(300, 200,block));
					walls.add(new loadObstacle(300, 250,wall));
					walls.add(new loadObstacle(300, 300,wall));
					walls.add(new loadObstacle(300, 350,wall));
					walls.add(new loadObstacle(300, 400,wall));
					walls.add(new loadObstacle(350, 150,wall));
					blocks.add(new loadObstacle(350, 200,block));
					walls.add(new loadObstacle(350, 250,wall));
					walls.add(new loadObstacle(350, 300,wall));
					walls.add(new loadObstacle(350, 350,wall));
					walls.add(new loadObstacle(350, 400,wall));
					walls.add(new loadObstacle(400, 150,wall));
					blocks.add(new loadObstacle(400, 200,block));
					walls.add(new loadObstacle(400, 250,wall));
					walls.add(new loadObstacle(400, 300,wall));
					walls.add(new loadObstacle(400, 350,wall));
					walls.add(new loadObstacle(400, 400,wall));
					walls.add(new loadObstacle(450, 75,wall));
					walls.add(new loadObstacle(450, 100,wall));
					walls.add(new loadObstacle(450, 150,wall));
					blocks.add(new loadObstacle(450, 200,block));
					walls.add(new loadObstacle(450, 250,wall));
					walls.add(new loadObstacle(450, 300,wall));
					walls.add(new loadObstacle(450, 350,wall));
					walls.add(new loadObstacle(450, 400,wall));
					walls.add(new loadObstacle(500, 150,wall));
					blocks.add(new loadObstacle(500, 200,block));
					walls.add(new loadObstacle(500, 250,wall));
					walls.add(new loadObstacle(500, 300,wall));
					plants.add(new loadObstacle(500, 350,plant));
					plants.add(new loadObstacle(500, 400,plant));
					walls.add(new loadObstacle(550, 100,wall));
					walls.add(new loadObstacle(550, 150,wall));
					walls.add(new loadObstacle(550, 200,wall));
					walls.add(new loadObstacle(550, 250,wall));
					walls.add(new loadObstacle(550, 300,wall));
					plants.add(new loadObstacle(550, 350,plant));
					plants.add(new loadObstacle(550, 400,plant));
					blocks.add(new loadObstacle(600, 75,block));
					walls.add(new loadObstacle(600, 100,wall));
					fields.add(new loadObstacle(600, 150,field));
					walls.add(new loadObstacle(600, 200,wall));
					fields.add(new loadObstacle(600, 250,field));
					walls.add(new loadObstacle(600, 300,wall));
					plants.add(new loadObstacle(600, 350,plant));
					plants.add(new loadObstacle(600, 400,plant));
					blocks.add(new loadObstacle(650, 75,block));
					walls.add(new loadObstacle(650, 100,wall));
					fields.add(new loadObstacle(650, 150,field));
					walls.add(new loadObstacle(650, 200,wall));
					fields.add(new loadObstacle(650, 250,field));
					walls.add(new loadObstacle(650, 300,wall));
					plants.add(new loadObstacle(650, 350,plant));
					plants.add(new loadObstacle(650, 400,plant));
					blocks.add(new loadObstacle(700, 75,block));
					walls.add(new loadObstacle(700, 150,wall));
					walls.add(new loadObstacle(700, 200,wall));
					walls.add(new loadObstacle(700, 250,wall));
					walls.add(new loadObstacle(700, 350,wall));
					
		}			
		int bulletPlayerOne = 300;
		int bulletCounterOne = bulletPlayerOne-1;
		int bulletPlayerTwo = 300;
		int bulletCounterTwo = bulletPlayerTwo-1;
		
		ArrayList<Double> bulletAngles = new ArrayList<Double>();{
		for(int i=0;i<bulletPlayerOne;i++) 
		if (i%2==0)
		bulletAngles.add((double) 0);
		else
		bulletAngles.add(Math.PI/3);}
		
		
		
		
		ArrayList<loadBullet> bulletsPlayerOne = new ArrayList<loadBullet>();
		ArrayList<loadBullet> bulletsPlayerTwo = new ArrayList<loadBullet>(); 
		
		ArrayList<bulletMove> bulletMoves = new ArrayList<bulletMove>(); 
		
		
		//public Double bulletAngle = (double) 0;
		//public TimerTask bulletMove1;

		public EkranGry2Graczy() {
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
			JPanel playerTwo = new JPanel();
				JLabel scorePlayerTwo = new JLabel("TEXT");
				scorePlayerTwo.setBounds(20, 0, 130, 50);
				scorePlayerTwo.setText("   PLAYER 2   ");
				JLabel lifeOnePlayerTwo = new JLabel(new ImageIcon("src/main/resources/images/tank_life_icon_red_15x15.png"));
				lifeOnePlayerTwo.setBounds(0, 1, 20, 16);
				JLabel lifeTwoPlayerTwo = new JLabel(new ImageIcon("src/main/resources/images/tank_life_icon_red_15x15.png"));
				lifeTwoPlayerTwo.setBounds(0, 17, 20, 16);
				JLabel lifeThreePlayerTwo = new JLabel(new ImageIcon("src/main/resources/images/tank_life_icon_red_15x15.png"));
				lifeThreePlayerTwo.setBounds(0, 33, 20, 16);
			
			playerOne.setLayout(null);
			playerOne.add(scorePlayerOne);
			playerOne.add(lifeOnePlayerOne);
			playerOne.add(lifeTwoPlayerOne);
			playerOne.add(lifeThreePlayerOne);
			playerOne.setBounds(0, 0, 150, 50);
			playerOne.setBackground(Color.getHSBColor(0.4f, 0.4f, 0.5f));
			playerOne.setOpaque(true);
			add(playerOne);

			
			playerTwo.setLayout(null);
			playerTwo.add(scorePlayerTwo);
			playerTwo.add(lifeOnePlayerTwo);
			playerTwo.add(lifeTwoPlayerTwo);
			playerTwo.add(lifeThreePlayerTwo);
			playerTwo.setBounds(650, 0, 150, 50);
			playerTwo.setBackground(Color.ORANGE);
			playerTwo.setOpaque(true);
			add(playerTwo);
			
			JButton backButton = new JButton("powrót");
			backButton.setBounds(325, 0, 150, 50);
			backButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent a) {
					setVisible(false);
				}

			});
			add(backButton);

			JButton pauseButton = new JButton("pauza");
			pauseButton.setBounds(175, 0, 150, 50);
			pauseButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent a) {

				}

			});
			add(pauseButton);

			JButton soundButton = new JButton("sound on/off");
			soundButton.setBounds(475, 0, 150, 50);
			soundButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent a) {

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
			
			

			
			for (int i = 0; i < blocks.size(); i++)
				add(blocks.get(i));
			for (int i = 0; i < walls.size(); i++)
				add(walls.get(i));
			for (int i = 0; i < fields.size(); i++)
				add(fields.get(i));
			for (int i = 0; i < plants.size(); i++)
				add(plants.get(i));
			
			add(tank1);
			add(tank2);
			add(eTank1);
			add(eTank2);
			add(eTank3);
			//add(eTank4);
			playerOneMomement p1 = new playerOneMomement();
			playerTwoMovement p2 = new playerTwoMovement();	
			
			for (int i=0;i<bulletPlayerOne;i++) {
				bulletsPlayerOne.add(new loadBullet(tank1.getX()+21,tank1.getY()-20));
				add(bulletsPlayerOne.get(i));
				bulletsPlayerOne.get(i).setVisible(false);
				bulletMoves.add(new bulletMove(bulletsPlayerOne.get(i)));
				new Timer().scheduleAtFixedRate(bulletMoves.get(i), 0, 50);
				
				
			}
			
			for (int i=0;i<bulletPlayerTwo;i++) {
				bulletsPlayerTwo.add(new loadBullet(tank1.getX()+21,tank1.getY()-20));
				add(bulletsPlayerTwo.get(i));
				bulletsPlayerTwo.get(i).setVisible(false);
				//bulletMoves.add(new bulletMove(bulletsPlayerTwo.get(i)));
				new Timer().scheduleAtFixedRate(new bulletMove(bulletsPlayerTwo.get(i)), 0, 50);
			}
			
//			for(int i=0;i<bulletPlayerOne;i++) {
//				bulletAngles.add((double) 0);
//			}
			
			addKeyListener(p1);
			addKeyListener(p2);
			
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
						g2.rotate(bulletAngles.get(bulletCounterOne), bulletIcon.getIconWidth() / 2, bulletIcon.getIconHeight() / 2);
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
					System.out.println("Ruch o pixel w górê.");
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
					System.out.println("Ruch o pixel w dó³.");
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
						bulletsPlayerOne.get(bulletCounterOne).setBounds(tank1.getX()+21, tank1.getY()-20, 8, 20);
						bulletsPlayerOne.get(bulletCounterOne).repaint();
						bulletsPlayerOne.get(bulletCounterOne).setVisible(true);
						bulletCounterOne--;
						//System.out.println(bulletsPlayerOne.get(bulletCounterOne).bulletAngle);
						System.out.println("Zosta³o " + bulletCounterOne + " pocisków!");
					}
					else if (tankAngle == (double) 0) {
						bulletsPlayerOne.get(bulletCounterOne).setBounds(tank1.getX()+70, tank1.getY()+21, 8, 20);
						bulletsPlayerOne.get(bulletCounterOne).repaint();
						bulletsPlayerOne.get(bulletCounterOne).setVisible(true);
						bulletCounterOne--;
						//System.out.println(bulletsPlayerOne.get(bulletCounterOne).bulletAngle);
						System.out.println("Zosta³o " + bulletCounterOne + " pocisków!");
					}
					else if (tankAngle == Math.PI/2) {
						bulletsPlayerOne.get(bulletCounterOne).setBounds(tank1.getX()+29, tank1.getY()+70, 8, 20);
						bulletsPlayerOne.get(bulletCounterOne).repaint();
						bulletsPlayerOne.get(bulletCounterOne).setVisible(true);
						bulletCounterOne--;
						//System.out.println(bulletsPlayerOne.get(bulletCounterOne).bulletAngle);
						System.out.println("Zosta³o " + bulletCounterOne + " pocisków!");
					}
					else if (tankAngle == Math.PI) {
						bulletsPlayerOne.get(bulletCounterOne).setBounds(tank1.getX()-20, tank1.getY()+29, 8, 20);
						bulletsPlayerOne.get(bulletCounterOne).repaint();
						bulletsPlayerOne.get(bulletCounterOne).setVisible(true);
						bulletCounterOne--;
						//System.out.println(bulletsPlayerOne.get(bulletCounterOne).bulletAngle);
						System.out.println("Zosta³o " + bulletCounterOne + " pocisków!");
					}

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
						if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject)
							counter++;
					}
					if (counter > 0)
						tank2.setLocation(tank2.getX(), tank2.getY());
					else
						tank2.setLocation(tank2.getX(), tank2.getY() - 2);
					distance2++;
					System.out.println("Ruch o pixel w górê.");
				}

				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (tankAngle != (Math.PI / 2)) {
						tankAngle = Math.PI / 2;
						tank2.repaint();
					}
					int counter = 0;
					for (int i = 0; i <= 49; i++) {
						String objectClass = getComponentAt(tank2.getX() + i, tank2.getY() + 51).getClass().getName();
						if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject)
							counter++;
					}
					if (counter > 0)
						tank2.setLocation(tank2.getX(), tank2.getY());
					else
						tank2.setLocation(tank2.getX(), tank2.getY() + 2);
					distance2++;
					System.out.println("Ruch o pixel w dó³.");
				}

				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (tankAngle != Math.PI) {
						tankAngle = Math.PI;
						tank2.repaint();
					}
					int counter = 0;
					for (int i = 0; i <= 49; i++) {
						String objectClass = getComponentAt(tank2.getX() - 1, tank2.getY() + i).getClass().getName();
						if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject)
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
						if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject)
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

			loadTank eTank1;
			int timer = 0;
			
			public enemyAutoMove(loadTank eTank1) {
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
			
			//loadBullet bullet;
			int timer = 0;
			loadBullet bullet; 
			
			private bulletMove(loadBullet bullet) {
				this.bullet = bullet;
			}
			
//			public void setAngle() {
//				
//				if (tankAngle == - Math.PI/2)
//					bullet.bulletAngle = (double) 0;
//				if (tankAngle == (double) 0)
//					bullet.bulletAngle = Math.PI/2;
//				if (tankAngle == Math.PI/2)
//					bullet.bulletAngle = Math.PI;
//				if(tankAngle == Math.PI)
//				bullet.bulletAngle = - Math.PI/2;
//			}
			
			
//			public void moveUp() {
//				
//			}
//
//			public void moveDown() {
//
//			}
//
//			public void moveLeft() {
//	
//			}
//
//			public void moveRight() {
//	
//			}
			
			@Override
			public void run() {
				timer++;
				if (tankAngle == (double) 0) {
					//bullet.bulletAngle = Math.PI/2;
					bullet.setLocation(bullet.getX()+4, bullet.getY());
				}
//				if (tankAngle == Math.PI/2) {
//					bullet.bulletAngle = Math.PI;
//					bullet.setLocation(bullet.getX(), bullet.getY()+4);
//				}
//				if (tankAngle == Math.PI) {
//					bullet.bulletAngle = -Math.PI/2;
//					bullet.setLocation(bullet.getX()-4, bullet.getY());
//				}
//				if (tankAngle == -Math.PI/2) {
//					bullet.bulletAngle = (double) 0;
//					bullet.setLocation(bullet.getX(), bullet.getY()-4);
//				}
				
//				if (bullet.isVisible()){
//					String objectClass = getComponentAt(bullet.getX(), bullet.getY()-1).getClass().getName();		
//					if (objectClass == tankObject || objectClass == enemyObject || objectClass == fieldObject || objectClass == wallObject || objectClass == blockObject || objectClass == barrierObject) {
//						bullet.removeAll();
//					}	
//				}
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
