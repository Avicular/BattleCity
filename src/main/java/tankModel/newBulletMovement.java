package tankModel;

import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class newBulletMovement extends TimerTask {
	
	public newBullet bullet;
	public ArrayList<newBullet> pociski; 
	public int counter;
	public int score1 = 0;
	public int score2 = 0;
	public String objectName = null;
	public String bulletName = null;
	public newTank tank;
	public newTank target;
	public JLabel score;
	public JLabel lifeOne;
	public JLabel lifeTwo;
	public JLabel lifeThree;
	
	public newBulletMovement(newBullet bullet, newTank tank, JLabel score, newTank target, JLabel lifeOne, JLabel lifeTwo, JLabel lifeThree) {
		this.bullet = bullet;
		this.tank = tank;
		this.score = score;
		this.target = target;
		this.lifeOne = lifeOne;
		this.lifeTwo = lifeTwo;
		this.lifeThree = lifeThree;
	}
	
	
	@Override
	public void run() {
		
		if (this.bullet.isVisible() == true)
			if (this.bullet.bulletAngle == -Math.PI/2) {
				counter = 0;
				bulletName = bullet.getName();
				for (int i = 0; i <= 7; i++) {
				objectName = bullet.getParent().getComponentAt(bullet.getX() + i, bullet.getY() - 1).getName();
				if (bullet.getParent().getComponentAt(bullet.getX() + i, bullet.getY() - 1).isVisible()==true)
					if (objectName == "barrier" || objectName == "wall" || objectName == "enemy" || objectName == "tank1" || objectName == "tank2" || objectName == "border")
						counter++;
					}
				if (counter > 0) {
				this.bullet.setLocation(this.bullet.getX(), this.bullet.getY());
				this.bullet.setVisible(false);
					if (objectName == "wall")
						bullet.getParent().getComponentAt(bullet.getX() + 7, bullet.getY() - 1).setVisible(false);
					else if (objectName == "enemy" && bulletName == "bulletP1") {
						bullet.getParent().getComponentAt(bullet.getX() + 7, bullet.getY() - 1).setVisible(false);
						tank.score = tank.score + 300;
						score.setText(Integer.toString(tank.score));
						System.out.println(tank.score);
					}
					else if (objectName == "enemy" && bulletName == "bulletP2") {
						bullet.getParent().getComponentAt(bullet.getX() + 7, bullet.getY() - 1).setVisible(false);
						tank.score = tank.score + 300;
						score.setText(Integer.toString(tank.score));
						System.out.println(score2);
					}
					else if (objectName == "tank1" && (bulletName == "bulletEnemy")) {
						target.hitpoints--;
						System.out.println("tank hitpoints:" + target.hitpoints);
						if (target.hitpoints == 2)
							lifeThree.setIcon(new ImageIcon("src/main/resources/images/tank_life_icon_red_empty_15x15.png"));
						else if (target.hitpoints == 1)
							lifeTwo.setIcon(new ImageIcon("src/main/resources/images/tank_life_icon_red_empty_15x15.png"));
						else if (target.hitpoints == 0) {
							lifeOne.setIcon(new ImageIcon("src/main/resources/images/tank_life_icon_red_empty_15x15.png"));
							bullet.getParent().getComponentAt(bullet.getX() + 7, bullet.getY() - 1).setVisible(false);
							System.out.println("GAME OVER");
						}
					}
				}
				else	
				this.bullet.setLocation(this.bullet.getX(), this.bullet.getY()-4);
			} 
			else if (this.bullet.bulletAngle == (double) 0){
				counter = 0;
				bulletName = bullet.getName();
				for (int i = 0; i <= 7; i++) {
				objectName = bullet.getParent().getComponentAt(bullet.getX() + 21, bullet.getY() + i).getName();
				if (bullet.getParent().getComponentAt(bullet.getX() + 21, bullet.getY() + i).isVisible()==true)
					if (objectName == "barrier" || objectName == "wall" || objectName == "enemy" || objectName == "tank1" || objectName == "tank2" || objectName == "border")
						counter++;
					}
				if (counter > 0) {
				this.bullet.setLocation(this.bullet.getX(), this.bullet.getY());
				this.bullet.setVisible(false);
					if (objectName == "wall") 
						bullet.getParent().getComponentAt(bullet.getX() + 21, bullet.getY() + 7).setVisible(false);
					else if (objectName == "enemy" & bulletName == "bulletP1") {
						bullet.getParent().getComponentAt(bullet.getX() + 21, bullet.getY() + 7).setVisible(false);
						tank.score = tank.score + 300;
						score.setText(Integer.toString(tank.score));
						System.out.println(tank.score);
					}
					else if (objectName == "enemy" && bulletName == "bulletP2") {
						bullet.getParent().getComponentAt(bullet.getX() + 21, bullet.getY() + 7).setVisible(false);
						tank.score = tank.score + 300;
						score.setText(Integer.toString(tank.score));
						System.out.println(tank.score);
					}						
					else if (objectName == "tank1" && (bulletName == "bulletEnemy")) {
						target.hitpoints--;
						System.out.println("tank hitpoints:" + target.hitpoints);
						if (target.hitpoints == 2)
							lifeThree.setIcon(new ImageIcon("src/main/resources/images/tank_life_icon_red_empty_15x15.png"));
						else if (target.hitpoints == 1)
							lifeTwo.setIcon(new ImageIcon("src/main/resources/images/tank_life_icon_red_empty_15x15.png"));
						else if (target.hitpoints == 0) {
							lifeOne.setIcon(new ImageIcon("src/main/resources/images/tank_life_icon_red_empty_15x15.png"));
							bullet.getParent().getComponentAt(bullet.getX() + 21, bullet.getY() + 7).setVisible(false);
							System.out.println("GAME OVER");
						}
					}
				}
				else	
				this.bullet.setLocation(this.bullet.getX()+4, this.bullet.getY());
			}
			else if (this.bullet.bulletAngle == Math.PI/2){
				counter = 0;
				bulletName = bullet.getName();
				for (int i = 0; i <= 7; i++) {
				objectName = bullet.getParent().getComponentAt(bullet.getX() + i, bullet.getY() + 21).getName();
				if (bullet.getParent().getComponentAt(bullet.getX() + i, bullet.getY() + 21).isVisible()==true)
					if (objectName == "barrier" || objectName == "wall" || objectName == "enemy" || objectName == "tank1" || objectName == "tank2" || objectName == "border")
						counter++;
					}
				if (counter > 0) {
				this.bullet.setLocation(this.bullet.getX(), this.bullet.getY());
				this.bullet.setVisible(false);
					if (objectName == "wall")
						bullet.getParent().getComponentAt(bullet.getX() + 8, bullet.getY() + 21).setVisible(false);	
					else if (objectName == "enemy" && bulletName == "bulletP1") {
						bullet.getParent().getComponentAt(bullet.getX() + 8, bullet.getY() + 21).setVisible(false);	
						tank.score = tank.score + 300;
						score.setText(Integer.toString(tank.score));
						System.out.println(tank.score);
					} else if (objectName == "enemy" && bulletName == "bulletP2") {
						bullet.getParent().getComponentAt(bullet.getX() + 8, bullet.getY() + 21).setVisible(false);	
						tank.score = tank.score + 300;
						score.setText(Integer.toString(tank.score));
						System.out.println(tank.score);
					}
					else if (objectName == "tank1" && (bulletName == "bulletEnemy")) {
						target.hitpoints--;
						System.out.println("tank hitpoints:" + target.hitpoints);
						if (target.hitpoints == 2)
							lifeThree.setIcon(new ImageIcon("src/main/resources/images/tank_life_icon_red_empty_15x15.png"));
						else if (target.hitpoints == 1)
							lifeTwo.setIcon(new ImageIcon("src/main/resources/images/tank_life_icon_red_empty_15x15.png"));
						else if (target.hitpoints == 0) {
							bullet.getParent().getComponentAt(bullet.getX() + 8, bullet.getY() + 21).setVisible(false);
							lifeOne.setIcon(new ImageIcon("src/main/resources/images/tank_life_icon_red_empty_15x15.png"));
							System.out.println("GAME OVER");
						}
					}
				}
				else	
				this.bullet.setLocation(this.bullet.getX(), this.bullet.getY()+4);
			}
			else if (this.bullet.bulletAngle == Math.PI){
				counter = 0;
				bulletName = bullet.getName();
				for (int i = 0; i <= 7; i++) {
				objectName = bullet.getParent().getComponentAt(bullet.getX() - 1, bullet.getY() + i).getName();
				if (bullet.getParent().getComponentAt(bullet.getX() - 1, bullet.getY() + i).isVisible()==true)
					if (objectName == "barrier" || objectName == "wall" || objectName == "enemy" || objectName == "tank1" || objectName == "tank2" || objectName == "border")
						counter++;
					}
				if (counter > 0) {
				this.bullet.setLocation(this.bullet.getX(), this.bullet.getY());
				this.bullet.setVisible(false);
					if (objectName == "wall")
						bullet.getParent().getComponentAt(bullet.getX() -1, bullet.getY() + 8).setVisible(false);
					else if (objectName == "enemy" && bulletName == "bulletP1") {
						bullet.getParent().getComponentAt(bullet.getX() -1, bullet.getY() + 8).setVisible(false);
						tank.score = tank.score + 300;
						score.setText(Integer.toString(tank.score));
						System.out.println(tank.score);
					} else if (objectName == "enemy" && bulletName == "bulletP2") {
						bullet.getParent().getComponentAt(bullet.getX() -1, bullet.getY() + 8).setVisible(false);
						tank.score = tank.score + 300;
						score.setText(Integer.toString(tank.score));
						System.out.println(tank.score);
					}
					else if (objectName == "tank1" && (bulletName == "bulletEnemy")) {
						target.hitpoints--;
						System.out.println("tank hitpoints:" + target.hitpoints);
						if (target.hitpoints == 2) {
							lifeThree.removeAll();
							lifeThree.setIcon(new ImageIcon("src/main/resources/images/tank_life_icon_red_empty_15x15.png"));
						}
						else if (target.hitpoints == 1) {
							lifeTwo.removeAll();
							lifeTwo.setIcon(new ImageIcon("src/main/resources/images/tank_life_icon_red_empty_15x15.png"));
						}
						else if (target.hitpoints == 0) {
							bullet.getParent().getComponentAt(bullet.getX() -1, bullet.getY() + 8).setVisible(false);
							lifeOne.removeAll();
							lifeOne.setIcon(new ImageIcon("src/main/resources/images/tank_life_icon_red_empty_15x15.png"));
							System.out.println("GAME OVER");
						}
					}
				}
				else	
				this.bullet.setLocation(this.bullet.getX()-4, this.bullet.getY());
			}
	}

}
