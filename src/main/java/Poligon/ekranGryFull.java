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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ekranGryFull extends JPanel {
	
	public long distance1;
	public long distance2;
	
	public ekranGryFull () {
		
		ekranGry game = new ekranGry();
		game.setPreferredSize(new Dimension(800,450));
		add(game);
		
		ekranGryMenu menu = new ekranGryMenu();
		menu.setPreferredSize(new Dimension(800,150));
		menu.setLocation(0, 450);
		add(menu);
	}
	
	public class ekranGryMenu extends JPanel {	
		
		public ekranGryMenu () {
			setLayout(null);
			
			JLabel playerOne = new JLabel("PLAYER 1");
			playerOne.setBounds(0,0,150,150);
			playerOne.setBackground(Color.BLUE);
			playerOne.setOpaque(true);
			add(playerOne);
			
			JLabel playerTwo = new JLabel("PLAYER 2");
			playerTwo.setBounds(650,0,150,150);
			playerTwo.setBackground(Color.RED);
			playerTwo.setOpaque(true);
			add(playerTwo);
			
			JLabel scorePlayerOne = new JLabel("TEXT");
			scorePlayerOne.setBounds(150,50,200,100);
			scorePlayerOne.setBackground(Color.DARK_GRAY);
			scorePlayerOne.setOpaque(true);
			add(scorePlayerOne);
			
			JLabel scorePlayerTwo = new JLabel("TEXT");
			scorePlayerTwo.setBounds(450,50,200,100);
			scorePlayerTwo.setBackground(Color.DARK_GRAY);
			scorePlayerTwo.setOpaque(true);
			add(scorePlayerTwo);
			
			JPanel lifePlayerOne = new JPanel();
				JLabel tankLifeOneOne = new JLabel(new ImageIcon("src/main/resources/tank_life_icon_red_red_50x50.png"));
				JLabel tankLifeOneTwo= new JLabel(new ImageIcon("src/main/resources/tank_life_icon_red_red_50x50.png"));
				JLabel tankLifeOneThree = new JLabel(new ImageIcon("src/main/resources/tank_life_icon_red_empty_50x50.png"));
			lifePlayerOne.add(tankLifeOneOne);
			lifePlayerOne.add(tankLifeOneTwo);
			lifePlayerOne.add(tankLifeOneThree);
			lifePlayerOne.setBounds(150,0,200,50);
			lifePlayerOne.setBackground(Color.WHITE);
			lifePlayerOne.setOpaque(true);
			add(lifePlayerOne);
			
			JPanel lifePlayerTwo = new JPanel();
				JLabel tankLifeTwoOne = new JLabel(new ImageIcon("src/main/resources/tank_life_icon_red_red_50x50.png"));
				JLabel tankLifeTwoTwo= new JLabel(new ImageIcon("src/main/resources/tank_life_icon_red_red_50x50.png"));
				JLabel tankLifeTwoThree = new JLabel(new ImageIcon("src/main/resources/tank_life_icon_red_empty_50x50.png"));
			lifePlayerTwo.add(tankLifeTwoOne);
			lifePlayerTwo.add(tankLifeTwoTwo);
			lifePlayerTwo.add(tankLifeTwoThree);
			lifePlayerTwo.setBounds(450,0,200,50);
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
	
	public class ekranGry extends JPanel{
		
		String blueTank = "src/main/resources/basic_tank_icon.png";
		String grayTank = "src/main/resources/gray_tank_icon.png";
		String redTank = "src/main/resources/red_tank_icon.png";
		
		loadTank tank1 = new loadTank(0, 400, grayTank);
		loadTank tank2 = new loadTank(750, 400, redTank);
		
		ArrayList<loadWall> walls = new ArrayList<loadWall>();
		ArrayList<loadField> fields = new ArrayList<loadField>();
		
		public double angle = - Math.PI/2;
		
		public boolean isBulletproof(boolean bulletproof) {
			return bulletproof;
		}
		
		
		public ekranGry()  {
			setLayout(null);			
			add(tank1);
			add(tank2);
			setFocusable(true);
			
// add specific obstacles			
			walls.add(new loadWall(0,100));
			walls.add(new loadWall(0,250));	
			
			walls.add(new loadWall(50,50));
			walls.add(new loadWall(50,100));
			walls.add(new loadWall(50,150));
			walls.add(new loadWall(50,250));
			walls.add(new loadWall(50,300));
			walls.add(new loadWall(50,350));
			
			walls.add(new loadWall(100,50));
			walls.add(new loadWall(100,250));
			
			walls.add(new loadWall(150,50));
			walls.add(new loadWall(150,100));
			walls.add(new loadWall(150,250));
			walls.add(new loadWall(150,350));
			
			walls.add(new loadWall(200,250));
			walls.add(new loadWall(250,250));
			
			walls.add(new loadWall(350,200));
			walls.add(new loadWall(350,250));
			
			walls.add(new loadWall(400,250));
			
			for (int i=0; i<walls.size(); i++)
			add(walls.get(i));

// add specific fields
			fields.add(new loadField(0,150));
			fields.add(new loadField(100,350));			
			fields.add(new loadField(200,350));
			fields.add(new loadField(300,250));
			for (int i=0; i<fields.size(); i++)
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
			
		}
		
		public class loadTank extends JLabel {
			
			int x;
			int y;
			String tankVersion;
			
		    public loadTank(int x, int y, String tankVersion) {
		    
		    setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		    setBounds(this.x=x, this.y=y, 50, 50);
		    ImageIcon tankIcon = new ImageIcon(this.tankVersion=tankVersion);
		    add(new JLabel(tankIcon) {
		    	@Override
	            protected void paintComponent(Graphics g) {
	                Graphics2D g2 = (Graphics2D) g;
	                g2.rotate(angle, tankIcon.getIconWidth() / 2, tankIcon.getIconHeight() / 2);
	                g2.drawImage(tankIcon.getImage(), 0, 0, null);
	            }
		    });
		    
		    System.out.println("player's tank added");
		    System.out.println("tank bullet resistance: " + isBulletproof(false) );
		    System.out.println("tank hitpoints:3");
		    }
		}
		
		public class loadWall extends JLabel {
			
			int x;
			int y;
			
		    public loadWall(int x, int y) {
		    setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		    new JLabel();
		    setBounds(this.x=x, this.y=y, 50, 50);
		    //setBackground(Color.BLACK);
		    add(new JLabel(new ImageIcon("src/main/resources/protection_wall_icon_50px_50px_blackborder.png")));
		    }
		}
		
		public class loadField extends JLabel {
			
			int x;
			int y;
			
		    public loadField(int x, int y) {
		    setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		    new JLabel();
		    setBounds(this.x=x, this.y=y, 50, 50);
		    //setBackground(Color.BLACK);
		    add(new JLabel(new ImageIcon("src/main/resources/protection_field_icon_50px_50px.png")));
		    }
		}
		
		public class playerOneMomement implements KeyListener{

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if(e.getKeyCode()== KeyEvent.VK_W) {
						if (angle != -(Math.PI/2)) {
							angle = -Math.PI/2;
							tank1.repaint();
						}
						int counter = 0;
						for (int i=0;i<=49;i++) {
						String objectClass = getComponentAt(tank1.getX()+i,tank1.getY()-1).getClass().getName();
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
						counter++;
						}
						if (counter>0)
						tank1.setLocation(tank1.getX(),tank1.getY());
						else
						tank1.setLocation(tank1.getX(),tank1.getY()-2);
						distance1++;
						System.out.println("Ruch o pixel w g�r�.");
					}
				
				if(e.getKeyCode()== KeyEvent.VK_S) {
						if (angle != (Math.PI/2)) {
							angle = Math.PI/2;
							tank1.repaint();
						}
						int counter = 0;
						for (int i=0;i<=49;i++) {
						String objectClass = getComponentAt(tank1.getX()+i,tank1.getY()+51).getClass().getName();
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
						counter++;
						}
						if (counter>0)
						tank1.setLocation(tank1.getX(),tank1.getY());
						else
						tank1.setLocation(tank1.getX(),tank1.getY()+2);
						distance1++;
						System.out.println("Ruch o pixel w d�.");
					}
				
				if(e.getKeyCode()== KeyEvent.VK_A) {
						if (angle != Math.PI) {
							angle = Math.PI;
							tank1.repaint();
						}
						int counter = 0;
						for (int i=0;i<=49;i++) {
						String objectClass = getComponentAt(tank1.getX()-1,tank1.getY()+i).getClass().getName();
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
						counter++;
						}
						if (counter>0)
						tank1.setLocation(tank1.getX(),tank1.getY());
						else
						tank1.setLocation(tank1.getX()-2,tank1.getY());
						distance1++;
						System.out.println("Ruch o pixel w lewo.");
					}
				
				if(e.getKeyCode()== KeyEvent.VK_D) {
						if (angle != 0) {
							angle = 0;
							tank1.repaint();
						}
						int counter = 0;
						for (int i=0;i<=49;i++) {
						String objectClass = getComponentAt(tank1.getX()+51,tank1.getY()+i).getClass().getName();
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
						counter++;
						}
						if (counter>0)
						tank1.setLocation(tank1.getX(),tank1.getY());
						else
						tank1.setLocation(tank1.getX()+2,tank1.getY());
						distance1++;
						System.out.println("Ruch o pixel w prawo.");
					}
				
				
				if(e.getKeyCode()== KeyEvent.VK_SPACE) {
						System.out.println(tank1.getLocation());
						System.out.println(getComponentAt(50,350).getClass().getName());
						System.out.println("Player's 1 tank distance: " + distance1*2 + " pixels.");
						
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
				if(e.getKeyCode()== KeyEvent.VK_UP) {
						if (angle != -(Math.PI/2)) {
							angle = -Math.PI/2;
							tank2.repaint();
						}
						int counter = 0;
						for (int i=0;i<=49;i++) {
						String objectClass = getComponentAt(tank2.getX()+i,tank2.getY()-1).getClass().getName();
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
						counter++;
						}
						if (counter>0)
						tank2.setLocation(tank2.getX(),tank2.getY());
						else
						tank2.setLocation(tank2.getX(),tank2.getY()-2);
						distance2++;
						System.out.println("Ruch o pixel w g�r�.");
					}
				
				if(e.getKeyCode()== KeyEvent.VK_DOWN) {
						if (angle != (Math.PI/2)) {
							angle = Math.PI/2;
							tank2.repaint();
						}
						int counter = 0;
						for (int i=0;i<=49;i++) {
						String objectClass = getComponentAt(tank2.getX()+i,tank2.getY()+51).getClass().getName();
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
						counter++;
						}
						if (counter>0)
						tank2.setLocation(tank2.getX(),tank2.getY());
						else
						tank2.setLocation(tank2.getX(),tank2.getY()+2);
						distance2++;
						System.out.println("Ruch o pixel w d�.");
					}
				
				if(e.getKeyCode()== KeyEvent.VK_LEFT) {
						if (angle != Math.PI) {
							angle = Math.PI;
							tank2.repaint();
						}
						int counter = 0;
						for (int i=0;i<=49;i++) {
						String objectClass = getComponentAt(tank2.getX()-1,tank2.getY()+i).getClass().getName();
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
						counter++;
						}
						if (counter>0)
						tank2.setLocation(tank2.getX(),tank2.getY());
						else
						tank2.setLocation(tank2.getX()-2,tank2.getY());
						distance2++;
						System.out.println("Ruch o pixel w lewo.");
					}
				
				if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
						if (angle != 0) {
							angle = 0;
							tank2.repaint();
						}
						int counter = 0;
						for (int i=0;i<=49;i++) {
						String objectClass = getComponentAt(tank2.getX()+51,tank2.getY()+i).getClass().getName();
						if (objectClass == "Poligon.ekranGryFull$ekranGry$loadWall")
						counter++;
						}
						if (counter>0)
						tank2.setLocation(tank2.getX(),tank2.getY());
						else
						tank2.setLocation(tank2.getX()+2,tank2.getY());
						distance2++;
						System.out.println("Ruch o pixel w prawo.");
					}
				
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
						System.out.println("Player's 2 tank distance: " + distance2*2 + " pixels.");				
					}	
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
		
			
	}
	
}
