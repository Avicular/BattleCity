package tankModel;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class newObject extends JLabel {
	
	public int x;
	public int y;
	public String filepath;
	
	public newObject(int x, int y, String filepath) {
		this.x = x;
		this.y = y;
		this.filepath = filepath;
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		setBounds(this.x = x, this.y = y, 50, 50);
		add(new JLabel(new ImageIcon(filepath)));
	}
}
