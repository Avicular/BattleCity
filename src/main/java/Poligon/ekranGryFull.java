package Poligon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class ekranGryFull extends JPanel {

	
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
			
			
			
			JButton backButton = new JButton("powrót");
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
		
		
		loadTank tank1 = new loadTank(0, 0);
		public double angle = - Math.PI/2;
		public long distance1;
		String distance;
		
		public boolean isBulletproof(boolean bulletproof) {
			return bulletproof;
		}
		
		public String getDistance() {
			return ""+distance1;
		}
		
		public ekranGry() {
			setLayout(null);			
			add(tank1);
		
			for (int a=1;a<=8;a++) {
				if (a%2 != 0)
				for (int i=1;i<=14;i++) {
					add(new loadWall(i*50,a*50));
				}
			}
			
			Action actionW = new AbstractAction() {
				public void actionPerformed(ActionEvent a) {
					if (angle != -(Math.PI/2)) {
						angle = -Math.PI/2;
						tank1.repaint();
					}
					tank1.setLocation(tank1.getX(),tank1.getY()-2);
					distance1++;
					System.out.println("Ruch o pixel w górê.");
				}
			};
			
			Action actionS = new AbstractAction() {
				public void actionPerformed(ActionEvent a) {
					if (angle != (Math.PI/2)) {
						angle = Math.PI/2;
						tank1.repaint();
					}
					tank1.setLocation(tank1.getX(),tank1.getY()+2);
					distance1++;
					System.out.println("Ruch o pixel w dó³.");
				}
			};
			
			Action actionA = new AbstractAction() {
				public void actionPerformed(ActionEvent a) {
					if (angle != Math.PI) {
						angle = Math.PI;
						tank1.repaint();
					}
					tank1.setLocation(tank1.getX()-2,tank1.getY());
					distance1++;
					System.out.println("Ruch o pixel w lewo.");
				}
			};
			
			Action actionD = new AbstractAction() {
				public void actionPerformed(ActionEvent a) {
					if (angle != 0) {
						angle = 0;
						tank1.repaint();
					}
					tank1.setLocation(tank1.getX()+2,tank1.getY());
					distance1++;
					System.out.println("Ruch o pixel w prawo.");
				}
			};
			
			Action actionSPACE = new AbstractAction() {
				public void actionPerformed(ActionEvent a) {
					System.out.println(distance1 + " pixeli");				
				}
			};
			
			tank1.getInputMap().put(KeyStroke.getKeyStroke("W"), "actionW");
			tank1.getActionMap().put("actionW", actionW);
			tank1.requestFocusInWindow();
			tank1.getInputMap().put(KeyStroke.getKeyStroke("S"), "actionS");
			tank1.getActionMap().put("actionS", actionS);
			tank1.requestFocusInWindow();
			tank1.getInputMap().put(KeyStroke.getKeyStroke("A"), "actionA");
			tank1.getActionMap().put("actionA", actionA);
			tank1.requestFocusInWindow();
			tank1.getInputMap().put(KeyStroke.getKeyStroke("D"), "actionD");
			tank1.getActionMap().put("actionD", actionD);
			tank1.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "actionSPACE");
			tank1.getActionMap().put("actionSPACE", actionSPACE);
			tank1.requestFocusInWindow();
			
			setBackground(Color.DARK_GRAY);
			
		}
		
		public class loadTank extends JLabel {
			
			int x;
			int y;
			
		    public loadTank(int x, int y) {
		    
		    setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		    setBounds(this.x=x, this.y=y, 50, 50);
		    ImageIcon tankIcon = new ImageIcon("src/main/resources/basic_tank_icon.png");
		    add(new JLabel(tankIcon) {
		    	@Override
	            protected void paintComponent(Graphics g) {
	                Graphics2D g2 = (Graphics2D) g;
	                g2.rotate(angle, tankIcon.getIconWidth() / 2, tankIcon.getIconHeight() / 2);
	                g2.drawImage(tankIcon.getImage(), 0, 0, null);
	            }
		    });
		    
		    System.out.println("dodano czo³g dla gracza nr 1");
		    System.out.println("czo³g resistance: " + isBulletproof(false) );
		    }
		}
		
		public class loadWall extends JLabel {
			
			int x;
			int y;
			
		    public loadWall(int x, int y) {
		    setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		    new JLabel();
		    setBounds(this.x=x, this.y=y, 50, 50);
		    setBackground(Color.BLACK);
		    add(new JLabel(new ImageIcon("src/main/resources/wall_icon.png")));
		    //System.out.println("dodano mur");
		    //System.out.println("mur resistance: " + isBulletproof(false) );
		    }
		}
	}
}
