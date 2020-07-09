package BattleCity;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EkranMapyCustomowe {
	
	JFrame window;
	Container con;
	JPanel buttonPanel;
	JButton button1Gracz, button2Graczy, buttonWroc, buttonMuzyka;
	String clickSound, backgroundMusic, muzykaOnOff;
	Font font = new Font("Visitor TT1 BRK", Font.BOLD, 28);
	public EkranMapyCustomowe(){
		JLabel bg = new JLabel(new ImageIcon("src/main/resources/images/Battle_City.jpg"));
		bg.setOpaque(true);
		bg.setBounds(0, 0, 800, 600);
		ImageIcon imgicon = new ImageIcon("src/main/resources/images/12345.png");
		ImageIcon music = new ImageIcon("src/main/resources/images/music.jpg");
		ImageIcon musicOff = new ImageIcon("src/main/resources/images/musicOff.jpg");

	window = new JFrame("Custom Game");
	window.setSize(800, 600);
	window.setLocation(300, 50);
	window.setIconImage(imgicon.getImage());
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setResizable(false);
	window.getContentPane().add(bg);

	window.setLayout(null);
	con = window.getContentPane();

	buttonPanel = new JPanel();
	buttonPanel.setBounds(275, 350, 250, 100);
	buttonPanel.setBackground(Color.black);
	con.add(buttonPanel);

	button1Gracz = new JButton("Singleplayer");
	button1Gracz.setBorderPainted(false);
	button1Gracz.setBorder(BorderFactory.createEtchedBorder(1));
	button1Gracz.setForeground(Color.white);
	button1Gracz.setBackground(Color.black);
	button1Gracz.setFont(font);
	button1Gracz.setActionCommand("soundB");
	buttonPanel.add(button1Gracz);
	button1Gracz.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			new EkranGry1Gracz();
			window.setVisible(false);
			EkranGlowny.buttonSoundEffect();
		}
	});

	button2Graczy = new JButton("Multiplayer");
	button2Graczy.setBorderPainted(false);
	button2Graczy.setBorder(BorderFactory.createEtchedBorder(1));
	button2Graczy.setForeground(Color.white);
	button2Graczy.setBackground(Color.black);
	button2Graczy.setFont(font);
	button2Graczy.setActionCommand("soundB");
	buttonPanel.add(button2Graczy);
	button2Graczy.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			new EkranGry2Graczy();
			window.setVisible(false);
			EkranGlowny.buttonSoundEffect();
		}
	});

	buttonWroc = new JButton("Back");
	buttonWroc.setBorderPainted(false);
	buttonWroc.setBorder(BorderFactory.createEtchedBorder(1));
	buttonWroc.setForeground(Color.white);
	buttonWroc.setBackground(Color.black);
	buttonWroc.setFont(font);
	buttonWroc.setActionCommand("soundB");
	buttonPanel.add(buttonWroc);
	buttonWroc.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			EkranGlowny.buttonSoundEffect();
			window.setVisible(false);
			EkranNowaGra.window.setVisible(true);
		}
	});
	
	buttonMuzyka = new JButton("Music");
	buttonMuzyka.setFocusPainted(false);
	buttonMuzyka.setBorderPainted(false);
	buttonMuzyka.setActionCommand("musicB");
	buttonMuzyka.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			EkranGlowny.music();
			if (EkranGlowny.muzykaOnOff.equals("on")) {
				ImageIcon music = new ImageIcon("src/main/resources/images/music.jpg");
				buttonMuzyka.setIcon(music);
			} else if (EkranGlowny.muzykaOnOff.equals("off")) {
				muzykaOnOff = "off";
				ImageIcon musicOff = new ImageIcon("src/main/resources/images/musicOff.jpg");
				buttonMuzyka.setIcon(musicOff);

			}
		}

	});
	buttonMuzyka.setBounds(670, 470, 50, 50);
	if (EkranGlowny.muzykaOnOff.equals("on")) {
		buttonMuzyka.setIcon(music);
	}
	else 
		buttonMuzyka.setIcon(musicOff);
	buttonMuzyka.setIcon(music);
	con.add(buttonMuzyka);
	window.setVisible(true);
	
}
}