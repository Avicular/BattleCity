package BattleCity;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws IOException {
		
//		File in= new File("C:\\Users\\jaroo\\eclipse-workspace\\cschoolzdalnie\\src\\com\\gui2\\daneLogowania.txt");
//		in.createNewFile();
		PrintWriter output = new PrintWriter("C:\\Users\\jaroo\\eclipse-workspace\\cschoolzdalnie\\src\\com\\gui2\\daneLogowania.txt");
		ImageIcon imgicon = new ImageIcon(
				"C:\\Users\\jaroo\\eclipse-workspace\\BattleCity\\12345.png");

		
		
		JFrame window = new JFrame("Ekran Glowny");
		EkranGlowny panel = new EkranGlowny();
		window.add(panel);
		window.setLocation(400,  200);
		window.setIconImage(imgicon.getImage());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.pack();
		
	}
}