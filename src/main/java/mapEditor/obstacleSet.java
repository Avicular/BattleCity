package mapEditor;

import java.util.ArrayList;

public class obstacleSet {
	
	ArrayList<newObstacle> obstaclesList = new ArrayList<newObstacle>();{
		for (int x=0;x<=14;x++) {
			for (int y=0;y<=9;y++) {
				obstaclesList.add(new newObstacle(25+x*50,75+y*50));
			}
		}
	}
	
	public obstacleSet() {
		
	}
	
}
