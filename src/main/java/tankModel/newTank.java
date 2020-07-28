package tankModel;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class newTank extends JLabel{

	public int x;
	public int y;
	public String tankVersion;
	public Double tankAngle = -Math.PI/2;
	
	public ArrayList<newBullet> pociski = new ArrayList<newBullet>();
	{	for (int i=0;i<300;i++) 
		pociski.add(new newBullet(100,100));
	}
	
	public newTank(int x, int y, String tankVersion) {
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
	
	public Double getAngle() {
		return tankAngle;
	}
	
	
	
}
