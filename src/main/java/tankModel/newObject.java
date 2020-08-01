package tankModel;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class newObject extends JLabel {
	
	public int x;
	public int y;
	public String filepath;
	public String obstacleType;
	
	public newObject(int x, int y, String filepath, String obstacleType) {
		this.x = x;
		this.y = y;
		this.filepath = filepath;
		this.obstacleType = obstacleType;
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		setBounds(this.x = x, this.y = y, 50, 50);
		ImageIcon objectIcon = new ImageIcon(filepath);
		add(new JLabel(objectIcon) {
			@Override
			protected void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.drawImage(objectIcon.getImage(), 0, 0, null);
			}
		});
	}
	
	public String getPath() {
		return filepath;
	}
}