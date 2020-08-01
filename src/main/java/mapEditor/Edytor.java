package mapEditor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BattleCity.EkranGlowny;
import BattleCity.EkranGry1Gracz;
import BattleCity.EkranNowaGra;
import tankModel.newPlayerMovement;

public class Edytor extends JPanel {
	
	public Font font = new Font("Visitor TT1 BRK", Font.BOLD, 28);
	public ArrayList<ImageIcon> objectList = new ArrayList<ImageIcon>();{
		objectList.add(new ImageIcon("src/main/resources/images/editor_field_50px_50px.png"));
		objectList.add(new ImageIcon("src/main/resources/images/bush_field_bordered_icon_50px_50px.png"));
		objectList.add(new ImageIcon("src/main/resources/images/protection_wall_icon_50px_50px.png"));
		objectList.add(new ImageIcon("src/main/resources/images/indestructible_wall_icon_50px_50px.png"));
		objectList.add(new ImageIcon("src/main/resources/images/protection_barrier_icon_50px_50px.png"));
	}
	public int index;
	
	public Edytor() throws IOException {
		setLayout(null);
		setFocusable(true);
		setBackground(Color.DARK_GRAY);
		
		obstacleSet set = new obstacleSet();
		
		for (int x=0;x<set.obstaclesList.size();x++) {
			add(set.obstaclesList.get(x));
		}
		
		MapBuilder builder = new MapBuilder(25,75);
		add(builder);
// DIALOG BOX
		
		String[] maps = {"map1","map2","map3","map4","map5"};
		String mapName = (String) JOptionPane.showInputDialog(null,"Select map slot to edit.","Select", JOptionPane.INFORMATION_MESSAGE,null,maps,maps[0]);
//		String mapFile = "src/main/resources/maps/" + mapName + ".txt";
		String mapFile = "src/main/resources/customMaps/" + mapName + ".txt";
		
		moveBuilder move = new moveBuilder(builder, set, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_SPACE, KeyEvent.VK_ENTER, new PrintWriter(mapFile)); 
		addKeyListener(move);
		
		String hBorder = "src/main/resources/images/protection_border_icon_800px_25px.png";
		String vBorder = "src/main/resources/images/protection_border_icon_25px_800px.png";
		String vBorderShort = "src/main/resources/images/protection_border_icon_25px_50px.png";
		newBorder borderTop = new newBorder(0,50,hBorder);
		add(borderTop);
		newBorder borderBottom = new newBorder(0,575,hBorder);
		add(borderBottom);
		for (int i=0;i<7;i++) {
			newBorder borderMenuOne = new newBorder(150-i*25,0,vBorderShort);
			add(borderMenuOne);
		}
		for (int i=0;i<6;i++) {
			newBorder borderMenuThree = new newBorder(325+i*25,0,vBorderShort);
			add(borderMenuThree);
		}
		for (int i=0;i<7;i++) {
			newBorder borderMenuThree = new newBorder(625+i*25,0,vBorderShort);
			add(borderMenuThree);
		}
		newBorder borderLeft = new newBorder(0,50,vBorder);
		add(borderLeft);
		newBorder borderRight = new newBorder(775,50,vBorder);
		add(borderRight);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(175, 0, 150, 50);
		backButton.setBorderPainted(false);
		backButton.setBorder(BorderFactory.createEtchedBorder(1));
		backButton.setForeground(Color.white);
		backButton.setBackground(Color.black);
		backButton.setFont(font);
		backButton.setActionCommand("soundB");
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EkranGlowny.buttonSoundEffect();
				EkranGry1Gracz.setVisible();
				new EkranNowaGra();
			}
		});
		add(backButton);

		JButton soundButton = new JButton("Music");
		soundButton.setBounds(475, 0, 150, 50);
		soundButton.setBorderPainted(false);
		soundButton.setBorder(BorderFactory.createEtchedBorder(1));
		soundButton.setForeground(Color.white);
		soundButton.setBackground(Color.black);
		soundButton.setFont(font);
		soundButton.setActionCommand("musicB");

		soundButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EkranGlowny.music();

			}

		});
		add(soundButton);
		
	}
	
}
