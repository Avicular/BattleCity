package Poligon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Main {	
	
	
	public static void main(String[] args) {
		
		//new EkranGry2Graczy();
		
		JFrame okno = new JFrame();
		
		EkranGry2Graczy gra1 = new EkranGry2Graczy();
		okno.setLayout(new BorderLayout());	
		okno.getContentPane().add(gra1);
		okno.setTitle("Okno Gry");		
		okno.setPreferredSize(new Dimension(816,639));
		
		okno.setLocation(300, 50);
		okno.setVisible(true);
		okno.pack();
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
