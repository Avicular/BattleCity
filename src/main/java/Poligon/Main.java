package Poligon;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		
		JFrame poligonFrame = new JFrame("Poligon");
		Poligon poligon = new Poligon();
		poligonFrame.add(poligon);			
		
		poligonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		poligonFrame.pack();
		poligonFrame.setVisible(true);
		
		
	}
}
