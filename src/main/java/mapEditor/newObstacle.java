package mapEditor;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class newObstacle extends JLabel{
	
	public int x;
	public int y;
	
	public ArrayList<ImageIcon> objectList = new ArrayList<ImageIcon>();{
		objectList.add(new ImageIcon("src/main/resources/images/editor_field_50px_50px.png"));
		objectList.add(new ImageIcon("src/main/resources/images/bush_field_bordered_icon_50px_50px.png"));
		objectList.add(new ImageIcon("src/main/resources/images/protection_wall_icon_50px_50px.png"));
		objectList.add(new ImageIcon("src/main/resources/images/indestructible_wall_icon_50px_50px.png"));
		objectList.add(new ImageIcon("src/main/resources/images/protection_barrier_icon_50px_50px.png"));
	}
	
	public JLabel icon = new JLabel();
	
	public newObstacle(int x, int y) {
		this.x = x;
		this.y = y;
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		setBounds(this.x = x, this.y = y, 50, 50);
		add(icon);
	}
	
}
