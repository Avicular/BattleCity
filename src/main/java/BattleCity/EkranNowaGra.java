package BattleCity;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EkranNowaGra {

	static JFrame window;
	Container con;
	JPanel buttonPanel;
	JButton buttonMapyStandardowe, buttonMapyCustomowe, buttonWroc, buttonMuzyka;
	String clickSound, backgroundMusic, muzykaOnOff;
	ImageIcon music = new ImageIcon("src/main/resources/images/music.jpg");
	ImageIcon musicOff = new ImageIcon("src/main/resources/images/musicOff.jpg");

	public EkranNowaGra() {
		JLabel bg = new JLabel(new ImageIcon("src/main/resources/images/Battle_City.jpg"));
		bg.setOpaque(true);
		bg.setBounds(0, 0, 800, 600);
		ImageIcon imgicon = new ImageIcon("src/main/resources/images/12345.png");
		window = new JFrame("New Game");
		window.setSize(800, 600);
		window.setLocation(300, 50);
		window.setIconImage(imgicon.getImage());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.getContentPane().add(bg);

		window.setLayout(null);
		con = window.getContentPane();

		buttonPanel = new JPanel();
		buttonPanel.setBounds(350, 350, 100, 100);
		buttonPanel.setBackground(Color.black);
		con.add(buttonPanel);

		buttonMapyStandardowe = new JButton("Standard Maps");
		buttonMapyStandardowe.setFocusPainted(true);
		buttonMapyStandardowe.setActionCommand("soundB");
		buttonPanel.add(buttonMapyStandardowe);
		buttonMapyStandardowe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EkranMapyStandardowe();
				window.setVisible(false);
				EkranGlowny.buttonSoundEffect();
			}
		});

		buttonMapyCustomowe = new JButton("Custom Maps");
		buttonMapyCustomowe.setFocusPainted(true);
		buttonMapyCustomowe.setActionCommand("soundB");
		buttonPanel.add(buttonMapyCustomowe);
		buttonMapyCustomowe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EkranMapyCustomowe();
				window.setVisible(false);
				EkranGlowny.buttonSoundEffect();
			}
		});

		buttonWroc = new JButton("Back");
		buttonWroc.setFocusPainted(true);
		buttonWroc.setActionCommand("soundB");
		buttonPanel.add(buttonWroc);
		buttonWroc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EkranGlowny.buttonSoundEffect();
				window.setVisible(false);
				EkranGlowny.window.setVisible(true);
			}
		});

		buttonMuzyka = new JButton("Music");
		buttonMuzyka.setFocusPainted(false);
		buttonMuzyka.setBorderPainted(false);
		buttonMuzyka.setActionCommand("musicB");
		
		if (EkranGlowny.muzykaOnOff.equals("off")) {
			buttonMuzyka.setIcon(musicOff);
		}
		else 
			buttonMuzyka.setIcon(music);
		buttonMuzyka.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EkranGlowny.muzyka();
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
		
		buttonMuzyka.setIcon(music);
		con.add(buttonMuzyka);
		window.setVisible(true);
		
		}
	}
