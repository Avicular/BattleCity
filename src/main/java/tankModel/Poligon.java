package tankModel;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;

import javax.swing.JPanel;

public class Poligon extends JPanel {
	
	
	public String grayTank = "src/main/resources/images/gray_tank_icon.png";
	Scanner mapArea = new Scanner(new File("src/main/resources/maps/map2.txt"));
	
	public Poligon() throws IOException {
		setLayout(null);
		setFocusable(true);
		setBackground(Color.DARK_GRAY);
		
		while(mapArea.hasNextLine()) {
			String nextLine = mapArea.nextLine();
			if (nextLine.charAt(2)==',') {
				String s1 = nextLine.substring(0, 2);
				if (nextLine.charAt(5)==',') {
					String s2 = nextLine.substring(3, 5);
					String s3 = nextLine.substring(6);
					int x = Integer.parseInt(s1);
					int y = Integer.parseInt(s2);
					add(new newObject(x, y, s3));
				}
				else if (nextLine.charAt(6)==',') {
					String s2 = nextLine.substring(3, 6);
					String s3 = nextLine.substring(7);
					int x = Integer.parseInt(s1);
					int y = Integer.parseInt(s2);
					add(new newObject(x, y, s3));
				}
			}
			else if (nextLine.charAt(3)==',') {
				String s1 = nextLine.substring(0, 3);
				if (nextLine.charAt(6)==',') {
					String s2 = nextLine.substring(4, 6);
					String s3 = nextLine.substring(7);
					int x = Integer.parseInt(s1);
					int y = Integer.parseInt(s2);
					add(new newObject(x, y, s3));
				}
				else if (nextLine.charAt(7)==',') {
					String s2 = nextLine.substring(4, 7);
					String s3 = nextLine.substring(8);
					int x = Integer.parseInt(s1);
					int y = Integer.parseInt(s2);
					add(new newObject(x, y, s3));
				}
				
			}
		}
		
		newTank playerOne = new newTank(100,550,grayTank);
		add(playerOne);
		newPlayerMovement mOne = new newPlayerMovement(playerOne, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_SPACE); 
		addKeyListener(mOne);
		for (int i=0;i<300;i++) {
			add(playerOne.pociski.get(i));
			playerOne.pociski.get(i).setVisible(false);
			new Timer().scheduleAtFixedRate(new newBulletMovement(playerOne.pociski.get(i)), 0, 50);
			}
//		
//		newTank enemyOne = new newTank(300,300,grayTank);
//		add(enemyOne);
//		for (int i=0;i<300;i++) {
//			add(enemyOne.pociski.get(i));
//			enemyOne.pociski.get(i).setVisible(false);
//			new Timer().scheduleAtFixedRate(new newBulletMovement(enemyOne.pociski.get(i)), 0, 50);
//			}
//		new Timer().scheduleAtFixedRate(new newEnemyMovement(enemyOne), 0, 50);
//		
//		newTank enemyTwo = new newTank(300,400,grayTank);
//		add(enemyTwo);
//		for (int i=0;i<300;i++) {
//			add(enemyTwo.pociski.get(i));
//			enemyTwo.pociski.get(i).setVisible(false);
//			new Timer().scheduleAtFixedRate(new newBulletMovement(enemyTwo.pociski.get(i)), 0, 50);
//			}
//		new Timer().scheduleAtFixedRate(new newEnemyMovement(enemyTwo), 0, 50);
		
//		newTank playerTwo = new newTank(600,550,grayTank);
//		add(playerTwo);
//		newPlayerMovement mTwo = new newPlayerMovement(playerTwo, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_ENTER); 
//		addKeyListener(mTwo);
//		for (int i=0;i<300;i++) {
//			add(playerTwo.pociski.get(i));
//			playerTwo.pociski.get(i).setVisible(false);
//			new Timer().scheduleAtFixedRate(new newBulletMovement(playerTwo.pociski.get(i)), 0, 50);
//			}
	
		
	}
	
}
