package tankModel;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class newBullet extends JLabel {
	
	int x;
	int y;
	newTank tank;
	Double bulletAngle;
	
	public newBullet(int x, int y) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		setBounds(this.x = x, this.y = y, 20, 20);
		ImageIcon bulletIcon = new ImageIcon("src/main/resources/images/red_bullet_icon.png");
		add(new JLabel(bulletIcon) {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.rotate(bulletAngle, bulletIcon.getIconWidth()/2, bulletIcon.getIconHeight()/2);
				g2.drawImage(bulletIcon.getImage(), 0, 0, null);
			}
		});
	}
}
