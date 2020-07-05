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

public class EkranNajlepszeWyniki {
	
	JFrame window;
	Container con;
	JPanel buttonPanel, Panel;
	JButton buttonWroc, buttonMuzyka;
	String clickSound, backgroundMusic, muzykaOnOff;

	public EkranNajlepszeWyniki(){
		ImageIcon music = new ImageIcon("src/main/resources/images/music.jpg");
		ImageIcon musicOff = new ImageIcon("src/main/resources/images/musicOff.jpg");
		JLabel bg = new JLabel(new ImageIcon("src/main/resources/images/Battle_City.jpg"));
		bg.setOpaque(true);
		bg.setBounds(0, 0, 800, 600);
		ImageIcon imgicon = new ImageIcon("src/main/resources/images/12345.png");
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
	
	window = new JFrame("Highscores");
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

		
		