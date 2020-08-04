package BattleCity;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EkranNowaGra {

	public static JFrame window;
	Container con;
	JPanel buttonPanel;
	JButton buttonMapyStandardowe, buttonMapyCustomowe, buttonWroc;
	static JButton buttonMuzyka;
	String clickSound;
	static String backgroundMusic;
	static String muzykaOnOff;
	ImageIcon music = new ImageIcon("src/main/resources/images/music.jpg");
	ImageIcon musicOff = new ImageIcon("src/main/resources/images/musicOff.jpg");
	ImageIcon imgicon = new ImageIcon("src/main/resources/images/12345.png");
	Font font = new Font("Visitor TT1 BRK", Font.BOLD, 28);
	
	public EkranNowaGra() {
		JLabel bg = new JLabel(new ImageIcon("src/main/resources/images/Battle_City.jpg"));
		bg.setOpaque(true);
		bg.setBounds(0, 0, 800, 600);
		
		window = new JFrame("New Game");
		window.setSize(800, 600);
		window.setLocation(300, 50);
		window.setIconImage(imgicon.getImage());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		

		window.setLayout(null);
		con = window.getContentPane();

		buttonPanel = new JPanel();
		buttonPanel.setBounds(275, 350, 250, 200);
		buttonPanel.setBackground(Color.black);
		con.add(buttonPanel);

		buttonMapyStandardowe = new JButton("Standard Maps");
		buttonMapyStandardowe.setBorderPainted(false);
		buttonMapyStandardowe.setBorder(BorderFactory.createEtchedBorder(1));
		buttonMapyStandardowe.setForeground(Color.white);
		buttonMapyStandardowe.setBackground(Color.black);
		buttonMapyStandardowe.setFont(font);
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
		buttonMapyCustomowe.setBorderPainted(false);
		buttonMapyCustomowe.setBorder(BorderFactory.createEtchedBorder(1));
		buttonMapyCustomowe.setForeground(Color.white);
		buttonMapyCustomowe.setBackground(Color.black);
		buttonMapyCustomowe.setFont(font);
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
		if (EkranGlowny.muzykaOnOff.equals("off")) {
			muzykaOnOff = "off";
			buttonMuzyka.setIcon(musicOff);}
		else {
			buttonMuzyka.setIcon(music);
		}	
		buttonMuzyka.setBounds(670, 470, 50, 50);
		con.add(buttonMuzyka);
		window.getContentPane().add(bg);
		window.setVisible(true);
		musicOnOffWhenMinimizeMaximazeWindow();
		
		
		}
	public static void musicOnOffWhenMinimizeMaximazeWindow() {
		window.addWindowStateListener(new WindowAdapter() {
			@Override
			public void windowStateChanged(WindowEvent we) {
				backgroundMusic = "src/main/resources/sound/muzykawtle.wav";
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
