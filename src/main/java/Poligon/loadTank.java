package Poligon;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class loadTank extends JLabel {
	
	int x;
	int y;
	String tankVersion;
	Double tankAngle;
	
	public loadTank(int x, int y, String tankVersion, Double tankAngle) {

		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		setBounds(this.x = x, this.y = y, 50, 50);
		ImageIcon tankIcon = new ImageIcon(this.tankVersion = tankVersion);
		add(new JLabel(tankIcon) {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.rotate(tankAngle, tankIcon.getIconWidth() / 2, tankIcon.getIconHeight() / 2);
				g2.drawImage(tankIcon.getImage(), 0, 0, null);
			}
		});

		System.out.println("player's tank added");
		System.out.println("tank hitpoints:3");
	}
	
}
