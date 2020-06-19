package Poligon;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;


public class Poligon extends JPanel {

	public Poligon() {

		Action actionW = new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("W is pressed.");
			}
		};
		
		Action actionS = new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("S is pressed.");
			}
		};
		
		Action actionA = new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("A is pressed.");
			}
		};
		
		Action actionD = new AbstractAction() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("D is pressed.");
			}
		};

		JLabel tank = new JLabel(new ImageIcon("src/main/resources/basic_tank_icon.png"));
		tank.getInputMap().put(KeyStroke.getKeyStroke("W"), "actionW");
		tank.getActionMap().put("actionW", actionW);
		tank.getInputMap().put(KeyStroke.getKeyStroke("S"), "actionS");
		tank.getActionMap().put("actionS", actionS);
		tank.getInputMap().put(KeyStroke.getKeyStroke("A"), "actionA");
		tank.getActionMap().put("actionA", actionA);
		tank.getInputMap().put(KeyStroke.getKeyStroke("D"), "actionD");
		tank.getActionMap().put("actionD", actionD);
		tank.requestFocusInWindow();
		add(tank);

	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(500, 500);
	}

}
