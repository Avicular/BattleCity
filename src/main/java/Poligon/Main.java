package Poligon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Main {	
	
	
	public static void main(String[] args) {
		
		JFrame okno = new JFrame();
		
		ekranGryFull gra1 = new ekranGryFull();
		okno.setLayout(new BorderLayout());
		gra1.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));		
		okno.getContentPane().add(gra1);
		okno.setTitle("Okno Gry");		
		okno.setPreferredSize(new Dimension(816,600));
		
		okno.setLocation(2000, 50);
		okno.setVisible(true);
		okno.pack();
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
