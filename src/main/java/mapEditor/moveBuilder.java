package mapEditor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class moveBuilder implements KeyListener {
	
	public int objectIndex = 0;
	public int obstacleIndex = 0;
	
	public int moveUp;
	public int moveDown;
	public int moveLeft;
	public int moveRight;
	public int build;
	public int accept;
	public MapBuilder builder;
	public newObstacle obstacle;
	public obstacleSet obstaclesSet;
	public String mapFile;
	public PrintWriter mapContent;
	
	public moveBuilder(MapBuilder builder, obstacleSet obstaclesSet, int moveUp, int moveDown, int moveLeft, int moveRight, int build, int accept, PrintWriter mapContent) throws IOException {
		this.builder = builder;
		this.moveUp = moveUp;
		this.moveDown = moveDown;
		this.moveLeft = moveLeft;
		this.moveRight = moveRight;
		this.build = build;
		this.accept = accept;
		this.obstaclesSet = obstaclesSet;
		this.mapContent = mapContent;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == moveUp) {
//			if (builder.getX()<25 && builder.getY()<75) {
			System.out.println(builder.getX()+","+builder.getY());
			builder.setLocation(builder.getX(),builder.getY()-50);
			obstacleIndex = obstacleIndex-1;
//			}
		}
		
		if (e.getKeyCode() == moveDown) {
			builder.setLocation(builder.getX(),builder.getY()+50);
			obstacleIndex = obstacleIndex+1;
		}

		if (e.getKeyCode() == moveLeft) {
			builder.setLocation(builder.getX()-50,builder.getY());
			obstacleIndex = obstacleIndex-10;
		}
		
		if (e.getKeyCode() == moveRight) {
			builder.setLocation(builder.getX()+50,builder.getY());
			obstacleIndex = obstacleIndex+10;
		}
	
		if (e.getKeyCode() == build) {
			objectIndex++;
			if (objectIndex>4)
				objectIndex=0;
			builder.icon.setIcon(builder.objectList.get(objectIndex));
			System.out.println(obstacleIndex);
		}
		
		if (e.getKeyCode() == accept) {
			System.out.println(objectIndex);
			obstaclesSet.obstaclesList.get(obstacleIndex).icon.setIcon(obstaclesSet.obstaclesList.get(obstacleIndex).objectList.get(objectIndex));
			mapContent.println(builder.getX()+","+builder.getY()+","+builder.icon.getIcon().toString());
			mapContent.flush();
//			mapContent.close();
//			System.out.println(builder.getX()+","+builder.getY()+","+builder.icon.getIcon().toString());
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
