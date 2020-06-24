package Poligon;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ekranGryFull extends JPanel {

	
	public ekranGryFull () {
		
		ekranGry game = new ekranGry();
		game.setPreferredSize(new Dimension(500,500));
		add(game);
		
		ekranGryMenu menu = new ekranGryMenu();
		menu.setPreferredSize(new Dimension(500,300));
		menu.setLocation(0, 500);
		add(menu);
	}
	
}
