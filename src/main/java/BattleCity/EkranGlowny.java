package BattleCity;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EkranGlowny extends JPanel {

	public EkranGlowny() throws IOException {
		setLayout(null);

		JButton button1 = new JButton("nowa gra");
		button1.setBounds(120, 150, 320, 30);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame window1 = new JFrame("Nowa Gra");
				ImageIcon imgicon = new ImageIcon("src/main/resources/12345.png");

				EkranNowaGra panel = new EkranNowaGra();

				window1.add(panel);
				window1.setIconImage(imgicon.getImage());
				window1.setLocation(100, 50);
				window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window1.setVisible(true);
				window1.pack();

			}

		});
		add(button1);
		JButton button2 = new JButton("edytor map");
		button2.setBounds(120, 200, 320, 30);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame window1 = new JFrame("Edytor Map");
				ImageIcon imgicon = new ImageIcon("src/main/resources/12345.png");

				EkranEdytorMap panel = new EkranEdytorMap();

				window1.add(panel);
				window1.setIconImage(imgicon.getImage());
				window1.setLocation(100, 50);
				window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window1.setVisible(true);
				window1.pack();

			}

		});
		add(button2);
		JButton button3 = new JButton("Najlepsze Wyniki");
		button3.setBounds(120, 250, 320, 30);
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame window1 = new JFrame("Highscores");
				ImageIcon imgicon = new ImageIcon("src/main/resources/12345.png");

				EkranNajlepszeWyniki panel = new EkranNajlepszeWyniki();

				window1.add(panel);
				window1.setIconImage(imgicon.getImage());
				window1.setLocation(100, 50);
				window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window1.setVisible(true);
				window1.pack();

			}

		});
		add(button3);

		Color tlo = new Color(0, 0, 0);
		setBackground(tlo);

		Font font = new Font("Arial", Font.BOLD, 18);
		for (Component comp : getComponents()) {
			if (comp instanceof JLabel) {
				((JLabel) comp).setFont(font);
			} else if (comp instanceof JButton) {
				((JButton) comp).setFont(font);
			} else if (comp instanceof JTextField) {
				((JTextField) comp).setFont(font);
			}
		}
		
		
//		input.close();
		JLabel bg=new JLabel(new ImageIcon("src\\main\\resources\\Battle_City.jpg"));
        bg.setOpaque(true);
        bg.setBounds(0,0,550,650);
        add(bg);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(550, 450);
	}
}
