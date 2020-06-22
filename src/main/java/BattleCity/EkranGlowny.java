
package BattleCity;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EkranGlowny {

	JFrame window;
	Container con;
	JPanel buttonPanel;
	JButton buttonNowaGra, buttonNajlepszeWyniki, buttonEdytorMap, buttonMuzyka;
	String clickSound, backgroundMusic, muzykaOnOff;
	SoundEffect se = new SoundEffect();
	Music mu = new Music();

	public EkranGlowny() {
		JLabel bg = new JLabel(new ImageIcon("src\\main\\resources\\Battle_City.jpg"));
		bg.setOpaque(true);
		bg.setBounds(0, 0, 800, 600);
		ImageIcon imgicon = new ImageIcon("src/main/resources/12345.png");

		window = new JFrame("Battle City");
		window.setSize(800, 600);
		window.setLocation(300, 50);
		window.setIconImage(imgicon.getImage());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.getContentPane().add(bg);

		window.setLayout(null);
		con = window.getContentPane();

		buttonPanel = new JPanel();
		buttonPanel.setBounds(340, 350, 100, 200);
		buttonPanel.setBackground(Color.black);
		con.add(buttonPanel);

		buttonNowaGra = new JButton("Nowa Gra");
		buttonNowaGra.setFocusPainted(true);
		buttonNowaGra.setActionCommand("soundB");
		buttonPanel.add(buttonNowaGra);
		buttonNowaGra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				se.setFile(clickSound);
				se.play();

				new EkranNowaGra();

			}
		});
		
		buttonEdytorMap = new JButton("Edytor Map");
		buttonEdytorMap.setFocusPainted(true);
		buttonEdytorMap.setActionCommand("soundB");
		buttonPanel.add(buttonEdytorMap);
		buttonEdytorMap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				se.setFile(clickSound);
				se.play();

				new EkranEdytorMap();

			}
		});
		
		buttonNajlepszeWyniki = new JButton("Najlepsze Wyniki");
		buttonNajlepszeWyniki.setFocusPainted(true);
		buttonNajlepszeWyniki.setActionCommand("soundB");
		buttonPanel.add(buttonNajlepszeWyniki);
		buttonNajlepszeWyniki.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				se.setFile(clickSound);
				se.play();

				new EkranNajlepszeWyniki();

			}
		});

		buttonMuzyka = new JButton("Music");
		buttonMuzyka.setFocusPainted(false);
//		buttonMuzyka.addActionListener(bHandler);
		buttonMuzyka.setActionCommand("musicB");
		buttonMuzyka.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (muzykaOnOff.equals("off")) {
					mu.setFile(backgroundMusic);
					mu.play();
					mu.loop();
					muzykaOnOff = "on";
					buttonMuzyka.setText("Music On");
				} else if (muzykaOnOff.equals("on")) {
					mu.stop();
					muzykaOnOff = "off";
					buttonMuzyka.setText("Music Off");

				}
			}
		});
		buttonMuzyka.setBounds(640, 500, 100, 30);
		con.add(buttonMuzyka);

		clickSound = "src/main/resources/buttonsound.wav";
		backgroundMusic = "src/main/resources/muzykawtle.wav";
		muzykaOnOff = "off";

		window.setVisible(true);
		mu.setFile(backgroundMusic);
		mu.play();
		mu.loop();
		muzykaOnOff = "on";
		buttonMuzyka.setText("Music On");
	}

	public class SoundEffect {

		Clip clip;

		public void setFile(String soundFileName) {

			try {
				File file = new File(soundFileName);
				AudioInputStream sound = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(sound);
			} catch (Exception e) {

			}
		}

		public void play() {

			clip.setFramePosition(0);
			clip.start();
		}

	}

	public class Music {

		Clip clip;

		public void setFile(String soundFileName) {

			try {
				File file = new File(soundFileName);
				AudioInputStream sound = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(sound);
			} catch (Exception e) {

			}
		}

		public void play() {

			clip.setFramePosition(0);
			clip.start();
		}

		public void loop() {
			clip.loop(Clip.LOOP_CONTINUOUSLY);

		}

		public void stop() {
			clip.stop();
			clip.close();
		}
	}

}