package tankModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

public class Main {
public static void main(String[] args) throws IOException {
				
		JFrame okno = new JFrame();
		
//		Poligon gra1 = new Poligon("src/main/resources/maps/map1.txt");
		PoligonTwoPlayers gra1 = new PoligonTwoPlayers("src/main/resources/maps/map1.txt");
		okno.setLayout(new BorderLayout());	
		okno.getContentPane().add(gra1);
		okno.setTitle("Okno Gry");		
		okno.setPreferredSize(new Dimension(816,639));
		
		okno.setLocation(2000, 50);
		okno.setVisible(true);
		okno.pack();
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
