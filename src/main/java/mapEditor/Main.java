package mapEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

import tankModel.Poligon;

public class Main {
	public static void main(String[] args) throws IOException {
	JFrame oknoEdytora = new JFrame();
	
	Edytor edytor = new Edytor("src/main/resources/maps/map3.txt");
	oknoEdytora.setLayout(new BorderLayout());	
	oknoEdytora.getContentPane().add(edytor);
	oknoEdytora.setTitle("Okno Gry");		
	oknoEdytora.setPreferredSize(new Dimension(816,639));
	
	oknoEdytora.setLocation(2000, 50);
	oknoEdytora.setVisible(true);
	oknoEdytora.pack();
	oknoEdytora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
