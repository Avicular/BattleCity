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

public class EkranNajlepszeWyniki {
	
	JFrame window;
	Container con;
	JPanel buttonPanel, Panel;
	JButton buttonWroc, buttonMuzyka;
	String clickSound, backgroundMusic, muzykaOnOff;
//	SoundEffect se = new SoundEffect();
//	Music mu = new Music();
	
	public EkranNajlepszeWyniki(){
	JLabel bg = new JLabel(new ImageIcon("src\\main\\resources\\Battle_City.jpg"));
	bg.setOpaque(true);
	bg.setBounds(0, 0, 800, 600);
	ImageIcon imgicon = new ImageIcon("src/main/resources/12345.png");

//	JLabel label = new JLabel("High Scores");
//	label.setBounds(340, 50, 350, 60);
//	add(label);
//	JLabel label2 = new JLabel("Nazwa Gracza");
//	label2.setBounds(60, 150, 200, 30);
//	con.add(label2);
//	JLabel label3 = new JLabel("Wynik");
//	label3.setBounds(450, 150, 200, 30);
//	con.add(label3);
//	JLabel label4 = new JLabel("gracz 1 ......................................... 2000");
//	label4.setBounds(60, 200, 450, 30);
//	con.add(label4);
	
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
	buttonPanel.setBounds(300, 400, 200, 100);
	buttonPanel.setBackground(Color.black);
	con.add(buttonPanel);


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

		
		