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

import tankModel.Poligon;

public class EkranGry1Gracz {
	
	public String filePath;
	static JFrame window;
	ImageIcon appIcon = new ImageIcon("src/main/resources/images/12345.png");
	public EkranGry1Gracz(String filePath) throws IOException {
		this.filePath = filePath;
		window = new JFrame("1 PLAYER");
		Poligon newOnePlayerGame = new Poligon(filePath);
		window.setIconImage(appIcon.getImage());
		window.setLayout(new BorderLayout());
		window.getContentPane().add(newOnePlayerGame);
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
