
package BattleCity;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EkranGlowny {

	static JFrame window;
	Container con;
	JPanel buttonPanel;
	JButton buttonNowaGra, buttonNajlepszeWyniki, buttonEdytorMap;
	static JButton buttonMuzyka;
	static String clickSound;
	static String backgroundMusic;
	public static String muzykaOnOff;
	static SoundEffect se = new SoundEffect();
	static Music mu = new Music();
	Font font = new Font("Visitor TT1 BRK", Font.BOLD, 28);
	public EkranGlowny() {
		
		
		JLabel bg = new JLabel(new ImageIcon("src/main/resources/images/Battle_City.jpg"));
		bg.setOpaque(true);
		bg.setBounds(0, 0, 800, 600);
		ImageIcon tlo = new ImageIcon("src/main/resources/images/12345.png");
		ImageIcon nowaGra = new ImageIcon("src/main/resources/images/new_game.jpg");
		ImageIcon music = new ImageIcon("src/main/resources/images/music.jpg");
		ImageIcon musicOff = new ImageIcon("src/main/resources/images/musicOff.jpg");
		window = new JFrame("Battle City");
		window.setSize(800, 600);
		window.setLocation(300, 50);
		window.setIconImage(tlo.getImage());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.getContentPane().add(bg);

		window.setLayout(null);
		con = window.getContentPane();

		buttonPanel = new JPanel();
		buttonPanel.setBounds(290, 350, 220, 200);
		buttonPanel.setBackground(Color.black);
		con.add(buttonPanel);

		buttonNowaGra = new JButton("New Game");
		buttonNowaGra.setFocusPainted(true);
		buttonNowaGra.setActionCommand("soundB");
		buttonPanel.add(buttonNowaGra);
		buttonNowaGra.setBorderPainted(false);
		buttonNowaGra.setBorder(BorderFactory.createEtchedBorder(1));
		buttonNowaGra.setForeground(Color.white);
		buttonNowaGra.setBackground(Color.black);
		buttonNowaGra.setFont(font);
		buttonNowaGra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonSoundEffect();
				window.setVisible(false);
				new EkranNowaGra();
			}
		});
		
		buttonEdytorMap = new JButton("Map Editor");
		buttonEdytorMap.setFocusPainted(true);
		buttonEdytorMap.setForeground(Color.white);
		buttonEdytorMap.setBackground(Color.black);
		buttonEdytorMap.setFont(font);
		buttonEdytorMap.setBorderPainted(false);
		buttonEdytorMap.setBorder(BorderFactory.createEtchedBorder(1));
		buttonEdytorMap.setActionCommand("soundB");
		buttonPanel.add(buttonEdytorMap);
		buttonEdytorMap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonSoundEffect();
				window.setVisible(false);
				new EkranEdytorMap();

			}
		});
		
		buttonNajlepszeWyniki = new JButton("Highscores");
		buttonNajlepszeWyniki.setFocusPainted(true);
		buttonNajlepszeWyniki.setForeground(Color.white);
		buttonNajlepszeWyniki.setBackground(Color.black);
		buttonNajlepszeWyniki.setFont(font);
		buttonNajlepszeWyniki.setBorderPainted(false);
		buttonNajlepszeWyniki.setBorder(BorderFactory.createEtchedBorder(1));
		buttonNajlepszeWyniki.setActionCommand("soundB");
		buttonPanel.add(buttonNajlepszeWyniki);
		buttonNajlepszeWyniki.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonSoundEffect();
				window.setVisible(false);
				new EkranNajlepszeWyniki();
			}
		});
	
		
		buttonMuzyka = new JButton();
		buttonMuzyka.setFocusPainted(false);
		buttonMuzyka.setActionCommand("musicB");
		buttonMuzyka.setBorderPainted(false);
		buttonMuzyka.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				music();
			}
		});
		
		
		buttonMuzyka.setBounds(670, 470, 62, 50);
		buttonMuzyka.setIcon(music);
		con.add(buttonMuzyka);

		clickSound = "src/main/resources/sound/buttonsound.wav";
		backgroundMusic = "src/main/resources/sound/muzykawtle.wav";
		
		window.setVisible(true);
		mu.setFile(backgroundMusic);
		mu.play();
		mu.loop();
		muzykaOnOff = "on";
	
		
		
	}

	public static void music() {
		if (muzykaOnOff.equals("off")) {
			mu.setFile(backgroundMusic);
			mu.play();
			mu.loop();
			muzykaOnOff = "on";
			
			ImageIcon music = new ImageIcon("src/main/resources/images/music.jpg");
			buttonMuzyka.setIcon(music);
		} else if (muzykaOnOff.equals("on")) {
			mu.stop();
			muzykaOnOff = "off";
			ImageIcon musicOff = new ImageIcon("src/main/resources/images/musicOff.jpg");
			buttonMuzyka.setIcon(musicOff);

		}
	}
	
	public static void buttonSoundEffect() {
		se.setFile(clickSound);
		se.play();
	}

}