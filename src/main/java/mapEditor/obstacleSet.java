package mapEditor;

import java.util.ArrayList;

public class obstacleSet {
	
	ArrayList<newObstacle> obstaclesList = new ArrayList<newObstacle>();{
		for (int x=0;x<=15;x++) {
			for (int y=0;y<=11;y++) {
				obstaclesList.add(new newObstacle(x*50,y*50));
			}
		}
	}
	
	public obstacleSet() {
		
	}
	
}
