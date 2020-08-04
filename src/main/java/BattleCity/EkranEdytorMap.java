package BattleCity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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

import mapEditor.Edytor;
import tankModel.Poligon;

public class EkranEdytorMap {

	static JFrame window;
	Font font = new Font("Visitor TT1 BRK", Font.BOLD, 28);
	ImageIcon appIcon = new ImageIcon("src/main/resources/images/12345.png");
	
	public EkranEdytorMap() throws IOException {
		window = new JFrame("MAP EDITOR");
		Edytor mapEditor = new Edytor();
		window.setIconImage(appIcon.getImage());
		window.setLayout(new BorderLayout());
		window.getContentPane().add(mapEditor);
		window.setPreferredSize(new Dimension(806,628));
		window.setLocation(300, 50);
		window.setVisible(true);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		musicOnOffWhenMinimizeMaximazeWindow();
	}
	
	public static void setVisible () {
		window.setVisible(false);
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
				} else if (we.getNewState() != Frame.ICONIFIED) {
					EkranGlowny.mu.setFile(backgroundMusic);
					EkranGlowny.mu.play();
					EkranGlowny.mu.loop();
					EkranGlowny.muzykaOnOff = "on";
					EkranGlowny.buttonMuzyka.setIcon(music);
				}
			}
		});
	}
}