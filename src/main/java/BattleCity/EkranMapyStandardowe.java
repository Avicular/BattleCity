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

//import BattleCity.Sound.Music;
//import BattleCity.Sound.SoundEffect;

public class EkranMapyStandardowe {
	
	JFrame window;
	Container con;
	JPanel buttonPanel;
	JButton button1Gracz, button2Graczy, buttonWroc, buttonMuzyka;
	String clickSound, backgroundMusic, muzykaOnOff;
//	SoundEffect se = new SoundEffect();
//	Music mu = new Music();
	
	public EkranMapyStandardowe(){
	JLabel bg = new JLabel(new ImageIcon("src\\main\\resources\\Battle_City.jpg"));
	bg.setOpaque(true);
	bg.setBounds(0, 0, 800, 600);
	ImageIcon imgicon = new ImageIcon("src/main/resources/12345.png");

	window = new JFrame("Mapy Standardowe");
	window.setSize(800, 600);
	window.setLocation(300, 50);
	window.setIconImage(imgicon.getImage());
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setResizable(false);
	window.getContentPane().add(bg);

	window.setLayout(null);
	con = window.getContentPane();

	buttonPanel = new JPanel();
	buttonPanel.setBounds(340, 350, 100, 100);
	buttonPanel.setBackground(Color.black);
	con.add(buttonPanel);

	button1Gracz = new JButton("1 Gracz");
	button1Gracz.setFocusPainted(true);
	button1Gracz.setActionCommand("soundB");
	buttonPanel.add(button1Gracz);
	button1Gracz.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			new EkranGry1Gracz();

		}
	});

	button2Graczy = new JButton("2 Graczy");
	button2Graczy.setFocusPainted(true);
	button2Graczy.setActionCommand("soundB");
	buttonPanel.add(button2Graczy);
	button2Graczy.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			new EkranGry2Graczy();

		}
	});

	buttonWroc = new JButton("Powrot");
	buttonWroc.setFocusPainted(true);
	buttonWroc.setActionCommand("soundB");
	buttonPanel.add(buttonWroc);
	buttonWroc.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			window.setVisible(false);
		}
	});
	
	buttonMuzyka = new JButton("Music");
	buttonMuzyka.setFocusPainted(false);
	buttonMuzyka.setActionCommand("musicB");
	buttonMuzyka.setBounds(640, 500, 100, 30);
	con.add(buttonMuzyka);

	clickSound = "src/main/resources/buttonsound.wav";
	backgroundMusic = "src/main/resources/muzykawtle.wav";
	muzykaOnOff = "off";

	window.setVisible(true);

}
}