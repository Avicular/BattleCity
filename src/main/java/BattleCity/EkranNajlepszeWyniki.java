package BattleCity;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EkranNajlepszeWyniki extends JPanel {
	public EkranNajlepszeWyniki() {
		setLayout(null);

		JLabel label = new JLabel("High Scores");
		label.setBounds(220, 50, 350, 60);
		add(label);
		JLabel label2 = new JLabel("Nazwa Gracza");
		label2.setBounds(60, 150, 200, 30);
		add(label2);
		JLabel label3 = new JLabel("Wynik");
		label3.setBounds(450, 150, 200, 30);
		add(label3);
		JLabel label4 = new JLabel("gracz 1 ......................................... 2000");
		label4.setBounds(60, 200, 450, 30);
		add(label4);

		JButton button = new JButton("wróć");
		button.setBounds(220, 600, 120, 30);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
// odwołanie do metody zamykającej (ustawiającej hide) bierzące okno i wracającej do ekranu głównego

			}

		});
		add(button);

		Color tlo = new Color(0, 0, 0);
		setBackground(tlo);

		Font font = new Font("Arial", Font.BOLD, 26);
		for (Component comp : getComponents()) {
			if (comp instanceof JLabel) {
				((JLabel) comp).setFont(font);
				((JLabel) comp).setForeground(Color.WHITE);
			} else if (comp instanceof JButton) {
				((JButton) comp).setFont(font);

			}
		}

//        JLabel bg=new JLabel(new ImageIcon("C:\\Users\\jaroo\\eclipse-workspace\\cschoolzdalnie\\src\\com\\gui3\\tlo.jpg"));
//        bg.setOpaque(true);
//        bg.setBounds(0,0,550,650);
//        add(bg);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(550, 650);
	}
}
