package BattleCity;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EkranEdytorMap extends JPanel {
	public EkranEdytorMap() {
		setLayout(null);

		JLabel label = new JLabel("Edytor Map");
		label.setBounds(220, 50, 350, 60);
		add(label);
		JButton button = new JButton("wróć");
		button.setBounds(220, 600, 120, 30);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
// odwołanie do metody zamykającej bierzące okno i wracającej do ekranu głównego

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
