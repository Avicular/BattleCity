package tankModel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class newPlayerMovement implements KeyListener{
	
	public int moveUp;
	public int moveDown;
	public int moveLeft;
	public int moveRight;
	public int shoot;
	public newTank tank;
	public String objectName = null;
	
	public int bullets = 399;
	
	public newPlayerMovement(newTank tank, int moveUp, int moveDown, int moveLeft, int moveRight, int shoot) {
		this.tank = tank;
		this.moveUp = moveUp;
		this.moveDown = moveDown;
		this.moveLeft = moveLeft;
		this.moveRight = moveRight;
		this.shoot = shoot;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == moveUp) {
				tank.tankAngle = -Math.PI / 2;
				tank.repaint();
			
			int counter = 0;
			for (int i = 0; i <= 49; i++) {
				objectName = tank.getParent().getComponentAt(tank.getX()+i, tank.getY()-1).getName();
				if (tank.getParent().getComponentAt(tank.getX()+i, tank.getY()-1).isVisible()==true)
				if (objectName == "barrier" || objectName == "field" || objectName == "wall" || objectName == "tank1" || objectName == "tank2" || objectName == "enemy" || objectName == "border")
					counter++;
			}
			if (counter > 0)
				tank.setLocation(tank.getX(), tank.getY());
			else
				tank.setLocation(tank.getX(), tank.getY() - 1);
//			System.out.println(tank.tankAngle);
		}
		if (e.getKeyCode() == moveDown) {
				tank.tankAngle = Math.PI / 2;
				tank.repaint();
			
			int counter = 0;
			for (int i = 0; i <= 49; i++) {
				objectName = tank.getParent().getComponentAt(tank.getX() + i, tank.getY() + 50).getName();
				if (tank.getParent().getComponentAt(tank.getX() + i, tank.getY() + 50).isVisible()==true)
				if (objectName == "barrier" || objectName == "field" || objectName == "wall" || objectName == "tank1" || objectName == "tank2" || objectName == "enemy" || objectName == "border")
					counter++;
			}
			if (counter > 0)
				tank.setLocation(tank.getX(), tank.getY());
			else
				tank.setLocation(tank.getX(), tank.getY() + 1);
//			distance1++;
			System.out.println(tank.tankAngle);
		}

		if (e.getKeyCode() == moveLeft) {
				tank.tankAngle = Math.PI;
				tank.repaint();

			int counter = 0;
			for (int i = 0; i <= 49; i++) {
				objectName = tank.getParent().getComponentAt(tank.getX() - 1, tank.getY() + i).getName();
				if (tank.getParent().getComponentAt(tank.getX() - 1, tank.getY() + i).isVisible()==true)
				if (objectName == "barrier" || objectName == "field" || objectName == "wall" || objectName == "tank1" || objectName == "tank2" || objectName == "enemy" || objectName == "border")
					counter++;
			}
			if (counter > 0)
				tank.setLocation(tank.getX(), tank.getY());
			else
				tank.setLocation(tank.getX() - 1, tank.getY());
//			distance1++;
			System.out.println(tank.tankAngle);
			System.out.println("Ruch o pixel w lewo.");
		}

		if (e.getKeyCode() == moveRight) {
				tank.tankAngle = (double) 0;
				tank.repaint();

			int counter = 0;
			for (int i = 0; i <= 49; i++) {
				objectName = tank.getParent().getComponentAt(tank.getX() + 50, tank.getY() + i).getName();
				if (tank.getParent().getComponentAt(tank.getX() + 50, tank.getY() + i).isVisible()==true)
				if (objectName == "barrier" || objectName == "field" || objectName == "wall" || objectName == "tank1" || objectName == "tank2" || objectName == "enemy" || objectName == "border")
					counter++;
			}
			if (counter > 0)
				tank.setLocation(tank.getX(), tank.getY());
			else
				tank.setLocation(tank.getX() + 1, tank.getY());
//			distance1++;
			System.out.println(tank.tankAngle);
			System.out.println("Ruch o pixel w prawo.");
			System.out.println(counter);
		}
		
		if (e.getKeyCode() == shoot) {
			if (tank.tankAngle == - Math.PI/2) {
				tank.pociski.get(bullets).bulletAngle = - Math.PI/2;
				tank.pociski.get(bullets).setBounds(tank.getX()+15, tank.getY()-20, 20, 20);
				tank.pociski.get(bullets).repaint();
				tank.pociski.get(bullets).setVisible(true);
				System.out.println("Bullet is shot upwards");
				}
			if (tank.tankAngle == (double) 0) {
				tank.pociski.get(bullets).bulletAngle = (double) 0;
				tank.pociski.get(bullets).setBounds(tank.getX()+50, tank.getY()+15, 20, 20);
				tank.pociski.get(bullets).repaint();
				tank.pociski.get(bullets).setVisible(true);
			System.out.println("Bullet is shot downwards");
			}
			if (tank.tankAngle == Math.PI/2) {
				tank.pociski.get(bullets).bulletAngle = Math.PI/2;
				tank.pociski.get(bullets).setBounds(tank.getX()+15, tank.getY()+50, 20, 20);
				tank.pociski.get(bullets).repaint();
				tank.pociski.get(bullets).setVisible(true);
				System.out.println("Bullet is shot to the left");
				}
			if (tank.tankAngle == Math.PI) {
				tank.pociski.get(bullets).bulletAngle = Math.PI;
				tank.pociski.get(bullets).setBounds(tank.getX()-20, tank.getY()+15, 20, 20);
				tank.pociski.get(bullets).repaint();
				tank.pociski.get(bullets).setVisible(true);
				System.out.println("Bullet is shot to the right");
				}
			bullets--;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
