package tankModel;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class newBorder extends JLabel {
	
	int x;
	int y;
	String borderPath;
	

	public newBorder(int x, int y, String borderPath) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		new JLabel();
		ImageIcon icon = new ImageIcon(borderPath);
		setBounds(this.x = x, this.y = y, icon.getIconWidth(), icon.getIconHeight());
		// setBackground(Color.BLACK);
		add(new JLabel(icon));
	}
}
