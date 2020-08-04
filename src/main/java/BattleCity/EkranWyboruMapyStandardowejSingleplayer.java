package BattleCity;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EkranWyboruMapyStandardowejSingleplayer {
	
	static JFrame window;
	Container con;
	JPanel buttonPanel;
	JButton buttonMap1, buttonMap2, buttonMap3, buttonMap4, buttonMap5, buttonWroc;
	static JButton buttonMuzyka;
	String clickSound, backgroundMusic;
	static String muzykaOnOff;
	Font font = new Font("Visitor TT1 BRK", Font.BOLD, 28);
	public EkranWyboruMapyStandardowejSingleplayer(){
		JLabel bg = new JLabel(new ImageIcon("src/main/resources/images/Battle_City.jpg"));
		bg.setOpaque(true);
		bg.setBounds(0, 0, 800, 600);
		ImageIcon imgicon = new ImageIcon("src/main/resources/images/12345.png");
		ImageIcon music = new ImageIcon("src/main/resources/images/music.jpg");
		ImageIcon musicOff = new ImageIcon("src/main/resources/images/musicOff.jpg");

	window = new JFrame("Select Standard Map Singleplayer");
	window.setSize(800, 600);
	window.setLocation(300, 50);
	window.setIconImage(imgicon.getImage());
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setResizable(false);
	

	window.setLayout(null);
	con = window.getContentPane();

	buttonPanel = new JPanel();
	buttonPanel.setBounds(175, 350, 450, 100);
	buttonPanel.setBackground(Color.black);
	con.add(buttonPanel);

	buttonMap1 = new JButton("Map1");
	buttonMap1.setBorderPainted(false);
	buttonMap1.setBorder(BorderFactory.createEtchedBorder(1));
	buttonMap1.setForeground(Color.white);
	buttonMap1.setBackground(Color.black);
	buttonMap1.setFont(font);
	buttonMap1.setActionCommand("soundB");
	buttonPanel.add(buttonMap1);
	buttonMap1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				new EkranGry1Gracz("src/main/resources/maps/map1.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			window.setVisible(false);
			EkranGlowny.buttonSoundEffect();
		}
	});

	buttonMap2 = new JButton("Map2");
	buttonMap2.setBorderPainted(false);
	buttonMap2.setBorder(BorderFactory.createEtchedBorder(1));
	buttonMap2.setForeground(Color.white);
	buttonMap2.setBackground(Color.black);
	buttonMap2.setFont(font);
	buttonMap2.setActionCommand("soundB");
	buttonPanel.add(buttonMap2);
	buttonMap2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				new EkranGry1Gracz("src/main/resources/maps/map2.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			window.setVisible(false);
			EkranGlowny.buttonSoundEffect();
		}
	});
	
	buttonMap3 = new JButton("Map3");
	buttonMap3.setBorderPainted(false);
	buttonMap3.setBorder(BorderFactory.createEtchedBorder(1));
	buttonMap3.setForeground(Color.white);
	buttonMap3.setBackground(Color.black);
	buttonMap3.setFont(font);
	buttonMap3.setActionCommand("soundB");
	buttonPanel.add(buttonMap3);
	buttonMap3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				new EkranGry1Gracz("src/main/resources/maps/map3.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			window.setVisible(false);
			EkranGlowny.buttonSoundEffect();
		}
	});
	
	buttonMap4 = new JButton("Map4");
	buttonMap4.setBorderPainted(false);
	buttonMap4.setBorder(BorderFactory.createEtchedBorder(1));
	buttonMap4.setForeground(Color.white);
	buttonMap4.setBackground(Color.black);
	buttonMap4.setFont(font);
	buttonMap4.setActionCommand("soundB");
	buttonPanel.add(buttonMap4);
	buttonMap4.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				new EkranGry1Gracz("src/main/resources/maps/map4.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			window.setVisible(false);
			EkranGlowny.buttonSoundEffect();
		}
	});
	buttonMap5 = new JButton("Map5");
	buttonMap5.setBorderPainted(false);
	buttonMap5.setBorder(BorderFactory.createEtchedBorder(1));
	buttonMap5.setForeground(Color.white);
	buttonMap5.setBackground(Color.black);
	buttonMap5.setFont(font);
	buttonMap5.setActionCommand("soundB");
	buttonPanel.add(buttonMap5);
	buttonMap5.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				new EkranGry1Gracz("src/main/resources/maps/map5.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	buttonWroc.setBounds(350, 450, 100, 30);
	con.add(buttonWroc);
	buttonWroc.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			EkranGlowny.buttonSoundEffect();
			window.setVisible(false);
			EkranMapyStandardowe.window.setVisible(true);
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
	con.add(buttonMuzyka);
	window.getContentPane().add(bg);
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