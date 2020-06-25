package Poligon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class ekranGry extends JPanel{
	
	
	loadTank tank1 = new loadTank(0, 0);
	public double angle = - Math.PI/2;
	public long distance1;
	
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
		
		setBackground(Color.ORANGE);
		
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
	    }
	}
}
	