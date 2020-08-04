package BattleCity;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EkranNajlepszeWyniki {

	static JFrame window;
	Container con;
	JLabel highscore;
	JPanel buttonPanel, Panel;
	JButton buttonWroc;
	static JButton buttonMuzyka;
	String clickSound, backgroundMusic;
	static String muzykaOnOff;
	Font font = new Font("Visitor TT1 BRK", Font.BOLD, 28);
	ImageIcon music = new ImageIcon("src/main/resources/images/music.jpg");
	ImageIcon musicOff = new ImageIcon("src/main/resources/images/musicOff.jpg");
	JLabel bg = new JLabel(new ImageIcon("src/main/resources/images/Battle_City.jpg"));

	public EkranNajlepszeWyniki() {

		bg.setOpaque(true);
		bg.setBounds(0, 0, 800, 600);
		ImageIcon imgicon = new ImageIcon("src/main/resources/images/12345.png");

		window = new JFrame("Highscores");
		window.setSize(800, 600);
		window.setLocation(300, 50);
		window.setIconImage(imgicon.getImage());

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		window.setLayout(null);
		con = window.getContentPane();
		con.setBackground(Color.BLACK);

		highscore = new JLabel("HighScores");
		highscore.setBounds(310, 60, 300, 25);
		highscore.setBorder(BorderFactory.createEtchedBorder(1));
		highscore.setForeground(Color.white);
		highscore.setBackground(Color.black);
		highscore.setFont(font);
		con.add(highscore);

		buttonPanel = new JPanel();
		buttonPanel.setBounds(300, 450, 200, 100);
		buttonPanel.setBackground(Color.black);
		con.add(buttonPanel);

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
				EkranGlowny.window.setVisible(true);
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
					buttonMuzyka.setIcon(music);
				} else if (EkranGlowny.muzykaOnOff.equals("off")) {
					muzykaOnOff = "off";
					buttonMuzyka.setIcon(musicOff);

				}
			}

		});
		buttonMuzyka.setBounds(670, 470, 50, 50);
		if (EkranGlowny.muzykaOnOff.equals("on")) {
			buttonMuzyka.setIcon(music);
		} else
			buttonMuzyka.setIcon(musicOff);
		con.add(buttonMuzyka);

		ArrayList<Score> scores = new ArrayList<>();
		scores.add(new Score("Piotr", 1));
		scores.add(new Score("Lukasz", 50));
		scores.add(new Score("Adam", 200));
		scores.add(new Score("Daniel", 300));
		scores.add(new Score("Marta", 1000));
		scores.add(new Score("Tomek", 550));
		scores.add(new Score("player2", 3000));
		scores.add(new Score("player3", 12000));
		scores.add(new Score("player4", 5530));
		scores.add(new Score("player5", 3100));
		scores.add(new Score("player6", 11000));
		scores.add(new Score("player7", 520));

		Collections.sort(scores, new ScoreComparator());
		
		ArrayList<String> list = new ArrayList<>();
		scores.forEach((xx) -> list.add(String.valueOf(xx)));

		JLabel[] pola;
		pola = new JLabel[10];

		for (int i = 0; i < 10; i++) {
			System.out.println(list.get(i));

			pola[i] = new JLabel(list.get(i));
			pola[i].setBounds(150, 100 + (i * 35), 500, 30);
			pola[i].setForeground(Color.WHITE);
			pola[i].setFont(font);
			con.add(pola[i]);
		}

//		window.getContentPane().add(bg);
		window.setVisible(true);
		musicOnOffWhenMinimizeMaximazeWindow();

	}

	public static void musicOnOffWhenMinimizeMaximazeWindow() {
		window.addWindowStateListener(new WindowAdapter() {
			@Override
			public void windowStateChanged(WindowEvent we) {
				String backgroundMusic = "src/main/resources/sound/muzykawtle.wav";
				ImageIcon music = new ImageIcon("src/main/resources/images/music.jpg");
				ImageIcon musicOff = new ImageIcon("src/main/resources/images/musicOff.jpg");
				if (we.getNewState() == Frame.ICONIFIED) {
					EkranGlowny.mu.stop();
					EkranGlowny.muzykaOnOff = "off";
					EkranGlowny.buttonMuzyka.setIcon(musicOff);
					muzykaOnOff = "off";
					buttonMuzyka.setIcon(musicOff);
				} else if (we.getNewState() != Frame.ICONIFIED) {
					EkranGlowny.mu.setFile(backgroundMusic);
					EkranGlowny.mu.play();
					EkranGlowny.mu.loop();
					EkranGlowny.muzykaOnOff = "on";
					EkranGlowny.buttonMuzyka.setIcon(music);
					muzykaOnOff = "on";
					buttonMuzyka.setIcon(music);
				}
			}
		});
	}

}
