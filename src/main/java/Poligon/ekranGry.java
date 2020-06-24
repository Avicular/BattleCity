package Poligon;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class ekranGry extends JPanel{
		
	loadTank tank1 = new loadTank(0, 0);
	
	public ekranGry() {
		setLayout(null);
			
		add(tank1);
	
		for (int a=1;a<=10;a++) {
			if (a%2 != 0)
			for (int i=1;i<=7;i++) {
				add(new loadWall(i*50,a*50));
			}
		}
		
		Action actionW = new AbstractAction() {
			public void actionPerformed(ActionEvent a) {
				tank1.setLocation(tank1.getX(),tank1.getY()-2);
				System.out.println("Ruch o pixel w górê.");
			}
		};
		
		Action actionS = new AbstractAction() {
			public void actionPerformed(ActionEvent a) {
				tank1.setLocation(tank1.getX(),tank1.getY()+2);
				System.out.println("Ruch o pixel w dó³.");
			}
		};
		
		Action actionA = new AbstractAction() {
			public void actionPerformed(ActionEvent a) {
				tank1.setLocation(tank1.getX()-2,tank1.getY());
				System.out.println("Ruch o pixel w lewo.");
			}
		};
		
		Action actionD = new AbstractAction() {
			public void actionPerformed(ActionEvent a) {
				tank1.setLocation(tank1.getX()+2,tank1.getY());
				System.out.println("Ruch o pixel w prawo.");
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
		tank1.requestFocusInWindow();
		
		setBackground(Color.ORANGE);
		
	}
	
	public class loadTank extends JLabel {
		
		int x;
		int y;
		
	    public loadTank(int x, int y) {
	    setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
	    new JLabel();
	    setBounds(this.x=x, this.y=y, 50, 50);
	    setBackground(Color.BLACK);
	    add(new JLabel(new ImageIcon("src/main/resources/basic_tank_icon.png")));
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
	