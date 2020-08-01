package mapEditor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import tankModel.newPlayerMovement;

public class Edytor extends JPanel {
	
	public ArrayList<ImageIcon> objectList = new ArrayList<ImageIcon>();{
		objectList.add(new ImageIcon("src/main/resources/images/editor_field_50px_50px.png"));
		objectList.add(new ImageIcon("src/main/resources/images/bush_field_bordered_icon_50px_50px.png"));
		objectList.add(new ImageIcon("src/main/resources/images/protection_wall_icon_50px_50px.png"));
		objectList.add(new ImageIcon("src/main/resources/images/indestructible_wall_icon_50px_50px.png"));
		objectList.add(new ImageIcon("src/main/resources/images/protection_barrier_icon_50px_50px.png"));
	}
	public int index;
	public String mapFile;
	
	public Edytor(String mapFile) throws IOException {
		setLayout(null);
		setFocusable(true);
		setBackground(Color.DARK_GRAY);
		
		obstacleSet set = new obstacleSet();
		
		for (int x=0;x<set.obstaclesList.size();x++) {
			add(set.obstaclesList.get(x));
//			System.out.println(x);
//			System.out.println(set.obstaclesList.get(x).getX()+","+set.obstaclesList.get(x).getY());
		}
		
		MapBuilder builder = new MapBuilder(25,75);
		add(builder);
		moveBuilder move = new moveBuilder(builder, set, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_SPACE, KeyEvent.VK_ENTER, new PrintWriter(mapFile)); 
		addKeyListener(move);
		
		String hBorder = "src/main/resources/images/protection_border_icon_800px_25px.png";
		String vBorder = "src/main/resources/images/protection_border_icon_25px_800px.png";
		String vBorderShort = "src/main/resources/images/protection_border_icon_25px_50px.png";
		newBorder borderTop = new newBorder(0,50,hBorder);
		add(borderTop);
		newBorder borderBottom = new newBorder(0,575,hBorder);
		add(borderBottom);
		newBorder borderMenuOne = new newBorder(150,0,vBorderShort);
		add(borderMenuOne);
		newBorder borderMenuTwo = new newBorder(625,0,vBorderShort);
		add(borderMenuTwo);
		newBorder borderLeft = new newBorder(0,50,vBorder);
		add(borderLeft);
		newBorder borderRight = new newBorder(775,50,vBorder);
		add(borderRight);
		
	}
	
}
