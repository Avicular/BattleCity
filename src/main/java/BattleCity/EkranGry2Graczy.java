package BattleCity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tankModel.PoligonTwoPlayers;

public class EkranGry2Graczy {
	
	public String filePath;
	static JFrame window;
	ImageIcon appIcon = new ImageIcon("src/main/resources/images/12345.png");
	
	public EkranGry2Graczy(String filePath) throws IOException{
	window = new JFrame("2 PLAYERS");
	PoligonTwoPlayers newTwoPlayersGame = new PoligonTwoPlayers(filePath);
	window.setIconImage(appIcon.getImage());
	window.setLayout(new BorderLayout());
	window.getContentPane().add(newTwoPlayersGame);
	window.setPreferredSize(new Dimension(806,628));
	window.setLocation(300, 50);
	window.setVisible(true);
	window.pack();
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setResizable(false);

	}
	public static void setVisible () {
		window.setVisible(false);
	}
}
