package Poligon;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class loadObstacle extends JLabel{

		int x;
		int y;
		String borderPath;	

		public loadObstacle(int x, int y, String borderPath) {
			setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			setBounds(this.x = x, this.y = y, 50, 50);
			ImageIcon obstacleIcon = new ImageIcon(this.borderPath = borderPath);
			add(new JLabel(obstacleIcon) {
				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					g2.drawImage(obstacleIcon.getImage(), 0, 0, null);
				}
			});
		}
	
}
