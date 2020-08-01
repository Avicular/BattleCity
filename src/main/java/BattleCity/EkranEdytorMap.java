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

import mapEditor.Edytor;
import tankModel.Poligon;

public class EkranEdytorMap {

	JFrame window;
	Font font = new Font("Visitor TT1 BRK", Font.BOLD, 28);
	ImageIcon appIcon = new ImageIcon("src/main/resources/images/12345.png");
	
	public EkranEdytorMap() throws IOException {
		window = new JFrame("MAP EDITOR");
		Edytor mapEditor = new Edytor();
		window.setIconImage(appIcon.getImage());
		window.setLayout(new BorderLayout());
		window.getContentPane().add(mapEditor);
		window.setPreferredSize(new Dimension(806,628));
		window.setLocation(300, 50);
		window.setVisible(true);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
	}
}