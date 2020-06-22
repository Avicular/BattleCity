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

public class EkranNowaGra {
	
	JFrame window;
	Container con;
	JPanel buttonPanel;
	JButton buttonMapyStandardowe, buttonMapyCustomowe, buttonWroc, buttonMuzyka;
	String clickSound, backgroundMusic, muzykaOnOff;
//	SoundEffect se = new SoundEffect();
//	Music mu = new Music();
	
	public EkranNowaGra(){
	JLabel bg = new JLabel(new ImageIcon("src\\main\\resources\\Battle_City.jpg"));
	bg.setOpaque(true);
	bg.setBounds(0, 0, 800, 600);
	ImageIcon imgicon = new ImageIcon("src/main/resources/12345.png");

	window = new JFrame("Nowa Gra");
	window.setSize(800, 600);
	window.setLocation(300, 50);
	window.setIconImage(imgicon.getImage());
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setResizable(false);
	window.getContentPane().add(bg);

	window.setLayout(null);
	con = window.getContentPane();

	buttonPanel = new JPanel();
	buttonPanel.setBounds(300, 350, 200, 100);
	buttonPanel.setBackground(Color.black);
	con.add(buttonPanel);

	buttonMapyStandardowe = new JButton("Mapy Standardowe");
	buttonMapyStandardowe.setFocusPainted(true);
	buttonMapyStandardowe.setActionCommand("soundB");
	buttonPanel.add(buttonMapyStandardowe);
	buttonMapyStandardowe.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			new EkranMapyStandardowe();

		}
	});

	buttonMapyCustomowe = new JButton("Mapy Customowe");
	buttonMapyCustomowe.setFocusPainted(true);
	buttonMapyCustomowe.setActionCommand("soundB");
	buttonPanel.add(buttonMapyCustomowe);
	buttonMapyCustomowe.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			new EkranMapyCustomowe();

		}
	});

	buttonWroc = new JButton("Powrot");
	buttonWroc.setFocusPainted(true);
	buttonWroc.setActionCommand("soundB");
	buttonPanel.add(buttonWroc);
	buttonWroc.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
//			new EkranMapyStandardowe();
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