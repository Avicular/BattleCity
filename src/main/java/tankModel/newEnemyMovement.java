package tankModel;

import java.util.ArrayList;
import java.util.TimerTask;

public class newEnemyMovement extends TimerTask {

	public newTank tank;
	public int bullets = 399;
		
	public newEnemyMovement(newTank tank) {
		this.tank = tank;
	}


	@Override
	public void run() {
		
		if (tank.isVisible()==true){
		// CHANGE TANK POSITION
		ArrayList<Double> enemyAngles = new ArrayList<Double>();
		enemyAngles.add(-Math.PI/2);
		enemyAngles.add((double) 0);
		enemyAngles.add(Math.PI/2);
		enemyAngles.add(Math.PI);
		
		int random = (int)(Math.random()*4);
		
		if (Math.random()>0.95) {
			tank.tankAngle = enemyAngles.get(random);
			tank.repaint();
		}
		if (tank.tankAngle == -Math.PI/2) {
			try {
				int counter = 0;
				for (int i = 0; i <= 49; i++) {
					String objectName = tank.getParent().getComponentAt(tank.getX()+i, tank.getY()-1).getName();
					if (tank.getParent().getComponentAt(tank.getX()+i, tank.getY()-1).isVisible()==true)
					if (objectName == "barrier" || objectName == "field" || objectName == "wall" || objectName == "tank1" || objectName == "enemy" || objectName == "border")
						counter++;
				}
				if (counter > 0)
					tank.setLocation(tank.getX(), tank.getY());
				else
					tank.setLocation(tank.getX(), tank.getY() - 2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (tank.tankAngle == (double) 0){
			try {
				int counter = 0;
				for (int i = 0; i <= 49; i++) {
					String objectName = tank.getParent().getComponentAt(tank.getX() + 51, tank.getY() + i).getName();
					if (tank.getParent().getComponentAt(tank.getX() + 51, tank.getY() + i).isVisible()==true)
					if (objectName == "barrier" || objectName == "field" || objectName == "wall" || objectName == "tank1" || objectName == "enemy" || objectName == "border")
						counter++;
				}
				if (counter > 0)
					tank.setLocation(tank.getX(), tank.getY());
				else
					tank.setLocation(tank.getX() + 2, tank.getY());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (tank.tankAngle == Math.PI/2) {
			try {
				int counter = 0;
				for (int i = 0; i <= 49; i++) {
					String objectName = tank.getParent().getComponentAt(tank.getX() + i, tank.getY() + 51).getName();
					if (tank.getParent().getComponentAt(tank.getX() + i, tank.getY() + 51).isVisible()==true)
					if (objectName == "barrier" || objectName == "field" || objectName == "wall" || objectName == "tank1" || objectName == "enemy" || objectName == "border")
						counter++;
				}
				if (counter > 0)
					tank.setLocation(tank.getX(), tank.getY());
				else
					tank.setLocation(tank.getX(), tank.getY() + 2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (tank.tankAngle == Math.PI) {
			try {
				int counter = 0;
				for (int i = 0; i <= 49; i++) {
					String objectName = tank.getParent().getComponentAt(tank.getX() - 1, tank.getY() + i).getName();
					if (tank.getParent().getComponentAt(tank.getX() - 1, tank.getY() + i).isVisible()==true)
					if (objectName == "barrier" || objectName == "field" || objectName == "wall" || objectName == "tank1" || objectName == "enemy" || objectName == "border")
						counter++;
				}
				if (counter > 0)
					tank.setLocation(tank.getX(), tank.getY());
				else
					tank.setLocation(tank.getX() - 2, tank.getY());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// SHOOT BULLET
		if (Math.random()>0.95) {
			if (tank.tankAngle == - Math.PI/2) {
				tank.pociski.get(bullets).bulletAngle = - Math.PI/2;
				tank.pociski.get(bullets).setBounds(tank.getX()+15, tank.getY()-20, 20, 20);
				tank.pociski.get(bullets).repaint();
				tank.pociski.get(bullets).setVisible(true);
				}
			if (tank.tankAngle == (double) 0) {
				tank.pociski.get(bullets).bulletAngle = (double) 0;
				tank.pociski.get(bullets).setBounds(tank.getX()+50, tank.getY()+15, 20, 20);
				tank.pociski.get(bullets).repaint();
				tank.pociski.get(bullets).setVisible(true);
			}
			if (tank.tankAngle == Math.PI/2) {
				tank.pociski.get(bullets).bulletAngle = Math.PI/2;
				tank.pociski.get(bullets).setBounds(tank.getX()+15, tank.getY()+50, 20, 20);
				tank.pociski.get(bullets).repaint();
				tank.pociski.get(bullets).setVisible(true);
				}
			if (tank.tankAngle == Math.PI) {
				tank.pociski.get(bullets).bulletAngle = Math.PI;
				tank.pociski.get(bullets).setBounds(tank.getX()-20, tank.getY()+15, 20, 20);
				tank.pociski.get(bullets).repaint();
				tank.pociski.get(bullets).setVisible(true);
				}
			bullets--;
		}
		
		}
	}
}
