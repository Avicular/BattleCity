package Poligon;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


// miejsce na przyciski, wyœwietlanie punktów, itp.
public class ekranGryMenu extends JPanel {

	
	public ekranGryMenu () {
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		
		JButton button = new JButton("powrót");
		button.setBounds(250, 100, 120, 30);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
			
		});
		add(button);
	}
}
