package BattleCity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameContent.twoPlayersGame;

public class EkranGry2Graczy {
	
//	Container con;
//	JButton buttonWroc, buttonMuzyka;
//	String clickSound, backgroundMusic, muzykaOnOff;
//	ImageIcon music = new ImageIcon("src/main/resources/images/music.jpg");
//	ImageIcon musicOff = new ImageIcon("src/main/resources/images/musicOff.jpg");
//	Font font = new Font("Visitor TT1 BRK", Font.BOLD, 28);
	
	public EkranGry2Graczy(){
	
	
	JFrame window = new JFrame("2 PLAYERS");
	twoPlayersGame newTwoPlayersGame = new twoPlayersGame();
	window.setLayout(new BorderLayout());
	window.getContentPane().add(newTwoPlayersGame);
	window.setPreferredSize(new Dimension(806,628));
	window.setLocation(300, 50);
	window.setVisible(true);
	window.pack();
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setResizable(false);

	}
}

//buttonMuzyka = new JButton("Music");
//buttonMuzyka.setFocusPainted(false);
//buttonMuzyka.setBorderPainted(false);
//buttonMuzyka.setActionCommand("musicB");
//buttonMuzyka.addActionListener(new ActionListener() {
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		EkranGlowny.music();
//		if (EkranGlowny.muzykaOnOff.equals("on")) {
//			ImageIcon music = new ImageIcon("src/main/resources/images/music.jpg");
//			buttonMuzyka.setIcon(music);
//		} else if (EkranGlowny.muzykaOnOff.equals("off")) {
//			muzykaOnOff = "off";
//			ImageIcon musicOff = new ImageIcon("src/main/resources/images/musicOff.jpg");
//			buttonMuzyka.setIcon(musicOff);
//
//		}
//	}
//
//});
//buttonMuzyka.setBounds(670, 470, 50, 50);
//if (EkranGlowny.muzykaOnOff.equals("on")) {
//	buttonMuzyka.setIcon(music);
//}
//else 
//	buttonMuzyka.setIcon(musicOff);
//buttonMuzyka.setIcon(music);
//con.add(buttonMuzyka);